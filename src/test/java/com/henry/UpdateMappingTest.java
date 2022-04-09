package com.henry;

import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Data
@Builder
class ResourcePO {
    private String id;
    private String name; // 名称
}


@Data
@Builder
class ResourceDTO {
    private String modifiedName; // 名称
}

@Mapper
interface ResourceMapping {
    @Mapping(source = "modifiedName", target = "name")
    void updatePoByDto(final ResourceDTO dto, @MappingTarget final ResourcePO po);

}

public class UpdateMappingTest {

    @Test
    public void should_mapping() {
        // given
        final ResourceDTO dto = ResourceDTO.builder()
                .modifiedName("新名字")
                .build();

        final ResourcePO po = ResourcePO.builder()
                .id("1")
                .name("老名字")
                .build();


        final ResourceMapping mapping = Mappers.getMapper(ResourceMapping.class);

        // when
        mapping.updatePoByDto(dto, po);

        // then
        Assert.assertEquals("1", po.getId());
        Assert.assertEquals("新名字", po.getName());
    }
}