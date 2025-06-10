package com.pismo.transaction.controller;

import com.pismo.transaction.model.Account;
import com.pismo.transaction.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void shouldCreateAndReturnAccount() throws Exception {
        String json = "{\"document_number\": \"99999999999\"}";

        mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.document_number", is("99999999999")));

        Account account = accountRepository.findAll().iterator().next();

        mockMvc.perform(get("/accounts/" + account.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.document_number", is("99999999999")));
    }
}
