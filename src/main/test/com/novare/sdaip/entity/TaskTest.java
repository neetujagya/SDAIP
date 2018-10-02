package com.novare.sdaip.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TaskTest {



    @Test
    public void shouldCreateTaskWithValues() {
        Task task = new Task("title", new Date(),TaskStatus.NEW, "project" );

        Assert.assertNotNull(task);
        Assert.assertEquals("title", task.getTitle());
        Assert.assertNotNull(task.getDueDate());
        Assert.assertEquals(TaskStatus.NEW, task.getStatus());
        //Assert.assertNotNull(task.getProject());
        Assert.assertEquals("project", task.getProject());
    }
}
