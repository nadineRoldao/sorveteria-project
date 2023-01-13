package com.sorveteria.sorvetes.service;

import com.sorveteria.sorvetes.model.Sorvete;
import com.sorveteria.sorvetes.repository.SorveteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SorveteServiceImplemetation implements SorveteService{

    @Autowired
    private SorveteRepository sorveteRepository;

    @Override
    public Sorvete cadastrarSorvete(Sorvete sorvete) {
        return sorveteRepository.save(sorvete);
    }

    @Override
    public List<Sorvete> listarSorvetes() {
        return sorveteRepository.findAll();
    }

    @Override
    public Sorvete buscarSorvete(String id) {

        return sorveteRepository.findById(id).orElse(null);
    }

    @Override
    public boolean alterarSorvete(String id, Double preco, boolean possuiEstoque) {
        var sorveteh = buscarSorvete(id);

        if (Objects.isNull(sorveteh)) return false;

        boolean isAlterado = false;

        if ((Objects.nonNull(preco)) && (preco != sorveteh.getPreco())){
            sorveteh.setPreco(preco);
            isAlterado = true;
        }

        if (sorveteh.isPossuiEstoque() != possuiEstoque){
            sorveteh.setPossuiEstoque(possuiEstoque);
            isAlterado = true;
        }
        if (isAlterado) sorveteRepository.save(sorveteh);

        return isAlterado;
    }

    @Override
    public boolean deletarSorvete(String id) {

        var sorveth = buscarSorvete(id);

        sorveteRepository.delete(sorveth);

        return true;
    }
}
