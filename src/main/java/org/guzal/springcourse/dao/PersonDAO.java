package org.guzal.springcourse.dao;

import org.guzal.springcourse.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;

    public List<Person> people = new ArrayList<>();

    {
        people.add(new Person(++PEOPLE_COUNT, "Tom", 25, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Poly", 50, "poly@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Kate", 37, "kate@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 19, "bob@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {

        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
