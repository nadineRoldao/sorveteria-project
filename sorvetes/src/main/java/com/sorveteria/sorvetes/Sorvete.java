package com.sorveteria.sorvetes;

import lombok.Data;

@Data // gerando os getters and setters
public class Sorvete {
    private String id;
    private String sabor;
    private double preco;
    private boolean possuiEstoque;
}
