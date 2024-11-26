package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Pedro Baptista <pedrobcampos20@hotmail.com>
 * @date 26/11/2024
 * @brief  class Pessoa
 */
@Entity
@Getter
@Setter
@Inheritance (strategy=InheritanceType.JOINED)
public abstract class Pessoa{
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Size(min=1,message = "O nome precisa ser válido.")
    private String nome;

    @Override
    public String toString(){
        return nome;
    }
    
}
