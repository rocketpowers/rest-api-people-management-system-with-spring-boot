package com.rocketpowers.personaapi.Service;

import com.rocketpowers.personaapi.Dto.Request.PersonDTO;
import com.rocketpowers.personaapi.Entity.Person;
import com.rocketpowers.personaapi.Mapper.PersonMapper;
import com.rocketpowers.personaapi.Repository.PersonRepository;
import com.rocketpowers.personaapi.Response.MessageResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = Person.builder()
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .birthDate(personDTO.getBirthDate())
                .build();




        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("created person with id" + savedPerson.getId())
                .build();

}



}