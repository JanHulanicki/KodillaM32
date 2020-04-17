package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaskMapper taskMapper;
    @MockBean
    private DbService service;

    @Test
    void TestGetEmptyTask() throws Exception {
        //Given
        List<TaskDto> taskList = new ArrayList<>();
        when(taskMapper.mapToTaskDtoList(service.getAllTasks())).thenReturn(taskList);
        //When @ Then
        mockMvc.perform(get("/v1/tasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //Trello boards fields
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void TestGetTasks() throws Exception {
        //Given
        List<TaskDto> taskList = new ArrayList<>();
        taskList.add(new TaskDto(1l, "title1", "content1"));
        when(taskMapper.mapToTaskDtoList(service.getAllTasks())).thenReturn(taskList);
        //When & Then
        mockMvc.perform(get("/v1/tasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].title", is("title1")))
                .andExpect(jsonPath("$[0].content", is("content1")));
    }

    @Test
    void getTaskById() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title1", "content1");
        Task task = new Task(1L, "title1", "content1");
        when(service.getTaskById(1L)).thenReturn(Optional.ofNullable(task));
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When & Then
        mockMvc.perform(get("/v1/tasks/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("title1")))
                .andExpect(jsonPath("$.content", is("content1")));
    }

    @Test
    void testCreateTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title1", "content1");
        Task task = new Task(1L, "title1", "content1");
        when(taskMapper.mapToTask(ArgumentMatchers.any())).thenReturn(task);
        when(service.saveTask(task)).thenReturn(ArgumentMatchers.any());
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(post("/v1/tasks").contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdateTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title1", "content1");
        Task task = new Task(1L, "title1", "content1");
        when(taskMapper.mapToTask(ArgumentMatchers.any())).thenReturn(task);
        when(service.saveTask(task)).thenReturn(ArgumentMatchers.any());
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        //When & Then
        mockMvc.perform(put("/v1/tasks").contentType(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("title1")))
                .andExpect(jsonPath("$.content", is("content1")));
    }

    @Test
    void deleteById() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title1", "content1");
        Task task = new Task(1L, "title1", "content1");
        when(service.getTaskById(1L)).thenReturn(Optional.ofNullable(task));
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When & Then
        mockMvc.perform(delete("/v1/tasks/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}