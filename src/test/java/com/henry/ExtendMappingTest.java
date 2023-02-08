package com.henry;

import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

class Parent {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}


class Child extends Parent {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }
}

class DestObj {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }
}


@Mapper
interface ExtendMapping {
    DestObj map(final Child child);
}

public class ExtendMappingTest {

    @Test
    public void should_mapping() {
        // given
        final Child child = new Child();
        child.setName("name");
        child.setCode("code");
        final ExtendMapping mapping = Mappers.getMapper(ExtendMapping.class);

        // when
        final DestObj po = mapping.map(child);

        // then
        Assert.assertEquals("name", po.getName());
        Assert.assertEquals("code", po.getCode());
    }
}