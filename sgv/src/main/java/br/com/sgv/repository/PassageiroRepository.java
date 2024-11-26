package br.com.sgv.repository;


import br.com.sgv.model.Passageiro;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 */
public interface PassageiroRepository extends CrudRepository<Passageiro,Long>{
    
}
