package com.henry;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-09T10:31:21+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
class UserMappingImpl implements UserMapping {

    @Override
    public UserPO dtoToPo(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserPO userPO = new UserPO();

        userPO.setName( userDTO.getName() );

        return userPO;
    }
}
