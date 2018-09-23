package com.novare.sdaip.entity;

import java.util.Date;
import java.util.Objects;

/**
 * Task is a class which represents tasks to be added by users.
 * Task will be associated with a {@link Project}. It will have a title, status and a due date.
 *
 * @author Neetu Jagya
 */
public class Task {

    private String title;
    private Date dueDate;
    private TaskStatus status;
    private Project project;
    private int taskId;
    /**
     * It is a default constructor.
     */
    public Task() {
    }

    public Task(String title, Date dueDate, TaskStatus status, Project project, int taskId) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
        this.taskId = taskId;
    }



    public String getTitle() {
        return title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Project getProject() {
        return project;
    }

    public int getTaskId() {
        return taskId;
    }

    // TODO: Read more about Casting and equals.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}
