/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pedro Baptista <pedrobcampos20@hotmail.com>
 * @date 15/11/2024
 * @brief  class Passageiro
 */

 @Entity
@Getter
@Setter
public class Passageiro extends Pessoa{
    @Size(min=1,message = "O CPF precisa ser válido.")
    private String cpf;
    private String email;
    private String telefone;

}
