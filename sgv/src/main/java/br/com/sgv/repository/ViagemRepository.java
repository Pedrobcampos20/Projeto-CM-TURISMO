package br.com.sgv.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.sgv.model.Viagem;

/**
 *
 * @author Pedro Baptista <pedrobcampos20@hotmail.com>
 */
public interface ViagemRepository extends CrudRepository<Viagem,Long>{
    
}
