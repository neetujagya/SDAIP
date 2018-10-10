package com.novare.sdaip.manager;

import com.novare.sdaip.entity.Task;
import com.novare.sdaip.entity.TaskStatus;
import com.novare.sdaip.store.TaskStore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static com.novare.sdaip.constant.Constants.TASK_MESSAGE;

public class TaskManager {

    private final TaskStore taskStore;

    public TaskManager() {
        this.taskStore = new TaskStore();
    }


    public void addTask(String project, String title, Date dueDate) {
        Task task = new Task(title, dueDate, TaskStatus.NEW,project);
         taskStore.addTask(task);

    }

    public void updateTask(int id, String project, String title, Date dueDate) {
        Task task = new Task(title, dueDate, TaskStatus.NEW, project);
        taskStore.updateTask(task, id);
    }

    public void removeTask(int index) {
        taskStore.removeTask(index);
    }

    public void markAsDone(int index) {
        Task task = taskStore.getAtIndex(index);
        task.setStatus(TaskStatus.FINISHED);
        taskStore.updateTask(task, index);
    }


    public ArrayList<Task> getAllTask() {
        return taskStore.getTasks();
    }

    public void saveAndQuit() {
        taskStore.saveAndQuit();
    }

    public String getDoneAndNewMessage() {
        int noOfNewTask = 0;
        int noOfDoneTask = 0;
        for (Task task : taskStore.getTasks()) {
            if(TaskStatus.NEW.equals(task.getStatus())) {
                noOfNewTask++;
            } else {
                noOfDoneTask++;
            }
        }
        return String.format(TASK_MESSAGE, noOfNewTask, noOfDoneTask);
    }

}
