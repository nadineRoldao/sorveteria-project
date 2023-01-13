package com.sorveteria.sorvetes.service;

import com.sorveteria.sorvetes.model.Sorvete;

import java.util.List;

public interface SorveteService {
    Sorvete cadastrarSorvete(Sorvete sorvete);
    List<Sorvete> listarSorvetes();
    Sorvete buscarSorvete(String id);
    boolean alterarSorvete(String id, Double preco, boolean possuiEstoque);
    boolean deletarSorvete(String id);
}
