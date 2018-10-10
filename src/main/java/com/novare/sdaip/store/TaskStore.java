package com.novare.sdaip.store;

import com.novare.sdaip.entity.Task;

import java.io.*;
import java.util.*;

import static com.novare.sdaip.constant.Constants.*;

public class TaskStore {

    private static ArrayList<Task> tasks;

    public TaskStore() {
        if(tasks == null) {
            tasks = new ArrayList<>();
        }
    }


    public void addTask(Task task) {
        task.setId(tasks.size() + 1);
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

    public void saveAndQuit() {
        try {
            FileOutputStream outputStream = new FileOutputStream("/tmp/tasks.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(tasks);
            objectOutputStream.close();
            outputStream.close();
        } catch(IOException ioException) {
            System.err.println("Error occurred while saving.");
            ioException.printStackTrace();
            throw new RuntimeException(ioException);
        }
    }

    public static void initializeTasks() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/tmp/tasks.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tasks = (ArrayList<Task>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(NO_SAVED_TASKS_WERE_FOUND);
        } catch (IOException ioException) {
            System.out.println(ERROR_OCCURRED_WHILE_RECOVERING_TASKS);
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println(ERROR_OCCURRED_WHILE_RECOVERING_TASKS);
        }
    }


}
