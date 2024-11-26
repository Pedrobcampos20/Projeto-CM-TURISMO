package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pedro Baptista <pedrobcampos20@hotmail.com>
 * @date 24/11/2024
 * @brief class Item
 */
@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Viagem viagem;
    @OneToOne
    private Reserva reserva;
    private int quantidade;

    public Item(){
        viagem = new Viagem();
        quantidade = 1;
    }
    
    @Override
    public String toString(){
        return viagem.getNome() + " " + quantidade;
    }

}