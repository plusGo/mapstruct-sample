package com.henry;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
class CarPO {
    private String name; // 名称
    private String tags; // 标签，多个，逗号隔开
    private String price; // 价格
    private String description; // 描述
    private Long count; // 数量
    private String createdTime; // 创建时间
    private String typeName; // 类型名称
    private String color; // 颜色
}

enum CarColor {
    RED, GREEN;
}

@Data
@AllArgsConstructor
class Price {
    private String price; // 价格
}

@Data
@Builder
class CarDTO {
    private String carName; // 名称
    private List<String> tagList; // 标签集合，多个，集合
    private Price price; // 价格
    private String description; // 描述
    private Long count; // 数量
    private LocalDateTime createdTime; // 创建时间
    private CarColor color; // 颜色
}

@Mapper
interface CarMapping {
    @Mapping(source = "carName", target = "name") // 不同名字段映射
    @Mapping(source = "tagList", target = "tags", qualifiedByName = "tagListToTags") // 自定义字段的映射逻辑
    @Mapping(source = "price.price", target = "price") // 嵌套对象
    @Mapping(target = "description", ignore = true) // 阻止映射
    @Mapping(target = "count", defaultValue = "10L") // 默认值
    @Mapping(target = "createdTime", dateFormat = "yyyy-MM-dd") // 日期格式化
    @Mapping(target = "typeName", constant = "汽车") // 设置为固定值
    CarPO dtoToPo(final CarDTO carDTO);

    @Named("tagListToTags")
    default String tagListToTags(final List<String> tagList) {
        return Optional.ofNullable(tagList)
                .map($tagList -> String.join(",", $tagList))
                .orElse(null);
    }
}

public class BasicMappingTest {

    @Test
    public void should_mapping() {
        // given
        final CarDTO dto = CarDTO.builder()
                .carName("宝马")
                .tagList(Arrays.asList("豪车", "德国"))
                .price(new Price("20.0000"))
                .description("宝马的描述")
                .createdTime(LocalDateTime.now())
                .color(CarColor.GREEN)
                .build();
        final CarMapping mapping = Mappers.getMapper(CarMapping.class);

        // when
        final CarPO po = mapping.dtoToPo(dto);

        // then
        Assert.assertEquals("宝马", po.getName());
        Assert.assertEquals("豪车,德国", po.getTags());
        Assert.assertEquals("20.0000", po.getPrice());
        Assert.assertEquals(10L, po.getCount(), 0);
        Assert.assertEquals("汽车", po.getTypeName());
        Assert.assertEquals("GREEN", po.getColor());
        Assert.assertNull(po.getDescription());
        Assert.assertNotNull(po.getCreatedTime());
    }
}