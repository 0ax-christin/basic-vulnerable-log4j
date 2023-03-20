package com.heroes.api.heroesapi.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.heroes.api.heroesapi.persistence.HeroDAO;
import com.heroes.api.heroesapi.model.HeroJSON;

/**
 * Handles the REST API requests for the Hero resource
 * <p>
 * {@literal @}RestController Spring annotation identifies this class as a REST API
 * method handler to the Spring framework
 * 
 */

@RestController
@RequestMapping("heroes")
public class HeroController {
    private static final Logger LOG = LogManager.getLogger(HeroController.class.getName());
    private HeroDAO heroDao;

    /**
     * Creates a REST API controller to reponds to requests
     * 
     * @param heroDao The {@link HeroDAO Hero Data Access Object} to perform CRUD operations
     * <br>
     * This dependency is injected by the Spring Framework
     */
    public HeroController(HeroDAO heroDao) {
        this.heroDao = heroDao;
    }

    /**
     * Responds to the GET request for a {@linkplain HeroJSON hero} for the given id
     * 
     * @param id The id used to locate the {@link HeroJSON hero}
     * 
     * @return ResponseEntity with {@link HeroJSON hero} object and HTTP status of OK if found<br>
     * ResponseEntity with HTTP status of NOT_FOUND if not found<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @GetMapping("/{id}")
    public ResponseEntity<HeroJSON> getHero(@PathVariable int id) {
        LOG.info("GET /heroes/" + id);
        try {
            HeroJSON hero = heroDao.getHero(id);
            if (hero != null)
                return new ResponseEntity<HeroJSON>(hero,HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to the GET request for all {@linkplain HeroJSON heroes}
     * 
     * @return ResponseEntity with array of {@link HeroJSON hero} objects (may be empty) and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @GetMapping("")
    public ResponseEntity<HeroJSON[]> getHeroes(@RequestHeader("X-Api-Version") String apiVersion) {
        LOG.error("Api version:" + apiVersion);
        // Replace below with your implementation
        try {
            HeroJSON[] heroes = heroDao.getHeroes();
            if(heroes.length != 0)
                return new ResponseEntity<HeroJSON[]>(heroes,HttpStatus.OK);
        }
        catch(IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    /**
     * Responds to the GET request for all {@linkplain HeroJSON heroes} whose name contains
     * the text in name
     * 
     * @param name The name parameter which contains the text used to find the {@link HeroJSON heroes}
     * 
     * @return ResponseEntity with array of {@link HeroJSON hero} objects (may be empty) and
     * HTTP status of OK<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     * <p>
     * Example: Find all heroes that contain the text "ma"
     * GET http://localhost:8080/heroes/?name=ma
     */
    @GetMapping("/")
    public ResponseEntity<HeroJSON[]> searchHeroes(@RequestParam String name) {
        LOG.info("GET /heroes/?name="+name);

        // Replace below with your implementation
        try {
            HeroJSON[] heroes = heroDao.findHeroes(name);
            if(heroes.length != 0)
                return new ResponseEntity<HeroJSON[]>(heroes,HttpStatus.OK);
        }
        catch(IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    /**
     * Creates a {@linkplain HeroJSON hero} with the provided hero object
     * 
     * @param hero - The {@link HeroJSON hero} to create
     * 
     * @return ResponseEntity with created {@link HeroJSON hero} object and HTTP status of CREATED<br>
     * ResponseEntity with HTTP status of CONFLICT if {@link HeroJSON hero} object already exists<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @PostMapping("")
    public ResponseEntity<HeroJSON> createHero(@RequestBody HeroJSON hero) {
        LOG.info("POST /heroes " + hero);

        // Replace below with your implementation
        try{
            HeroJSON[] heroes = heroDao.getHeroes();
            int duplicate = 0;
            //Added functionality to check if user sends duplicate name and give status of CONFLICT if name already exists as per above documentation
            for(int i=0; i< heroes.length; i++) {
                HeroJSON heroListItem = heroes[i];
                if((hero.getName().contains(heroListItem.getName()) || (hero.getId() == heroListItem.getId())) == true) 
                    duplicate = 1;
            }
            
            if(duplicate == 0) {
                HeroJSON heroRep = heroDao.createHero(hero);
                if(heroRep != null)
                    return new ResponseEntity<HeroJSON>(heroRep, HttpStatus.CREATED);
            } else 
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        catch(IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    /**
     * Updates the {@linkplain HeroJSON hero} with the provided {@linkplain HeroJSON hero} object, if it exists
     * 
     * @param hero The {@link HeroJSON hero} to update
     * 
     * @return ResponseEntity with updated {@link HeroJSON hero} object and HTTP status of OK if updated<br>
     * ResponseEntity with HTTP status of NOT_FOUND if not found<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @PutMapping("")
    public ResponseEntity<HeroJSON> updateHero(@RequestBody HeroJSON hero) {
        LOG.info("PUT /heroes " + hero);

        // Replace below with your implementation
        try {
            HeroJSON updatedHero = heroDao.updateHero(hero);
            if(updatedHero != null)
                return new ResponseEntity<HeroJSON>(hero, HttpStatus.OK);    
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        }
        catch(IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a {@linkplain HeroJSON hero} with the given id
     * 
     * @param id The id of the {@link HeroJSON hero} to deleted
     * 
     * @return ResponseEntity HTTP status of OK if deleted<br>
     * ResponseEntity with HTTP status of NOT_FOUND if not found<br>
     * ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HeroJSON> deleteHero(@PathVariable int id) {
        LOG.info("DELETE /heroes/" + id);

        // Replace below with your implementation
        try {
            boolean heroDeleteStatus = heroDao.deleteHero(id);
            if(heroDeleteStatus == true)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
