package com.example.SpringBootLaba3.rep;

import com.example.SpringBootLaba3.entity.Masters;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface MastersRep extends CrudRepository<Masters, Integer> {
    @Transactional
    default Masters findByIdMaster(Integer id) {
        return findById(id).orElse(null);
    }
}
