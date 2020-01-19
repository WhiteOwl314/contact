package sideproject1.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sideproject1.contact.controller.dto.PersonDto;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postPerson(@RequestBody PersonDto personDto){
        personService.put(personDto);
    }

    @PutMapping("/{id}")
    public void modifyPerson(@PathVariable Long id , @RequestBody PersonDto personDto){
        personService.modify(id, personDto);
    }
}
