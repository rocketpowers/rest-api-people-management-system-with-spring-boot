package com.rocketpowers.personaapi.Service;

import com.rocketpowers.personaapi.Dto.Request.PersonDTO;
import com.rocketpowers.personaapi.Entity.Person;
import com.rocketpowers.personaapi.Mapper.PersonMapper;
import com.rocketpowers.personaapi.Repository.PersonRepository;
import com.rocketpowers.personaapi.Response.MessageResponseDTO;
import com.rocketpowers.personaapi.Exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
        Person personToSave = PersonMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("created person with id" + savedPerson.getId())
                .build();

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO findById(long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);


            return personMapper.toDTO(person);
        }

    private Person verifyIfExists(long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    public void delete (Long id) throws PersonNotFoundException{
        verifyIfExists(id);

        personRepository.deleteById(id);
        }

    }
