package sideproject1.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sideproject1.contact.domain.Person;
import sideproject1.contact.service.PersonService;

@RequestMapping("/api/person")
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id ){
        return personService.getPerson(id);
    }
}
