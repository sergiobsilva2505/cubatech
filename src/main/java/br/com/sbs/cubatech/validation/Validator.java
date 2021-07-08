package br.com.sbs.cubatech.validation;

public class Validator {

    public static final String MESSAGE_NOT_EMPTY_OR_NULL = " can't be empty or null.";
    public static final String MESSAGE_URL_CODE_VALIDATION = " must contain only lowercase letters, no spaces and slash as separator.";
    public static final String MESSAGE_NOT_NULL = " can't be null.";
    public static final String MESSAGE_INTERVAL_VALIDATION = "Time to finish, needs to be between 1 or 20 hours.";

    public static void notEmptyOrNull(String text, String error){
        if(text.isBlank()) {
            throw new IllegalArgumentException(error + MESSAGE_NOT_EMPTY_OR_NULL);
        }
        if (text == null) {
            throw new NullPointerException(error + MESSAGE_NOT_NULL);
        }
    }

    public static void urlCodeValidation(String text, String error){
        if(!text.matches("[a-z-]+")){
            throw new IllegalArgumentException(error + MESSAGE_URL_CODE_VALIDATION);
        }
    }

    public  static void objectNotNull(Object object, String error){
        if (object == null){
            throw new NullPointerException(error + MESSAGE_NOT_NULL);
        }
    }

    public static void intervalValidation(int value, int min, int max){
        if (value < min || value > max){
            throw  new IllegalArgumentException(MESSAGE_INTERVAL_VALIDATION);
        }
    }

}
