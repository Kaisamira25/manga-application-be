package com.alpha.mangaapplication.controllerTest;

import com.alpha.mangaapplication.dto.request.RegisterDTO;
import com.alpha.mangaapplication.service.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TestRegisterController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RegisterService registerService;

    @Autowired
    private ObjectMapper mapper;
    @Test
    public void testRegisterEndPoint() throws Exception{
        RegisterDTO registerDTO = new RegisterDTO("thienthan726@gmail.com","Do Nguyen Trong Hieu","Hieu123456!");
        when(registerService.register(registerDTO)).thenReturn(1);

        String jsonDto = mapper.writeValueAsString(registerDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/register")
                .content(jsonDto)
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
