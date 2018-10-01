package com.novare.sdaip.ui;

import com.novare.sdaip.entity.Project;
import com.novare.sdaip.manager.TaskManager;
import com.novare.sdaip.manager.TaskManagerImpl;
import com.novare.sdaip.validation.ValidationManager;
import com.novare.sdaip.validation.ValidationManagerImpl;

import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import static com.novare.sdaip.constant.Constants.*;

/**
 * TODO: Add Java doc
 */
public class UserInterfaceImpl implements UserInterface {

    private ValidationManager validationManager;
    private TaskManager taskManager;

    public UserInterfaceImpl() {
        this.validationManager = new ValidationManagerImpl();
        this.taskManager = new TaskManagerImpl();
    }

    @Override
    public void start() {
        int userChoice = 0;
        while (userChoice != 4) {
            startInterface();
            Scanner in = new Scanner(System.in);
            userChoice = validationManager.validateFirstMenuUserInput(in.nextLine());
            handleUserChoice(userChoice);

        }

    }

    private void startInterface() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(TASK_MESSAGE); //TODO: Replace number of task todo and done
        System.out.println(PICK_MESSAGE);
        System.out.println(SHOW_TASK_LIST);
        System.out.println(ADD_NEW_TASK);
        System.out.println(EDIT_TASK);
        System.out.println(SAVE_AND_QUIT);
    }

    private void handleUserChoice(int userChoice) {
        switch (userChoice) {
            case 1:
               showTasks();
               break;
            case 2:
                addNewTask();
                break;
        }
    }

    private void showTasks() {
        boolean areTasksPrinted = false;
        while (!areTasksPrinted) {
            System.out.println(PRINT_TASK);
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            validationManager.validateShowTaskUserInput(userInput);

        }
    }

    private void addNewTask() {
        boolean isTaskAdded = false;
        while (!isTaskAdded) {
            Collection<Project> projects = taskManager.getAllProjects();
            System.out.println(TITLE_CREATION);
            System.out.println(SELECT_PROJECT);
            projects.stream().sorted().forEach(project -> System.out.println("(" + project.getProjectId() + ") "+ project.getName()));
            Scanner scanner = new Scanner(System.in);
            int projectId = Integer.parseInt(scanner.nextLine());//ToDo validate this input
            System.out.println(ENTER_TITLE);
            String title = scanner.nextLine();
            Date dueDate = null;
            while (dueDate == null) {
                System.out.println(ENTER_DUE_DATE);
                String dateInput = scanner.nextLine();
                dueDate = validationManager.validateAndReturnDate(dateInput, DD_MM_YYYY);
            }
            isTaskAdded = taskManager.addTask(projectId, title, dueDate);
            if(isTaskAdded) {
                System.out.println(TASK_SUCCESS);
            }
        }

    }


}
