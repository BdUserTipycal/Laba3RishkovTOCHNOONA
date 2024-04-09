package com.example.SpringBootLaba3.rep;

import com.example.SpringBootLaba3.entity.Clients;
import com.example.SpringBootLaba3.entity.Masters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClientsRep extends CrudRepository<Clients, Integer> {
    @Transactional
    default Clients findByIdClient(Integer id) {
        return findById(id).orElse(null);
    }
}
