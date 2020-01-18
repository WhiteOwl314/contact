package sideproject1.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sideproject1.contact.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
