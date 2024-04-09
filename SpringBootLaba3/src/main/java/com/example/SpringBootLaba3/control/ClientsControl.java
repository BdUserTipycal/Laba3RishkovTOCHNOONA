package com.example.SpringBootLaba3.control;

import com.example.SpringBootLaba3.entity.Clients;
import com.example.SpringBootLaba3.entity.Masters;
import com.example.SpringBootLaba3.rep.ClientsRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientsControl {

    @Autowired
    private ClientsRep clientsRep;

    @GetMapping(path="/getClients")
    public @ResponseBody Iterable<Clients> getAllClients() {
        return clientsRep.findAll();
    }

    @GetMapping(path="/addClient")
    public @ResponseBody String addClient(@RequestParam String name, @RequestParam String surname, @RequestParam boolean exist){
        Clients client = new Clients();
        client.setName(name);
        client.setSurname(surname);
        client.setExist(exist);
        clientsRep.save(client);
        return "Saved new Client:" + name + " " + surname;
    }

    @GetMapping(path="deleteClient")
    public @ResponseBody String deleteClient(@RequestParam Integer id){
        Clients client = clientsRep.findByIdClient(id);{
            if(client != null){
                client.setExist(false);
                clientsRep.save(client);
            }
        }
        return "Удален клиент c id: " + id;
    }
}
