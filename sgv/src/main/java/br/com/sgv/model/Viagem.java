package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pedro Baptista <pedrobcampos20@hotmail.com>
 * @date 15/11/2024
 * @brief class Viagem
 */
@Entity
@Getter
@Setter
public class Viagem{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(min = 1, message = "O nome do produto precisa ser válido.")
    private String inclusao;
    private float preco;
    private String dias;
    private String nome;
    
    @Override
    public String toString() {
        return nome;
    }
}
