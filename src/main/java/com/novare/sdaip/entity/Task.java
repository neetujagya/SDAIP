package com.novare.sdaip.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Task is a class which represents tasks to be added by users.
 * It will have a title,a due date, status and a project .
 *
 * @author Neetu Jagya
 * @version 1.0
 */
public class Task implements Serializable {

    private String title;
    private Date dueDate;
    private TaskStatus status;
    private String project;
    private int id;

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ",title='" + title + '\'' +
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
