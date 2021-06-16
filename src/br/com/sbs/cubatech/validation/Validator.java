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

    // todo validar tempo estimado de cruso entre 1 e 20
    public static void estimatedTimeValid(Integer estimatedTime, String error){
        if (estimatedTime < 1 && estimatedTime >= 20){
            throw  new IllegalArgumentException(error);
        }
    }
}
