package com.heroes.api.heroesapi.persistence;

import java.io.IOException;
import com.heroes.api.heroesapi.model.HeroJSON;

/**
 * Defines the interface for Hero object persistence
 * 
 */
public interface HeroDAO {
    /**
     * Retrieves all {@linkplain HeroJSON heroes}
     * 
     * @return An array of {@link HeroJSON hero} objects, may be empty
     * 
     * @throws IOException if an issue with underlying storage
     */
    HeroJSON[] getHeroes() throws IOException;

    /**
     * Finds all {@linkplain HeroJSON heroes} whose name contains the given text
     * 
     * @param containsText The text to match against
     * 
     * @return An array of {@link HeroJSON heroes} whose nemes contains the given text, may be empty
     * 
     * @throws IOException if an issue with underlying storage
     */
    HeroJSON[] findHeroes(String containsText) throws IOException;

    /**
     * Retrieves a {@linkplain HeroJSON hero} with the given id
     * 
     * @param id The id of the {@link HeroJSON hero} to get
     * 
     * @return a {@link HeroJSON hero} object with the matching id
     * <br>
     * null if no {@link HeroJSON hero} with a matching id is found
     * 
     * @throws IOException if an issue with underlying storage
     */
    HeroJSON getHero(int id) throws IOException;

    /**
     * Creates and saves a {@linkplain HeroJSON hero}
     * 
     * @param hero {@linkplain HeroJSON hero} object to be created and saved
     * <br>
     * The id of the hero object is ignored and a new uniqe id is assigned
     *
     * @return new {@link HeroJSON hero} if successful, false otherwise 
     * 
     * @throws IOException if an issue with underlying storage
     */
    HeroJSON createHero(HeroJSON hero) throws IOException;

    /**
     * Updates and saves a {@linkplain HeroJSON hero}
     * 
     * @param {@link HeroJSON hero} object to be updated and saved
     * 
     * @return updated {@link HeroJSON hero} if successful, null if
     * {@link HeroJSON hero} could not be found
     * 
     * @throws IOException if underlying storage cannot be accessed
     */
    HeroJSON updateHero(HeroJSON hero) throws IOException;

    /**
     * Deletes a {@linkplain HeroJSON hero} with the given id
     * 
     * @param id The id of the {@link HeroJSON hero}
     * 
     * @return true if the {@link HeroJSON hero} was deleted
     * <br>
     * false if hero with the given id does not exist
     * 
     * @throws IOException if underlying storage cannot be accessed
     */
    boolean deleteHero(int id) throws IOException;
}
