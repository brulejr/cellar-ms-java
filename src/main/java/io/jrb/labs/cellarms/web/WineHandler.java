/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2021 Jon Brule <brulejr@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.jrb.labs.cellarms.web;

import io.jrb.labs.cellarms.resource.WineResource;
import io.jrb.labs.cellarms.service.WineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class WineHandler {

    private final WineService wineService;

    public WineHandler(final WineService wineService) {
        this.wineService = wineService;
    }

    public Mono<ServerResponse> createWine(final ServerRequest serverRequest) {
        final Mono<WineResource> wineResourceMono = serverRequest.bodyToMono(WineResource.class);
        return wineResourceMono.flatMap(wine ->
                ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(wineService.createWine(wine), WineResource.class)
        );
    }

    public Mono<ServerResponse> findWine(final ServerRequest serverRequest) {
        final String wineGuid = serverRequest.pathVariable("guid");
        final Mono<WineResource> wineResourceMono = wineService.findWineByGuid(wineGuid);
        return wineResourceMono.flatMap(wine ->
                ServerResponse.ok()
                        .body(fromValue(wine)))
                .switchIfEmpty(ServerResponse.notFound().build())
                ;
    }

    public  Mono<ServerResponse> getAllWines(final ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(wineService.retrieveWines(), WineResource.class);
    }

}
