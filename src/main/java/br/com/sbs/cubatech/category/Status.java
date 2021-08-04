package br.com.sbs.cubatech.category;

import java.util.Arrays;

public enum Status {

    ACTIVE, INACTIVE;

    public static Status get(String status){
       return Arrays.stream(Status.values())
               .filter(s -> s.name().equals(status))
               .findFirst()
               .orElseThrow(() -> new RuntimeException("Status não suportado"));
    }
}
