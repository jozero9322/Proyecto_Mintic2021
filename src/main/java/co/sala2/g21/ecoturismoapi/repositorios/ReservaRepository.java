/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sala2.g21.ecoturismoapi.repositorios;

import co.sala2.g21.ecoturismoapi.modelos.Reserva;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sebca
 */
@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Long>{
    
    @Query(value =  "SELECT * FROM reserva WHERE cliente_id=?1", nativeQuery = true)
    public ArrayList<Reserva> getPorCliente(Long documento);
}
