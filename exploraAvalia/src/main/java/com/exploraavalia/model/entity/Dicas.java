package com.exploraavalia.model.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "exploraavalia", uniqueConstraints={@UniqueConstraint(columnNames={"destino", "descricao", "avaliacao", "custoMedioDia", "categorias"})})
public class Dicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String destino;
    @Column
    @NotNull
    private String descricao;
    @Column
    @NotNull
    private Integer avaliacao;
    @Column
    @NotNull
    private Float custoMedioDia;
    @Column
    @NotNull
    private String categorias;

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Float getCustoMedioDia() {
        return custoMedioDia;
    }

    public void setCustoMedioDia(Float custoMedioDia) {
        this.custoMedioDia = custoMedioDia;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
