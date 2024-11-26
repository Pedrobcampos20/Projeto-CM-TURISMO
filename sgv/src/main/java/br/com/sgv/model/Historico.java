package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pedro Baptista <pedrobcampos20@hotmail.com>
 * @date 15/11/2024
 * @brief  class Historico
 */
@Entity
@Getter
@Setter
public class Historico extends Pessoa{
    @Size(min=1,message = "O CNPJ precisa ser válido.")
    private String cnpj;
    private String Lugar;
    private Float Preco;

}
