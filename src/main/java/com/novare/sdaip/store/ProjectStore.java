package com.novare.sdaip.store;

import com.novare.sdaip.entity.Project;
import com.novare.sdaip.entity.Task;

import java.util.Collection;
import java.util.List;

/**
 * Storage class to add Task.
 */
public interface ProjectStore {

    boolean addTaskToProject(int  projectId, Task task);

    Project getProjectById(int projectId);

    List<Task> getTaskOfProject(int projectId);

    List<Task> getAllTask();

    Collection<Project> getAllProjects();
}
