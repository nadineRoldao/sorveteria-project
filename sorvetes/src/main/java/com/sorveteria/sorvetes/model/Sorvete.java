package com.sorveteria.sorvetes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data // gerando os getters and setters
@Entity
@Table(name = "sorvete")
public class Sorvete {
    @Id
    private String id;
    private String sabor;
    private double preco;
    private boolean possuiEstoque;
}
