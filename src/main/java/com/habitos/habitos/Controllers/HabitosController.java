package com.habitos.habitos.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habitos.habitos.Repositories.HabitoRepository;

@RestController
@RequestMapping("/api")
public class HabitosController {

    @Autowired
    private HabitoRepository habitoRepository; 

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola Mundo!";
    }

}
