package com.novare.sdaip.store;

import com.novare.sdaip.entity.Task;
import com.novare.sdaip.entity.TaskStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class TaskStoreTest {
    private Task task1;
    private Task task2;
    private Task task3;

    private TaskStore taskStore = new TaskStore();


    private ArrayList<Task> taskList1;
    private ArrayList<Task> taskList2;


    @Before
    public void setUp() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = dateFormat.parse("01-01-1000");
        task1 = new Task("1", date1, TaskStatus.NEW, "1");

        Date date2 = dateFormat.parse("02-02-2000");
        task2 = new Task("2", date2, TaskStatus.NEW, "2");

        Date date3 = dateFormat.parse("02-02-2000");
        task3 = new Task("3", date2, TaskStatus.NEW, "3");

        taskList1 = new ArrayList<>();
        taskList2 = new ArrayList<>();

        taskList1.add(task1);
        taskList1.add(task2);

        taskList2.add(task1);
        taskList2.add(task2);
        taskList2.add(task3);

        taskStore.addTask(task1);
        taskStore.addTask(task2);
        taskStore.addTask(task3);


    }

    @Test
    public void addTask() {
        ArrayList<Task> actualList = taskStore.getTasks();
        assertEquals(3, actualList.size());
        assertArrayEquals(taskList2.toArray(), actualList.toArray());
    }

    @Test
    public void removeTask() {
        taskStore.removeTask(0);
        List<Task> tasks =  taskStore.getTasks();
        assertNotNull(tasks);
        assertEquals(2, tasks.size());
        assertEquals(task2, tasks.get(0));
        assertEquals(task3, tasks.get(1));

    }

    @Test
    public void getAtIndex() {
        Task task = taskStore.getAtIndex(0);

        assertNotNull(task);
        assertEquals(task1, task);

    }

    @Test
    public void updateTask() {
        Task newTask = new Task("newTitle", new Date(), TaskStatus.FINISHED, "newProject");

        Task oldTask = taskStore.getAtIndex(0);
        assertNotNull(oldTask);
        assertEquals(task1, oldTask);

        taskStore.updateTask(newTask, 0);
        Task retunedTask = taskStore.getAtIndex(0);
        assertNotNull(retunedTask);
        assertEquals(newTask, retunedTask);
        assertNotEquals(oldTask, retunedTask);
    }

    @Test
    public void saveAndQuit() throws IOException, ClassNotFoundException {
        List<Task> previousTask = taskStore.getTasks();

        taskStore.saveAndQuit("Testtasks.ser");

        FileInputStream fileInputStream = new FileInputStream("/tmp/Testtasks.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Task> tasks = (ArrayList<Task>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        assertNotNull(tasks);

        assertEquals(previousTask.size(), tasks.size());
        assertEquals(previousTask.get(0), tasks.get(0));
        assertEquals(previousTask.get(1), tasks.get(1));
        assertEquals(previousTask.get(2), tasks.get(2));

    }

    @Test
    public void initializeTasks() {
        taskStore.saveAndQuit("Testtasks.ser");
        taskStore.removeTask(2);
        taskStore.removeTask(1);
        taskStore.removeTask(0);
        taskStore = null;
        TaskStore.initializeTasks("Testtasks.ser");
        taskStore = new TaskStore();
        List<Task> tasks = taskStore.getTasks();
        assertEquals(3, tasks.size());
        assertEquals(task1, tasks.get(0));
        assertEquals(task2, tasks.get(1));
        assertEquals(task3, tasks.get(2));

    }

    @After
    public void destroy(){
        taskList1 = null;
        taskList2 = null;
        task1 = null;
        task2 = null;
        task3 = null;
        taskStore.removeAll();
        taskStore = null;
    }
}