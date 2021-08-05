package br.com.sbs.cubatech.category;

import java.util.Arrays;

public enum Status {

    ACTIVE("Ativa"),
    INACTIVE("Inativa");

    private String description;

    Status (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Status get(String status){
       return Arrays.stream(Status.values())
               .filter(s -> s.name().equals(status))
               .findFirst()
               .orElseThrow(() -> new RuntimeException("Status não suportado"));
    }
}
