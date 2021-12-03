package com.beginning.new_world;

import com.begginning.classes.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@Slf4j
public class SpeedWorld {

    @Autowired
    private Daouser DaoUser;

    @GetMapping("/StartDuel")
    public String start(){
        log.info("All duelists ready");
        return "3,2,1 ready set. Let's duel";
    }

    @Value("${index.saludo}")
    private String saludo;



    @GetMapping("/")
    public String inicio(Model model){
        var mensaje = "hola peter";
        var users = DaoUser.findAll();

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("hello", saludo);
        model.addAttribute("users", users);
        return "index";
    }

}
