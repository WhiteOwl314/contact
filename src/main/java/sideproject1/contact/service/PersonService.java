package sideproject1.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sideproject1.contact.controller.dto.PersonDto;
import sideproject1.contact.domain.Person;
import sideproject1.contact.exception.PersonNotFoundException;
import sideproject1.contact.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    //id로 Person 가져오기
    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
    }

    public void put(PersonDto personDto) {
        Person person = new Person();
        person.set(personDto);
        personRepository.save(person);
    }

    public void modify(Long id, PersonDto personDto) {

        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());
    }
}
