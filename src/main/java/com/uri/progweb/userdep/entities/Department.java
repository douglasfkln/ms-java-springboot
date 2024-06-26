package com.uri.progweb.userdep.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_department")
public class Department {

    @Id // Diz que esse campo é a chave primária do banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) // é uma forma de gerar os IDs
    private Long id;
    private String name;

    public Department () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
