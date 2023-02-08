package com.henry;

import java.time.format.DateTimeFormatter;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-08T11:11:15+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
class CarMappingImpl implements CarMapping {

    @Override
    public CarPO dtoToPo(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        CarPO carPO = new CarPO();

        carPO.setName( carDTO.getCarName() );
        carPO.setTags( tagListToTags( carDTO.getTagList() ) );
        carPO.setPrice( carDTOPricePrice( carDTO ) );
        if ( carDTO.getCount() != null ) {
            carPO.setCount( carDTO.getCount() );
        }
        else {
            carPO.setCount( (long) 10L );
        }
        if ( carDTO.getCreatedTime() != null ) {
            carPO.setCreatedTime( DateTimeFormatter.ofPattern( "yyyy-MM-dd" ).format( carDTO.getCreatedTime() ) );
        }
        if ( carDTO.getColor() != null ) {
            carPO.setColor( carDTO.getColor().name() );
        }

        carPO.setTypeName( "汽车" );

        return carPO;
    }

    private String carDTOPricePrice(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }
        Price price = carDTO.getPrice();
        if ( price == null ) {
            return null;
        }
        String price1 = price.getPrice();
        if ( price1 == null ) {
            return null;
        }
        return price1;
    }
}
