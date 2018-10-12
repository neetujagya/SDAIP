package com.novare.sdaip.main;

import com.novare.sdaip.entity.TaskStatus;
import com.novare.sdaip.store.TaskStore;
import com.novare.sdaip.ui.UserInterface;

/**
 * Class to initialize the application.
 *
 * @author Neetu Jagya
 * @version 1.0
 */
public class Application {

    /**
     * Main method.
     * Start the user interface of the application
     *
     * @param st arguments passed
     */
    public static void main(String[] st) {
        TaskStore.initializeTasks("tasks.ser");
        UserInterface userInterface = new UserInterface();
        userInterface.start();

    }
}
