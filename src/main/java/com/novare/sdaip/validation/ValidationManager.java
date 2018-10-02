package com.novare.sdaip.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.novare.sdaip.constant.Constants.*;

/**
 * Class to validate all the user inputs
 */
public final class ValidationManager {

    public static final String ENTER_A_PROPER_DATE = "Date is invalid, please enter a proper date as ";


    public int validateFirstMenuUserInput(String userInput) {
        try {
            int input =  Integer.parseInt(userInput);
            if( input < 1 || input > 4) {
                System.out.println(WRONG_INPUT);
            }
            return input;
        } catch (NumberFormatException numberFormatException) {
            System.out.println(WRONG_INPUT);
            return -1;
        }
    }


    public Date validateAndReturnDate(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(date);
        } catch (ParseException parseException) {
            System.out.println(ENTER_A_PROPER_DATE + format);
            return null;
        }

    }


    public int validateShowTaskUserInput(String userInput) {
        try {
            int input =  Integer.parseInt(userInput);
            if( input < 1 || input > 2) {
                System.out.println(WRONG_INPUT_SHOW_TASK);
                return -1;
            }
            return input;
        } catch (NumberFormatException numberFormatException) {
            System.out.println(WRONG_INPUT_SHOW_TASK);
            return -1;
        }
    }
}
