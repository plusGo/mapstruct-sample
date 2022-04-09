package com.henry;

import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Data
@Builder
class Address {
    private String province; // 省
    private String city; // 城市
}

@Data
@Builder
class Person {
    private String name; // 名称
    private String city; // 名称
}

@Data
class OrderInfo {
    private String province; // 省
    private String city; // 城市
    private String name; // 名称
    private String amount; // 金额
}


@Mapper
interface OrderInfoMapping {
    @Mapping(source = "address.city", target = "city")
        // 同名属性必须制定映射目标，否则编译失败
    OrderInfo personAndAddressToOrderInfo(final Person person, final Address address, final String amount);
}

public class SeveralMappingTest {

    @Test
    public void should_mapping() {
        // given
        final Address address = Address.builder()
                .province("四川")
                .city("成都")
                .build();

        final Person person = Person.builder()
                .name("张三")
                .city("资阳")
                .build();

        final OrderInfoMapping mapping = Mappers.getMapper(OrderInfoMapping.class);

        // when
        final OrderInfo po = mapping.personAndAddressToOrderInfo(person, address, "10万");

        // then
        Assert.assertEquals("四川", po.getProvince());
        Assert.assertEquals("成都", po.getCity());
        Assert.assertEquals("张三", po.getName());
        Assert.assertEquals("10万", po.getAmount());
    }

}