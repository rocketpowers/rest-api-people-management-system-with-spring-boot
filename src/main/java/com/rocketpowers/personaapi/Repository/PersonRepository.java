package com.rocketpowers.personaapi.Repository;

import com.rocketpowers.personaapi.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {



}
