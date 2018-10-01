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

    public static final String TITLE_CREATION = "\n######### Adding new task #########";
    public static final String SELECT_PROJECT = "Please select project for which you want to create a task";
    public static final String ENTER_TITLE = "Please enter title :";
    public static final String DD_MM_YYYY = "DD-MM-YYYY";
    public static final String ENTER_DUE_DATE = "Please enter due date in DD-MM-YYYY : ";
    public static final String TASK_SUCCESS = "Task is added successfully \n";

    public static final String PRINT_TASK = "Please choose: \n (1) To show project by date \n (2) To show project by due date  ";
    public static final String WRONG_INPUT_SHOW_TASK  = "Wrong Input. Please enter a proper choice (1-2)";
}
