package com.fempowerfit.FPF.Model;

import com.fempowerfit.FPF.Validation.TipoSuplemento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Suplemento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{suplemento.marca.notblank}")
    @Size(min = 6, message = "{suplemento.marca.size}")
    private String marca;

    private int quantidade;

    @TipoSuplemento(message = "{suplemento.tipo.tiposuplemento}")
    private String tipo;
    
    // Construtor com três argumentos
    public Suplemento(Long id, String marca, String tipo, int quantidade) {
        this.id = id;
        this.marca = marca;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    // Construtor padrão
    // public Suplemento() {
    // }

    // Getters e Setters
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getTipo(){
        return tipo;
    }

    public void setTipo (String tipo){
        this.tipo = tipo;
    }
}
