package com.novare.sdaip.entity;

import java.util.Date;
import java.util.Objects;

/**
 * Task is a class which represents tasks to be added by users.
 * It will have a title,a due date, status and a project .
 *
 * @author Neetu Jagya
 * @version 1.0
 */
public class Task {

    private String title;
    private Date dueDate;
    private TaskStatus status;
    private String project;

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", status=" + status +
                ", project='" + project + '\'' +
                '}';
    }

    public Task(String title, Date dueDate, TaskStatus status, String project) {
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
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

    public String getProject() { return  project; }
}
