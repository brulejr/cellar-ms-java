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
package io.jrb.labs.common.web;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
public class GlobalErrorAttributes extends DefaultErrorAttributes {

    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private String message;

    @Override
    public Map<String, Object> getErrorAttributes(
            final ServerRequest request,
            final ErrorAttributeOptions options
    ) {
        final Throwable error = getError(request);
        final Map<String, Object> map = super.getErrorAttributes(request, options);
        map.put("status", getStatus());
        map.put("error", error.getMessage());
        return map;
    }

}
