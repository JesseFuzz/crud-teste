package com.example.crudteste.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "instrumento")
public class InstrumentoEntity {

    @Id
    @Column(name = "inst_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "inst_marca")
    String marca;
    @Column(name = "inst_tipo")                    //esses atributos são colunas da tabela e a entity é tabela em si
    String tipo;
    @Column(name = "inst_descricao")
    String descricao;
    @Column(name = "inst_fabricacao")
    Date fabricacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(Date fabricacao) {
        this.fabricacao = fabricacao;
    }
}
