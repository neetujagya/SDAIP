package com.novare.sdaip.manager;

import com.novare.sdaip.entity.Task;
import com.novare.sdaip.entity.TaskStatus;
import com.novare.sdaip.store.TaskStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TaskManager {

    private static int counter = 1;

    private final TaskStore taskStore;

    public TaskManager() {
        this.taskStore = new TaskStore();
    }


    public void addTask(String project, String title, Date dueDate) {
        Task task = new Task(title, dueDate, TaskStatus.NEW,project);
         taskStore.addTask(task);

    }


    public ArrayList<Task> getAllTask() {
        return taskStore.getTasks();
    }

}
