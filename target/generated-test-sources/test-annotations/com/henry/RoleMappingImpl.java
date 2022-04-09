package com.henry;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-09T11:27:38+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
class RoleMappingImpl implements RoleMapping {

    @Override
    public RolePO dtoToPo(RoleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RolePO rolePO = new RolePO();

        rolePO.setName( dto.getRoleName() );
        rolePO.setCount( dto.getRoleCount() );

        return rolePO;
    }

    @Override
    public RolePO voToPo(RoleVO vo) {
        if ( vo == null ) {
            return null;
        }

        RolePO rolePO = new RolePO();

        rolePO.setName( vo.getRoleName() );
        rolePO.setCount( vo.getRoleCount() );

        return rolePO;
    }
}
