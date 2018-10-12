package com.novare.sdaip.ui;

import com.novare.sdaip.entity.Task;
import com.novare.sdaip.manager.TaskManager;
import com.novare.sdaip.validation.ValidationManager;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

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
        System.out.println(taskManager.getDoneAndNewMessage());
        System.out.println(PICK_MESSAGE);
        System.out.println(SHOW_TASK_LIST);
        System.out.println(ADD_NEW_TASK);
        System.out.println(EDIT_TASK);
        System.out.println(SAVE_AND_QUIT);
    }

    private void handleUserChoice(int userChoice) {
        Scanner scanner = new Scanner(System.in);
        switch (userChoice) {
            case 1:
               showTasks(scanner);
               break;
            case 2:
                addNewTask(scanner);
                break;
            case 3:
                editTask(scanner);
                break;
            case 4:
                saveAndQuit();
                break;

        }
    }

    private void saveAndQuit() {
        taskManager.saveAndQuit();
    }

    private void editTask(final Scanner scanner) {
        boolean isTaskEdited = false;
        while (!isTaskEdited) {
            System.out.println(LIST_OF_YOUR_TASKS);
            List<Task> tasks = taskManager.getAllTask();
            tasks.forEach(System.out::println);

            System.out.println(TASK_ID_TO_EDIT);
            String choice = scanner.nextLine();
            int index = validationManager.validateTaskIdAndReturnIndex(choice, tasks.size());
            if(index == -1 ) {
                return;
            }
            System.out.println(YOU_HAVE_SELECTED_TASK + tasks.get(index).toString());

            System.out.println(PLEASE_CHOOSE_AN_OPTION);
            System.out.println(UPDATE_TASK);
            System.out.println(MARK_AS_DONE_TASK);
            System.out.println(REMOVE_TASK);
            choice = scanner.nextLine();
            int editInput = validationManager.validateEditOperationAndReturnChoice(choice);
            switch (editInput) {
                case 1:
                    isTaskEdited = updateTask(index, scanner);
                    break;
                case 2:
                    isTaskEdited = markAsDone(index);
                    break;
                case 3:
                    isTaskEdited = removeTask(index);
                    break;

            }
        }
    }

    public boolean updateTask(int index, Scanner scanner) {
        boolean isTaskEdited = false;
        while (!isTaskEdited) {
            System.out.println(TITLE_UPDATE_MSG);
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
            taskManager.updateTask(index, title, project, dueDate);
            isTaskEdited = true;
            if(isTaskEdited) {
                System.out.println(TASK_UPDATE_SUCCESS_MSG);
            }
        }
        return true;
    }

    public boolean markAsDone(int index) {
        taskManager.markAsDone(index);
        return true;
    }

    public boolean removeTask(int index) {
        taskManager.removeTask(index);
        return true;
    }

    private void showTasks(final Scanner scanner) {
        boolean areTasksPrinted = false;
        while (!areTasksPrinted) {
            System.out.println(PRINT_TASK);
            String userInput = scanner.nextLine();
            int input = validationManager.validateShowTaskUserInput(userInput);
            if (input != -1) {
                if (input == 1){
                    sortAndPrintTasks();

                } else if (input == 2) {
                    filterAndPrintTasks(scanner);

                }
                areTasksPrinted = true;
            }
        }
    }

    private void filterAndPrintTasks(Scanner scanner) {
        System.out.println(FILTER_PROJECT);
        String projectName = scanner.nextLine();
        List<Task> tasks = taskManager.getAllTask();
        if (tasks.isEmpty()) {
            System.out.println(NO_TASK_MESSAGE);
        } else {
            Object[] taskArray = tasks.stream()
                    .filter(task -> task.getProject().contains(projectName)).toArray();
            if(taskArray.length == 0){
                System.out.println(NO_TASK_FOUND_FOR_PROJECT + projectName);
            } else {
                Stream.of(taskArray).forEach(System.out::println);
            }
        }
    }

    private void sortAndPrintTasks() {
        ArrayList<Task> tasks = taskManager.getAllTask();
        if (tasks.isEmpty()) {
            System.out.println(NO_TASK_MESSAGE);
        } else {
            tasks.stream()
                    .sorted((task1, task2) -> task1.getDueDate().compareTo(task2.getDueDate()))
                    .forEach(System.out::println);
        }
    }

    private void addNewTask(final Scanner scanner) {
        boolean isTaskAdded = false;
        while (!isTaskAdded) {
            System.out.println(TITLE_CREATION_MSG);
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
                System.out.println(TASK_ADDED_SUCCESS_MSG);
            }
        }

    }
}
