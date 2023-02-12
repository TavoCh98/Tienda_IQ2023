
package com.Tienda.dao;

import com.Tienda.domain.Cliente;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author 0116960839$
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
}
