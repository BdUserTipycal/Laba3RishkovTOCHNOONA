package com.example.SpringBootLaba3.control;

import com.example.SpringBootLaba3.entity.Masters;
import com.example.SpringBootLaba3.rep.MastersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MastersControl {

    @Autowired
    private MastersRep mastersRep;

    @GetMapping(path="/getMasters")
    public @ResponseBody Iterable<Masters> getAllMasters() {
        return mastersRep.findAll();
    }

    @GetMapping(path="/addMaster")
    public @ResponseBody String addMaster(@RequestParam String name, @RequestParam String surname, @RequestParam boolean exist){
        Masters master = new Masters();
        master.setName(name);
        master.setSurname(surname);
        master.setExist(exist);
        mastersRep.save(master);
        return "Saved new Master:" + name + " " + surname;
    }


    @GetMapping(path="deleteMaster")
    public @ResponseBody String deleteMaster(@RequestParam Integer id){
        Masters master = mastersRep.findByIdMaster(id);{
            if(master != null){
                master.setExist(false);
                mastersRep.save(master);
            }
        }
        return "Удален мастер c id: " + id;
    }

}
