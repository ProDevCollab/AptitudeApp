package com.javaProject.AptitudeApp.controller;

import com.javaProject.AptitudeApp.dto.CategoryDto;
import com.javaProject.AptitudeApp.dto.TopicDto;
import com.javaProject.AptitudeApp.service.Impl.HomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
public class HomeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HomeService homeService;

    @Test
    public void testGetAllCategories() throws Exception {
        Mockito.when(homeService.getAllCategories())
                .thenReturn(
                        List.of(
                                new CategoryDto(1L, "Quantitative Aptitude"),
                                new CategoryDto(2L, "Logical Aptitude"))
                );

        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].categoryName").value("Quantitative Aptitude"))
                .andExpect(jsonPath("$[1].categoryName").value("Logical Aptitude"));
    }

    @Test
    public void testGetAllCategories_EmptyList() throws Exception {
        Mockito.when(homeService.getAllCategories())
                .thenReturn(List.of());

        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    public void testGetTopicsByCategoryId() throws Exception {
        Long categoryId = 1L;
        Mockito.when(homeService.getTopicsByCategory(categoryId))
                .thenReturn(
                        List.of(
                                new TopicDto(1L, "Time and Work","time-and-work"),
                                new TopicDto(2L, "Time and Distance","time-and-distance"),
                                new TopicDto(3L, "Boats and Streams","boats-and-streams"))
                );

        mockMvc.perform(get("/categories/{categoryId}/topics", categoryId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].topicName").value("Time and Work"))
                .andExpect(jsonPath("$[1].topicName").value("Time and Distance"))
                .andExpect(jsonPath("$[2].topicName").value("Boats and Streams"));
    }

    @Test
    public void testGetTopicsByCategoryId_EmptyList() throws Exception {
        Long categoryId = 1L;
        Mockito.when(homeService.getTopicsByCategory(categoryId))
                .thenReturn(List.of());

        mockMvc.perform(get("/categories/{categoryId}/topics", categoryId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(0));
    }

    @Test
    public void testGetTopicsByCategoryId_InvalidId() throws Exception {
        Long categoryId = 999L;
        Mockito.when(homeService.getTopicsByCategory(categoryId))
                .thenReturn(List.of());

        mockMvc.perform(get("/categories/{categoryId}/topics", categoryId))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string(""));
    }

    @Test
    public void testGetTopicsByCategoryId_MissingId() throws Exception {

        mockMvc.perform(get("/categories/{categoryId}/topics", ""))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetTopicsByCategoryId_WrongTypeId() throws Exception {
        String categoryId = "abc";

        mockMvc.perform(get("/categories/{categoryId}/topics", categoryId))
                .andExpect(status().isBadRequest());
    }


}
