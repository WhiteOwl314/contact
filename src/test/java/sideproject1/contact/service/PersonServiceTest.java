package sideproject1.contact.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sideproject1.contact.controller.dto.PersonDto;
import sideproject1.contact.domain.Person;
import sideproject1.contact.repository.PersonRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;

    @Test
    void getPerson(){
        when(personRepository.findById(1L)).thenReturn(Optional.of(new Person("martin")));

        Person person = personService.getPerson(1L);

        assertThat(person.getName()).isEqualTo("martin");
    }

    @Test
    void getPersonIfNotPerson(){
        when(personRepository.findById(1L)).thenReturn(Optional.empty());

        Person person = personService.getPerson(1L);

        assertThat(person).isNull();
    }

    @Test
    void put(){
        personService.put(mockPersonDto());

        verify(personRepository,times(1));
    }

    private PersonDto mockPersonDto() {
        return PersonDto.of("seongju","010-3925-1533");
    }
}