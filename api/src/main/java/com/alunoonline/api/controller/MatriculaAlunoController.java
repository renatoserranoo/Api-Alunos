package com.alunoonline.api.controller;

import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.model.dto.HistoricoAlunoDto;
import com.alunoonline.api.model.dto.MatriculaAlunoNotasOnlyDto;
import com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {
    @Autowired
    MatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaAluno> create(@RequestBody MatriculaAluno matriculaAluno){
        MatriculaAluno matriculaAlunoCreated = service.create(matriculaAluno);
        return ResponseEntity.status(201).body(matriculaAlunoCreated);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MatriculaAluno> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<MatriculaAluno> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public MatriculaAluno update(@RequestBody MatriculaAluno matriculaAluno){
        return service.create(matriculaAluno);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGrades(@RequestBody MatriculaAlunoNotasOnlyDto notasOnlyDto, @PathVariable Long id){
        service.updateGrades(notasOnlyDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PatchMapping("/atualiza-status/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatusToTrancado(@PathVariable Long id) throws Exception{
        service.updateStatusToTrancado(id);
    }

    @GetMapping("/historico-aluno/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoDto getHistoricoDoAluno(@PathVariable Long id) {
        return service.getHistoricoAluno(id);
    }
}
