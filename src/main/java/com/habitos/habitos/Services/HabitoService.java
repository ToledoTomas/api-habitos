package com.habitos.habitos.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habitos.habitos.Model.Habito;
import com.habitos.habitos.Repositories.HabitoRepository;

@Service
public class HabitoService {

    @Autowired
    private HabitoRepository habitoRepository;

    public List<Habito> getAllHabitos() {
        return habitoRepository.findAll();
    }

    public Habito getHabitoById(Long id) {
        return habitoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se encontró el hábito correspondiente"));
    }

    public Habito createHabito(Habito habito) {
        return habitoRepository.save(habito);
    }

    public Habito updateHabito(Long id, Habito habito) {
        Habito foundHabito = getHabitoById(id);

        foundHabito.setTitle(habito.getTitle());
        foundHabito.setDescription(habito.getDescription());
        foundHabito.setIsCompleted(habito.getIsCompleted());

        return habitoRepository.save(foundHabito);
    }

    public Habito deleteHabito(Long id) {
        Habito foundHabito = getHabitoById(id);
        habitoRepository.delete(foundHabito);
        return foundHabito;
    }
}
