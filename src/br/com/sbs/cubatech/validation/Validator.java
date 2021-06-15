package br.com.sbs.cubatech.validation;

public class Validator {

    public static void notEmptyOrNull(String text , String error){
        if(text == null || text.isBlank()) {
            throw new IllegalArgumentException(error);
        }
    }

    public static void urlCodeValidation(String text, String error){
        if(!text.matches("[/a-z-]+")){ // questionar urlCode categoria
            throw new IllegalArgumentException(error);
        }
    }

    public static void notNullBoolean(Boolean correct, String error) {
        if (correct == null) {
            throw new NullPointerException(error);
        }
    }

    public  static void objectNotNull(Object object, String error){
        if (object == null){
            throw new NullPointerException(error);
        }
    }
}
