package com.exploraavalia.model.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "exploraavalia", uniqueConstraints={@UniqueConstraint(columnNames={"nome", "sobrenome", "email", "dataNascimento", "nivelExperiencia", "telefone"})})
public class Viajante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String nome;

    @Column
    @NotNull
    private String sobrenome;

    @Column
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private Integer nivelExperiencia;

    @Column
    @NotNull
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getNivelExperiencia() {
        return nivelExperiencia;
    }

    public void setNivelExperiencia(Integer nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }

}
