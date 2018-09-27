package com.novare.sdaip.manager;

import com.novare.sdaip.entity.Project;
import com.novare.sdaip.entity.Task;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Task manager to do all the task related operations like adding a new task, fetching task list etc.
 *
 * @author Neetu Jagya
 * @version 1.0
 */
public interface TaskManager {

    /**
     * Add task in the system.
     *
     * @param projectId to which task need to be added
     * @param title of the task
     * @param dueDate of the task
     *
     * @return flag if task is added or not
     */
    boolean addTask(int projectId, String title, Date dueDate);

    /**
     * Get all tasks
     */
    List<Task> getAllTask();

    /**
     * Get all projects.
     * @return
     */
    Collection<Project> getAllProjects();


}
