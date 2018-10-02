package com.novare.sdaip.store;

import com.novare.sdaip.entity.Task;

import java.util.*;

public class TaskStore {

    private final ArrayList<Task> tasks;

    public TaskStore() {
        tasks = new ArrayList<>();
    }


    public void addTask(Task task) {
        tasks.add(task);

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

}
