package com.habitos.habitos.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.habitos.habitos.Entitities.Habito;
import com.habitos.habitos.Repositories.HabitoRepository;

@RestController
@RequestMapping("/api")
public class HabitosController {

    @Autowired
    private HabitoRepository habitoRepository; 

    @GetMapping
    public List<Habito> getAllHabitos(){
        return habitoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Habito getHabitoById(@PathVariable Long id){
        return habitoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontro el hábito correspondiente"));
    }

    @PostMapping
    public Habito createHabito(@RequestBody Habito habito){
        return habitoRepository.save(habito);
    }

    @PutMapping
    public Habito updateHabito(@PathVariable Long id, @RequestBody Habito habito){
        Habito foundHabito = getHabitoById(id);

        foundHabito.setTitle(habito.getTitle());
        foundHabito.setDescription(habito.getDescription());
        foundHabito.setIsCompleted(habito.getIsCompleted());

        return habitoRepository.save(foundHabito);

    }

    @DeleteMapping
    public Habito deleteHabito(@PathVariable Long id){
        Habito foundHabito = getHabitoById(id);

       habitoRepository.delete(foundHabito);
       return foundHabito;
    }

}
