package com.novare.sdaip.entity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.novare.sdaip.entity.Task;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskTest {

    private Task task1;
    private SimpleDateFormat dateFormat;
    private Date date;

    private static final String TITLE = "title";
    private static final String PROJECT = "project";


    @Before
    public void setUp() throws Exception
    {
        dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = dateFormat.parse("01-01-2020");
        task1 = new Task(TITLE, date, TaskStatus.NEW, PROJECT);
    }



    @Test
    public void testGetTitle() {
        String actualTitle = task1.getTitle();
        Assert.assertEquals(TITLE, actualTitle);
    }



    @Test
    public void testSetTitle() {
        String expectedTitle = "newTitle";
        task1.setTitle(expectedTitle);
        Assert.assertEquals(expectedTitle, task1.getTitle());
    }


    @Test
    public void shouldCreateTaskWithValues() {
        Task task = new Task(TITLE, new Date(),TaskStatus.NEW, PROJECT );

        Assert.assertNotNull(task.getTitle());
        Assert.assertEquals(TITLE, task.getTitle());
        Assert.assertNotNull(task.getDueDate());
        Assert.assertEquals(TaskStatus.NEW, task.getStatus());
        Assert.assertNotNull(task.getProject());
        Assert.assertEquals(PROJECT, task.getProject());
    }

    @After
    public void destroy() {
        task1 = null;
        date = null;
        dateFormat = null;
    }
}
