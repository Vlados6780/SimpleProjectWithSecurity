package country.Project2Boot.country.services;

import country.Project2Boot.country.models.Person;
import country.Project2Boot.country.repositories.PeopleRepositrory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepositrory peopleRepositrory;

    @Autowired
    public PeopleService(PeopleRepositrory peopleRepositrory) {
        this.peopleRepositrory = peopleRepositrory;
    }

    public List<Person> findAll() {
        return peopleRepositrory.findAll();
    }
    public Person findOne(int id) {
        return peopleRepositrory.findById(id).orElse(null);
    }

    @Transactional
    public void save(Person person) {
        peopleRepositrory.save(person);
    }
    @Transactional
    public void delete(int id) {
        peopleRepositrory.deleteById(id);
    }
    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setPerson_id(id);
        peopleRepositrory.save(updatedPerson);
    }
    public Optional<Object> getPersonByName(String name) {
        return peopleRepositrory.getPersonByName(name);
    }



}
