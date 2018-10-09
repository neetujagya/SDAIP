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

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public void updateTask(Task task, int index) {
        tasks.set(index, task);
    }

    public Task getAtIndex(int index) {
        return tasks.get(index);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }


}
