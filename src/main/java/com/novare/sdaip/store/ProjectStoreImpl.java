package com.novare.sdaip.store;

import com.novare.sdaip.entity.Project;
import com.novare.sdaip.entity.Task;

import java.util.*;

public class ProjectStoreImpl implements ProjectStore {

    private final Map<Integer, Project> projects;

    public ProjectStoreImpl() {
        projects = new HashMap<>();
        initProject();
    }

    @Override
    public boolean addTaskToProject(int projectId, Task task) {
        Project project = projects.get(projectId);
        if(project != null) {
            project.getTasks().add(task);
            return true;
        }
        return false;
    }

    @Override
    public Project getProjectById(int projectId) {
        return projects.get(projectId);
    }

    @Override
    public List<Task> getTaskOfProject(int projectId) {
        return projects.get(projectId).getTasks();
    }

    @Override
    public List<Task> getAllTask() {
        List<Task> tasks = new ArrayList<>();
        projects.values().forEach(project -> tasks.addAll(project.getTasks()));
        return tasks;
    }

    @Override
    public Collection<Project> getAllProjects() {
        return projects.values();
    }


    private void initProject() {
        Project project1 = new Project(1, "Home", new ArrayList<>());
        Project project2 = new Project(2, "Work", new ArrayList<>());
        projects.put(1, project1);
        projects.put(2, project2);
    }
}
