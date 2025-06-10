package com.pismo.transaction.controller;

import com.pismo.transaction.model.Account;
import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.repository.AccountRepository;
import com.pismo.transaction.repository.OperationTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionFlowTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    private Long accountId;

    @BeforeEach
    void setup() {
        Account account = new Account();
        account.setDocumentNumber("88888888888");
        accountId = accountRepository.save(account).getId();

        operationTypeRepository.save(new OperationType(1L, "Normal Purchase"));
    }

    @Test
    void shouldCreateTransactionSuccessfully() throws Exception {
        String transactionJson = """
                {
                  "account_id": %d,
                  "operation_type_id": 1,
                  "amount": 50.0
                }
                """.formatted(accountId);

        mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(transactionJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amount", lessThanOrEqualTo(0.0)));
    }
}
