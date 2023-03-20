package com.heroes.api.heroesapi.service;

import java.util.List;

import com.heroes.api.heroesapi.model.Hero;

public interface HeroService {

    Hero saveHero(Hero hero);

    List<Hero> fetchAllHeroes();

    Hero getHeroById(Integer id);

    Hero updateHeroById(Integer id, Hero hero);

    String deleteHeroById(Integer id);
}
