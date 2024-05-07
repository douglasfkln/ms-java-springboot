package com.uri.progweb.userdep.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id // Diz que esse campo é a chave primária do banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) // é uma forma de gerar os IDs
    private Long id;
    private String name;
    private String email;

    // @Column(name = "nome_da_coluna")
    // @JsonAlias("nomedocampo")

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public User () {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
