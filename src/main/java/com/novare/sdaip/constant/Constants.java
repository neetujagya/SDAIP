package com.novare.sdaip.constant;

/**
 * Constants class to maintain all the constants used across all the project.
 * We don't want sub classes of this class therefore it is a final class.
 *
 * @author Neetu Jagya
 * @version 1.0
 */
public final class Constants {

    public static final String WELCOME_MESSAGE = "Welcome to ToDoly";
    public static final String TASK_MESSAGE = "You have %s tasks todo and %s tasks are done";
    public static final String PICK_MESSAGE = "Pick an option:";
    public static final String SHOW_TASK_LIST = "(1) Show Task List (by date or project)";
    public static final String ADD_NEW_TASK = "(2) Add New Task";
    public static final String EDIT_TASK = "(3) Edit Task (update, mark as done, remove)";
    public static final String SAVE_AND_QUIT = "(4) Save and Quit";
    public static final String WRONG_INPUT  = "Wrong Input. Please enter a proper choice (1-4)";

    public static final String TITLE_CREATION_MSG = "\n######### Adding new task #########";
    public static final String TITLE_UPDATE_MSG = "\n######### Updating task #########";
    public static final String ENTER_PROJECT = "Please enter a project";
    public static final String ENTER_TITLE = "Please enter title :";
    public static final String DD_MM_YYYY = "dd-MM-yyyy";
    public static final String ENTER_DUE_DATE = "Please enter due date in DD-MM-YYYY : ";
    public static final String TASK_ADDED_SUCCESS_MSG = "Task is added successfully \n";
    public static final String TASK_UPDATE_SUCCESS_MSG = "Task is updated successfully \n";

    public static final String PRINT_TASK = "Please choose: \n (1) To sort task by date \n (2) To filter task by project";
    public static final String WRONG_INPUT_SHOW_TASK  = "Wrong Input. Please enter a proper choice (1-2)";
    public static final String NO_TASK_MESSAGE  = "There is no task to display. \n";
    public static final String FILTER_PROJECT = "Please enter project name on which you want to filter";
    public static final String NO_TASK_FOUND_FOR_PROJECT = "No task found for project : ";


    public static final String TASK_ID_TO_EDIT = "Please enter task id to edit:";
    public static final String LIST_OF_YOUR_TASKS = "Here is a list of your tasks";
    public static final String VALID_NUMBER_OF_LIST = "Please enter a valid number from 1 to ";
    public static final String YOU_HAVE_SELECTED_TASK = "You have selected task : ";
    public static final String PLEASE_CHOOSE_AN_OPTION = "Please choose an option:";
    public static final String UPDATE_TASK = "(1) Update";
    public static final String MARK_AS_DONE_TASK = "(2) Mark as done";
    public static final String REMOVE_TASK = "(3) Remove";
    public static final String ENTER_A_VALID_CHOICE_EDIT_TASK = "Please enter a valid choice (1-3)";
    public static final String ENTER_A_PROPER_DATE = "Date is invalid, please enter a proper date as ";
    public static final String ENTER_A_VALID_DATE = "Date is before today's date or after 01-01-2025. Please enter a valid date as  ";
    public static final String FUTURE_VALID_DATE = "01-01-2025";
    public static final String NO_SAVED_TASKS_WERE_FOUND = "No saved tasks were found.\n";
    public static final String ERROR_OCCURRED_WHILE_RECOVERING_TASKS = "Error occurred while recovering tasks";
}

