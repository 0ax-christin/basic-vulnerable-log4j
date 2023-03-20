package com.heroes.api.heroesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heroes.api.heroesapi.model.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer> {
    
}
