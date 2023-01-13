package com.sorveteria.sorvetes.controller;

import com.sorveteria.sorvetes.model.Sorvete;
import com.sorveteria.sorvetes.service.SorveteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController // indicando que essa lasse e uma API
@RequestMapping("sorvetes") // setando um caminho fixo para nossa API
public class SorveteController {

    @Autowired
    private SorveteService sorveteService;

    @GetMapping(value = "checando")
    public String healthCheck(){
        return "funcionando";
    }

    @PostMapping(value = "cadastrar")
    public ResponseEntity<?> cadastrarSorvete(@RequestBody Sorvete sorvete){

        var sorveteCadastrado = sorveteService.cadastrarSorvete(sorvete);

        return ResponseEntity.status(HttpStatus.CREATED).body(sorveteCadastrado);
    }

    @GetMapping(value = "listar")
    public List<Sorvete> listarSorvetes(){
        return sorveteService.listarSorvetes();
    }

    @GetMapping(value = "buscar-sorvete/{id}")
    public ResponseEntity<?> buscarSorvete(@PathVariable String id){
        var sorveteAchado = sorveteService.buscarSorvete(id);

        if (Objects.nonNull(sorveteAchado)) return ResponseEntity.status(HttpStatus.OK).body(sorveteAchado);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping(value = "alterar-sorvete/{id}")
    public ResponseEntity<?> alterarSorvete (@PathVariable String id,
                                             @RequestParam(value = "preco", required = false) Double preco,
                                             @RequestParam(value = "possui-estoque", required = false) boolean possuiEstoque){

            boolean sorveteAlterado = sorveteService.alterarSorvete(id, preco, possuiEstoque);
        return sorveteAlterado ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @DeleteMapping(value = "deletar-sorvete/{id}")
    public ResponseEntity<?> deletarSorvete (@PathVariable String id){
        boolean sorveteDeletado = sorveteService.deletarSorvete(id);
        return sorveteDeletado ? ResponseEntity.status(HttpStatus.OK).build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
