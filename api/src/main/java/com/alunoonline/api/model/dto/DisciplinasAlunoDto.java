package com.alunoonline.api.model.dto;

import lombok.Data;

@Data
public class DisciplinasAlunoDto {
    private String nomeDisciplina;
    private String nomeProfessorDisciplina;
    private Double nota1;
    private Double nota2;
    private Double media;
    private String status;
}
