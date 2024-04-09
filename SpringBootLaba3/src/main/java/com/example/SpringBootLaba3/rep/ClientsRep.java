package com.example.SpringBootLaba3.rep;

import com.example.SpringBootLaba3.entity.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRep extends CrudRepository<Clients, Integer> { }
