package sideproject1.contact.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sideproject1.contact.controller.dto.PersonDto;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PersonControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .alwaysDo(print())
                .build();
    }

    @Test
    void getPerson() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/person/1"))
                .andExpect(status().isOk());
    }

    @Test
    void postPerson() throws Exception {

        PersonDto personDto = PersonDto.of("seongju","010-3925-1533");

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/person?name=seongju&phoneNumber=010-3925-1533")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"name\":\"seongju\",\n" +
                        "  \"phoneNumber\": \"010-3925-1533\"\n" +
                        "}"))
                .andExpect(status().isCreated());
    }
}