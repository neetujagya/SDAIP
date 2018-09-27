package com.novare.sdaip.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TaskTest {

    @Test
    public void shouldCreateTask() {
        Task task = new Task();

        Assert.assertNotNull(task);
        Assert.assertEquals(0, task.getTaskId());
        Assert.assertNull(task.getTitle());
    }

    @Test
    public void shouldCreateTaskWithValues() {
        Task task = new Task("title", new Date(),TaskStatus.NEW, 1 );

        Assert.assertNotNull(task);
        Assert.assertEquals("title", task.getTitle());
        Assert.assertNotNull(task.getDueDate());
        Assert.assertEquals(TaskStatus.NEW, task.getStatus());
        //Assert.assertNotNull(task.getProject());
        Assert.assertEquals(1, task.getTaskId());
    }
}
