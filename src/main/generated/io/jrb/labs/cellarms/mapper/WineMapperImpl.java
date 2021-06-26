package io.jrb.labs.cellarms.mapper;

import io.jrb.labs.cellarms.domain.WineEntity;
import io.jrb.labs.cellarms.domain.WineEntity.WineEntityBuilder;
import io.jrb.labs.cellarms.resource.AddWine;
import io.jrb.labs.cellarms.resource.WineResource;
import io.jrb.labs.cellarms.resource.WineResource.WineResourceBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-06-26T09:23:53-0400",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class WineMapperImpl implements WineMapper {

    @Override
    public WineEntity addWineToWineEntity(AddWine addWine) {
        if ( addWine == null ) {
            return null;
        }

        WineEntityBuilder wineEntity = WineEntity.builder();

        wineEntity.name( addWine.getName() );
        wineEntity.type( addWine.getType() );
        wineEntity.vintage( addWine.getVintage() );
        wineEntity.producer( addWine.getProducer() );
        wineEntity.varietal( addWine.getVarietal() );
        wineEntity.designation( addWine.getDesignation() );
        wineEntity.vineyard( addWine.getVineyard() );
        wineEntity.country( addWine.getCountry() );
        wineEntity.region( addWine.getRegion() );
        wineEntity.subregion( addWine.getSubregion() );
        wineEntity.appellation( addWine.getAppellation() );

        return wineEntity.build();
    }

    @Override
    public WineResource wineEntityToWineResource(WineEntity wineEntity) {
        if ( wineEntity == null ) {
            return null;
        }

        WineResourceBuilder wineResource = WineResource.builder();

        wineResource.guid( wineEntity.getGuid() );
        wineResource.name( wineEntity.getName() );
        wineResource.type( wineEntity.getType() );
        wineResource.vintage( wineEntity.getVintage() );
        wineResource.producer( wineEntity.getProducer() );
        wineResource.varietal( wineEntity.getVarietal() );
        wineResource.designation( wineEntity.getDesignation() );
        wineResource.vineyard( wineEntity.getVineyard() );
        wineResource.country( wineEntity.getCountry() );
        wineResource.region( wineEntity.getRegion() );
        wineResource.subregion( wineEntity.getSubregion() );
        wineResource.appellation( wineEntity.getAppellation() );

        return wineResource.build();
    }
}
