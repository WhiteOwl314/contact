package sideproject1.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sideproject1.contact.domain.Person;
import sideproject1.contact.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    //id로 Person 가져오기
    public Person getPerson(Long id){
        return personRepository.findById(id).orElse(null);
    }
}
