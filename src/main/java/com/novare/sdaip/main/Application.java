package com.novare.sdaip.main;

import com.novare.sdaip.ui.UserInterface;
import com.novare.sdaip.ui.UserInterfaceImpl;

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
        UserInterface userInterface = new UserInterfaceImpl();
        userInterface.start();

    }
}
