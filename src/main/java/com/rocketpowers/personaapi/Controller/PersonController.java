package com.rocketpowers.personaapi.Controller;

import com.rocketpowers.personaapi.Dto.Request.PersonDTO;
import com.rocketpowers.personaapi.Entity.Person;
import com.rocketpowers.personaapi.Exception.PersonNotFoundException;
import com.rocketpowers.personaapi.Response.MessageResponseDTO;
import com.rocketpowers.personaapi.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {


    private PersonService personService;

    @Autowired
    public  PersonController(PersonService personService){
        this.personService=personService;

}

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return  personService.createPerson(personDTO);

  }
  @GetMapping
  public List<PersonDTO> listAll(){
        return personService.listAll();

  }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException{
        return personService.findById(id);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

}