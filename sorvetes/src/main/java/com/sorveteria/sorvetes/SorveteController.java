package com.sorveteria.sorvetes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indicando que essa lasse e uma API
@RequestMapping("sorvetes") // setando um caminho fixo para nossa API
public class SorveteController {

    Sorvete sorvete = new Sorvete();

    @GetMapping(value = "checando")
    public String healthCheck(){
        return "funcionando";
    }

    @GetMapping(value = "cadastrar")
    public ResponseEntity cadastrarSorvete(){

        return null;
    }
}
