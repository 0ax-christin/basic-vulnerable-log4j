package com.heroes.api.heroesapi.service;

import com.heroes.api.heroesapi.model.Hero;
import com.heroes.api.heroesapi.repository.HeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HeroServiceImpl implements HeroService{

    @Autowired
    private HeroRepository heroRepository;

    @Override
    public Hero saveHero(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public List<Hero> fetchAllHeroes() {
        List<Hero> allHeroes = heroRepository.findAll();
        return allHeroes;
    }

    @Override
    public Hero getHeroById(Integer id) {
        Optional<Hero> employee = heroRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    
    @Override
    public Hero updateHeroById(Integer id, Hero hero) {
        Optional<Hero> hero1 = heroRepository.findById(id);

        if (hero1.isPresent()) {
            Hero originalHero = hero1.get();

            if (Objects.nonNull(hero.getName()) && !"".equalsIgnoreCase(hero.getName())) {
                originalHero.setName(hero.getName());
            }
            return heroRepository.save(originalHero);
        }
        return null;
    }

    @Override
    public String deleteHeroById(Integer id) {
        if (heroRepository.findById(id).isPresent()) {
            heroRepository.deleteById(id);
            return "Hero deleted successfully";
        }
        return "No such Hero in the database";
    }
}