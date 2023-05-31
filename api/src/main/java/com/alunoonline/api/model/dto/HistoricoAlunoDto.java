package com.alunoonline.api.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoDto {
    private String nomeAluno;
    private String curso;
    private List<DisciplinasAlunoDto> disciplinasAlunoDtoList;
}
