package com.novare.sdaip.entity;

import java.util.List;
import java.util.Objects;

public class Project {
    private int projectId;
    private String name;
    private List<Task> tasks;

    public Project() {
    }

    public Project(int projectId, String name, List<Task> tasks) {
        this.projectId = projectId;
        this.name = name;
        this.tasks = tasks;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectId == project.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }
}


