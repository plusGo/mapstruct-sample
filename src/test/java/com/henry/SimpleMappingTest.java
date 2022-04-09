package com.henry;

import lombok.Builder;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Data
class UserPO {
    private String name;
}

@Data
@Builder
class UserDTO {
    private String name;
}

@Mapper
interface UserMapping {
    UserPO dtoToPo(final UserDTO userDTO);
}

public class SimpleMappingTest {

    @Test
    public void should_mapping() {
        // given
        final UserDTO dto = UserDTO.builder()
                .name("张三")
                .build();
        final UserMapping mapping = Mappers.getMapper(UserMapping.class);

        // when
        final UserPO po = mapping.dtoToPo(dto);

        // then
        Assert.assertEquals(dto.getName(), po.getName());
    }
}