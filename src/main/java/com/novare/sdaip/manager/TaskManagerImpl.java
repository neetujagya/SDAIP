package com.novare.sdaip.manager;

import com.novare.sdaip.entity.Project;
import com.novare.sdaip.entity.Task;
import com.novare.sdaip.entity.TaskStatus;
import com.novare.sdaip.store.ProjectStore;
import com.novare.sdaip.store.ProjectStoreImpl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TaskManagerImpl implements TaskManager {

    private static int counter = 1;

    private final ProjectStore projectStore;

    public TaskManagerImpl() {
        this.projectStore = new ProjectStoreImpl();
    }

    @Override
    public boolean addTask(int projectId, String title, Date dueDate) {
        if(projectStore.getProjectById(projectId) == null) {
            System.out.println("Wrong project chosen. Please select a proper project Id ");
            return false;
        } else {
            Task task = new Task(title, dueDate, TaskStatus.NEW, counter++);
            return projectStore.addTaskToProject(projectId, task);
        }
    }

    @Override
    public List<Task> getAllTask() {
        return projectStore.getAllTask();
    }

    @Override
    public Collection<Project> getAllProjects() {
        return projectStore.getAllProjects();
    }


}
