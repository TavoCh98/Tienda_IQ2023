
package com.Tienda.dao;

import com.Tienda.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
    List<Cliente> findByApellidos(String apellidos);
    
}
