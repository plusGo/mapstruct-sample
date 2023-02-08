package com.henry;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-08T11:11:15+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
class ExtendMappingImpl implements ExtendMapping {

    @Override
    public DestObj map(Child child) {
        if ( child == null ) {
            return null;
        }

        DestObj destObj = new DestObj();

        destObj.setName( child.getName() );
        destObj.setCode( child.getCode() );

        return destObj;
    }
}
