package com.example.SpringBootLaba3.control;

import com.example.SpringBootLaba3.entity.Clients;
import com.example.SpringBootLaba3.rep.ClientsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientsControl {

    @Autowired
    private ClientsRep clientsRep;

    @GetMapping(path = "/getClients")
    public @ResponseBody Iterable<Clients> getAllClients() {
        return clientsRep.findAll();
    }
}
