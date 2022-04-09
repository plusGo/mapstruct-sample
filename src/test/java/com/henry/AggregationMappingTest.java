package com.henry;

import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Data
class RolePO {
    private String name; // 名称
    private Long count; // 数量
}


@Data
@Builder
class RoleDTO {
    private String roleName; // 名称
    private Long roleCount; // 数量
}

@Data
@Builder
class RoleVO {
    private String roleName; // 名称
    private Long roleCount; // 数量
}

@Retention(RetentionPolicy.CLASS)
@Mapping(target = "name", source = "roleName")
@Mapping(target = "count", source = "roleCount")
@interface ToEntity {
}

@Mapper
interface RoleMapping {
    @ToEntity
    RolePO dtoToPo(final RoleDTO dto);

    @ToEntity
    RolePO voToPo(final RoleVO vo);
}

public class AggregationMappingTest {

    @Test
    public void should_mapping_dto() {
        // given
        final RoleDTO dto = RoleDTO.builder()
                .roleName("管理员")
                .roleCount(1L)
                .build();
        final RoleMapping mapping = Mappers.getMapper(RoleMapping.class);

        // when
        final RolePO po = mapping.dtoToPo(dto);

        // then
        Assert.assertEquals("管理员", po.getName());
        Assert.assertEquals(1L, po.getCount(), 0);
    }

    @Test
    public void should_mapping_vo() {
        // given
        final RoleVO vo = RoleVO.builder()
                .roleName("管理员")
                .roleCount(1L)
                .build();
        final RoleMapping mapping = Mappers.getMapper(RoleMapping.class);

        // when
        final RolePO po = mapping.voToPo(vo);

        // then
        Assert.assertEquals("管理员", po.getName());
        Assert.assertEquals(1L, po.getCount(), 0);
    }
}