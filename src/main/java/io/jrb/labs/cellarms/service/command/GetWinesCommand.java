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
package io.jrb.labs.cellarms.service.command;

import io.jrb.labs.cellarms.domain.WineEntity;
import io.jrb.labs.cellarms.mapper.WineMapper;
import io.jrb.labs.cellarms.repository.WineRepository;
import io.jrb.labs.cellarms.resource.WineResource;
import io.jrb.labs.common.service.command.entity.GetEntitiesCommand;
import org.springframework.stereotype.Component;

@Component
public class GetWinesCommand extends GetEntitiesCommand<WineResource, WineEntity> {

    public GetWinesCommand(final WineMapper wineMapper, final WineRepository repository) {
        super("wine", wineMapper::wineEntityToWineResource, repository);
    }

}
