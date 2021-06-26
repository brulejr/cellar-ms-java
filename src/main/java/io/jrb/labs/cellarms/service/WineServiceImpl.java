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
package io.jrb.labs.cellarms.service;

import io.jrb.labs.cellarms.mapper.WineMapper;
import io.jrb.labs.cellarms.repository.WineRepository;
import io.jrb.labs.cellarms.resource.AddWine;
import io.jrb.labs.cellarms.resource.WineResource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class WineServiceImpl implements WineService {

    private final WineMapper wineMapper;
    private final WineRepository wineRepository;

    public WineServiceImpl(final WineMapper wineMapper, final WineRepository wineRepository) {
        this.wineMapper = wineMapper;
        this.wineRepository = wineRepository;
    }

    @Override
    public Mono<WineResource> createWine(final AddWine addWine) {
        return Mono.just(addWine)
                .map(wineMapper::addWineToWineEntity)
                .map(wineEntity -> wineEntity.withGuid(UUID.randomUUID().toString()))
                .flatMap(wineRepository::save)
                .map(wineMapper::wineEntityToWineResource);
    }

    @Override
    public Mono<WineResource> findWineByGuid(final String guid) {
        return wineRepository.findByGuid(guid)
                .map(wineMapper::wineEntityToWineResource);
    }

    @Override
    public Flux<WineResource> retrieveWines() {
        return wineRepository.findAll()
                .map(wineMapper::wineEntityToWineResource);
    }

}
