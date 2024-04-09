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

    @GetMapping(path = "/getMasters")
    public @ResponseBody Iterable<Masters> getAllMasters() {
        return mastersRep.findAll();
    }
}