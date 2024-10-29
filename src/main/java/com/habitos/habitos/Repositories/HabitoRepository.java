package com.habitos.habitos.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habitos.habitos.Entitities.Habito;

public interface HabitoRepository extends JpaRepository<Habito, Long> {

}
