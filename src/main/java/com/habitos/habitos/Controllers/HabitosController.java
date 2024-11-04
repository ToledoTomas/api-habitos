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

import com.habitos.habitos.Model.Habito;
import com.habitos.habitos.Services.HabitoService;


@RestController
@RequestMapping("/api/habitos")
public class HabitosController {

    @Autowired
    private HabitoService habitoService;

    @GetMapping
    public List<Habito> getAllHabitos() {
        return habitoService.getAllHabitos();
    }

    @GetMapping("/{id}")
    public Habito getHabitoById(@PathVariable Long id) {
        return habitoService.getHabitoById(id);
    }

    @PostMapping
    public Habito createHabito(@RequestBody Habito habito) {
        return habitoService.createHabito(habito);
    }

    @PutMapping("/{id}")
    public Habito updateHabito(@PathVariable Long id, @RequestBody Habito habito) {
        return habitoService.updateHabito(id, habito);
    }

    @DeleteMapping("/{id}")
    public Habito deleteHabito(@PathVariable Long id) {
        return habitoService.deleteHabito(id);
    }
}
