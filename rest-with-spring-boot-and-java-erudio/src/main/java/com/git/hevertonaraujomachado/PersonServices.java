package com.git.hevertonaraujomachado;

import com.git.hevertonaraujomachado.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List <Person> findAll(){
        List<Person> persons = new ArrayList<Person>();

        logger.info("Finding all People!");

        List<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);

        }
        return persons;
    }


    public Person findById(String id){
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Héverton");
        person.setLastName("Araujo");
        person.setAddress("Teresina - Piauí - Brasil");
        person.setGender("Male");
        return person;
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname" + i);
        person.setLastName("lastname" + i);
        person.setAddress("Some Addres in Brasil");
        person.setGender("Male");
        return person;
    }

}
