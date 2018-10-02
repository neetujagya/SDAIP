package com.novare.sdaip.ui;

import com.novare.sdaip.entity.Task;
import com.novare.sdaip.manager.TaskManager;
import com.novare.sdaip.validation.ValidationManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import static com.novare.sdaip.constant.Constants.*;

/**
 * TODO: Add Java doc
 */
public class UserInterface {

    private ValidationManager validationManager;
    private TaskManager taskManager;

    public UserInterface() {
        this.validationManager = new ValidationManager();
        this.taskManager = new TaskManager();
    }


    public void start() {
        int userChoice = 0;
        Scanner in = new Scanner(System.in);
        while (userChoice != 4) {
            startInterface();

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
        Scanner scanner = new Scanner(System.in);
        while (!areTasksPrinted) {
            System.out.println(PRINT_TASK);
            String userInput = scanner.nextLine();
            int input = validationManager.validateShowTaskUserInput(userInput);
            if (input != -1) {
                if (input == 1){
                    ArrayList<Task> tasks = taskManager.getAllTask();
                    if (tasks.isEmpty()) {
                        System.out.println(NO_TASK_MESSAGE);
                    } else {
                        tasks.stream()
                                .sorted((o1, o2) -> o1.getDueDate().compareTo(o2.getDueDate()))
                                .forEach(System.out::println);

                    }
                    areTasksPrinted = true;
                }

            }


        }
    }

    private void addNewTask() {
        boolean isTaskAdded = false;
        Scanner scanner = new Scanner(System.in);
        while (!isTaskAdded) {
            System.out.println(TITLE_CREATION);
            System.out.println(ENTER_TITLE);
            String title = scanner.nextLine();
            System.out.println(ENTER_PROJECT);
            String project = scanner.nextLine();//ToDo validate this input
            Date dueDate = null;
            while (dueDate == null) {
                System.out.println(ENTER_DUE_DATE);
                String dateInput = scanner.nextLine();
                dueDate = validationManager.validateAndReturnDate(dateInput, DD_MM_YYYY);
            }
            taskManager.addTask(project, title, dueDate);
            isTaskAdded = true;
            if(isTaskAdded) {
                System.out.println(TASK_SUCCESS);
            }
        }

    }


}
