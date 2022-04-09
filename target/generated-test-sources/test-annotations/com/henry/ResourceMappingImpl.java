package com.henry;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-09T11:40:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
class ResourceMappingImpl implements ResourceMapping {

    @Override
    public void updatePoByDto(ResourceDTO dto, ResourcePO po) {
        if ( dto == null ) {
            return;
        }

        po.setName( dto.getModifiedName() );
    }
}
