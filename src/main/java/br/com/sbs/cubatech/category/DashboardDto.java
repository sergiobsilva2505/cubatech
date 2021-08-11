package br.com.sbs.cubatech.category;

public class DashboardDto {

    private final String name;
    private final Integer qtdCursos;

    public DashboardDto(String name, Integer qtdCursos) {
        this.name = name;
        this.qtdCursos = qtdCursos;
    }

    public String getName() {
        return name;
    }

    public Integer getQtdCursos() {
        return qtdCursos;
    }
}
