package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTestSuite {
    @Autowired
    TaskMapper taskMapper;

    @Test
    public void testMapTaskdDtoToTask() {
        //Given
        TaskDto taskDto = new TaskDto();
        taskDto.setId(1L);
        taskDto.setTitle("title1");
        taskDto.setContent("content1");
        //when
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(task.getId(), new Long(1L));
        assertEquals(task.getTitle(), "title1");
        assertEquals(task.getContent(), "content1");
    }

    @Test
    public void testMapTaskdToTaskDto() {
        //Given
        Task task = new Task();
        task.setId(1L);
        task.setTitle("title1");
        task.setContent("content1");
        //when
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(taskDto.getId(), new Long(1L));
        assertEquals(taskDto.getTitle(), "title1");
        assertEquals(taskDto.getContent(), "content1");
    }

    @Test
    public void testMapTaskdDtoList() {
        //Given
        Task task = new Task();
        task.setId(1L);
        task.setTitle("title1");
        task.setContent("content1");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        //when
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(taskDtoList.get(0).getId(), new Long(1L));
        assertEquals(taskDtoList.get(0).getTitle(), "title1");
        assertEquals(taskDtoList.get(0).getContent(), "content1");
    }

}
