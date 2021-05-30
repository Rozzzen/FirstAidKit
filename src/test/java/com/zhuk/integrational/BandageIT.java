package com.zhuk.integrational;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhuk.domain.Bandage;
import com.zhuk.domain.Material;
import com.zhuk.service.BandageService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BandageIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BandageService bandageService;

    @Test
    public void validationExceptionCaughtTest() throws Exception {

        Bandage bandage = new Bandage(10L, 1000, 1000, "test bandage", Material.CLOTH);

        mockMvc.perform(post("/bandages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(bandage)))
                .andExpect(status().isBadRequest())
                .andExpect(mvcResult -> Assert.assertTrue(mvcResult.getResolvedException() instanceof MethodArgumentNotValidException));
    }

    @Test
    public void validationPassedTest() throws Exception {

        Bandage bandage = new Bandage(10L, 10, 1000, "test bandage", Material.CLOTH);

        mockMvc.perform(post("/bandages")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(bandage)))
                .andExpect(status().isOk());

    }

}
