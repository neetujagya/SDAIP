package com.novare.sdaip.validation;

import java.util.Date;

public interface ValidationManager {

    /**
     * Validate if user is giving a valid choice.
     * It should be a number and in the range 1-4.
     *
     * @param userInput entered by the user
     * @return valid input and print message if the data is wrong.
     */
    int validateUserInput(String userInput);

    /**
     * Validates and return the user date according to the format.
     *
     * @param date entered by the user
     * @param format of the date
     * @return Return valid Date, if it is invalid then tell user to enter again until date is valid
     */
    Date validateAndReturnDate(String date, String format);
}
