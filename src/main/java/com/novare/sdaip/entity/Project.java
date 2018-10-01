package com.novare.sdaip.entity;

import java.util.List;
import java.util.Objects;

public class Project implements Comparable<Project> {
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
    public int compareTo(Project project) {
        if(this.projectId == project.getProjectId()) {
            return 0;
        } else if(this.projectId >  project.getProjectId()) {
            return 1;
        } else {
            return -1;
        }
    }
}


