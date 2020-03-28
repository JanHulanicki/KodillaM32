package com.crud.tasks.service;
import com.crud.tasks.domain.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DbServiceTestSuite {
    @Autowired
    DbService dbService;

    @Test
    public void testDbServiceGetAllTasks() {
        //Given
        Task task = new Task();
        task.setContent("content");
        task.setTitle("title");
        List<Task> taskList = new ArrayList<>();
        //when
        dbService.saveTask(task);
        taskList = dbService.getAllTasks();
        Optional<Task> taskById = dbService.getTaskById(task.getId());
        //Then
        Assert.assertTrue(taskById.isPresent());
        Assert.assertFalse(taskList.isEmpty());
    }
}
