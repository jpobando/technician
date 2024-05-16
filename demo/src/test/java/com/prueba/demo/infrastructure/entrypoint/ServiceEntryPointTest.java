package com.prueba.demo.infrastructure.entrypoint;

import com.prueba.demo.infrastructure.entrypoint.dto.ServiceDto;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class ServiceEntryPointTest{

    String uri = "/service";
    ServiceDto serviceDto = new ServiceDto();

    String inputJson = super.mapToJson(product);
    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(inputJson)).andReturn();

    int status = mvcResult.getResponse().getStatus();
    assertEquals(201, status);
    String content = mvcResult.getResponse().getContentAsString();
    assertEquals(content, "Product is created successfully");
}