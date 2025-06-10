package com.pismo.transaction.controller;

import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.repository.OperationTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OperationTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OperationTypeRepository repository;

    @Test
    void shouldCreateAndListOperationTypes() throws Exception {
        String json = "{\"id\": 99, \"description\": \"Test Operation\"}";

        mockMvc.perform(post("/operation-types")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", is("Test Operation")));

        mockMvc.perform(get("/operation-types"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].id", hasItem(99)));
    }
}
