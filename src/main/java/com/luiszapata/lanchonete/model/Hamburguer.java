package com.luiszapata.lanchonete.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Hamburguer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private String descricao;

    private BigDecimal valor;

    @ManyToMany
    @JoinTable(
            name = "ingredientes_hamburguer",
            joinColumns = @JoinColumn(name = "hamburguer_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredientes_id")
    )
    private List<Ingrediente>hamburguerIngrediente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Ingrediente> getHamburguerIngrediente() {
        return hamburguerIngrediente;
    }

    public void setHamburguerIngrediente(List<Ingrediente> hamburguerIngrediente) {
        this.hamburguerIngrediente = hamburguerIngrediente;
    }
}
