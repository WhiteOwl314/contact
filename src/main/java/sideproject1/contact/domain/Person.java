package sideproject1.contact.domain;

import lombok.*;
import sideproject1.contact.controller.dto.PersonDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    private String phoneNumber;

    public void set(PersonDto personDto) {
        this.name = personDto.getName();
        this.phoneNumber = personDto.getPhoneNumber();
    }
}
