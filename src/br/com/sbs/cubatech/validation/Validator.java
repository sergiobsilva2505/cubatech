package br.com.sbs.cubatech.validation;

public class Validator {

    public static void notEmptyOrNull(String text , String error){
        if(text == null || text.isBlank()) {
            throw new IllegalArgumentException(error);
        }
    }

    public static void urlCodeValidation(String text, String error){
        if(!text.matches("[a-z-]+")){
            throw new IllegalArgumentException(error);
        }
    }


    public  static void objectNotNull(Object object, String error){
        if (object == null){
            throw new IllegalArgumentException(error);
        }
    }


    public static void intervalValidation(int value, int min, int max, String error){
        if (value < min || value > max){
            throw  new IllegalArgumentException(error);
        }
    }
}
