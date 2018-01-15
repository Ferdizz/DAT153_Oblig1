package no.hvl.nameapp.data;


import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import no.hvl.nameapp.R;

/**
 * @author Torbjørn on 12.01.2018.
 */

public class PersonDB {

    private static PersonDB instance = null;
    private ArrayList<Person> list = new ArrayList<>();

    private PersonDB() {
    }

    /** getInstance
     *
     *
     * @return an Instance of the PersonDB
     */
    public static PersonDB getInstance() {
        if(instance == null) {
            instance = new PersonDB();
        }
        return instance;
    }

    /** count
     *
     * @return number of people in the db
     */
    public int count() {
        return list.size();
    }

    /** getPersonByIndex
     *
     * @param i index of the person you want
     * @return Person matching the index
     */
    public Person getPersonByIndex(int i) {
        return list.get(i);
    }

    /**
     *
     * @param i index of the Person
     * @return id of the Person whose index you provided.
     */
    public long getIdByIndex(int i) {
        return list.get(i).getId();
    }

    /** getAll
     *
     * @return List of all Persons1
     *
     */
    public ArrayList<Person> getAll() {
        return list;
    }

    /** addPerson
     *  Adds a person to the 'database'
     * @param p Person to be added
     */
    public void addPerson(Person p) {
        list.add(p);
    }

    /**
     *  getPersonByID
     * @param id the ID of the person you want
     * @return a Person with id matching input or null
     */
    public Person getPersonById(long id) {
        for (Person p : list) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    /** getRandomPerson
     *
     * @return a random Person from the db
     */
    public Person getRandomPerson() {
        return list.get((int) (Math.random() * list.size()));
    }

}
