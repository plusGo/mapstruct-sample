package com.henry;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-09T11:39:37+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
class OrderInfoMappingImpl implements OrderInfoMapping {

    @Override
    public OrderInfo personAndAddressToOrderInfo(Person person, Address address, String amount) {
        if ( person == null && address == null && amount == null ) {
            return null;
        }

        OrderInfo orderInfo = new OrderInfo();

        if ( person != null ) {
            orderInfo.setName( person.getName() );
        }
        if ( address != null ) {
            orderInfo.setCity( address.getCity() );
            orderInfo.setProvince( address.getProvince() );
        }
        if ( amount != null ) {
            orderInfo.setAmount( amount );
        }

        return orderInfo;
    }
}
