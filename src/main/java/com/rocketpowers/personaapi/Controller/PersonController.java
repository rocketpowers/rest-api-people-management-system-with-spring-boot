package com.rocketpowers.personaapi.Controller;

import com.rocketpowers.personaapi.Entity.Person;
import com.rocketpowers.personaapi.Repository.PersonRepository;
import com.rocketpowers.personaapi.Response.MessageResponseDTO;
import com.rocketpowers.personaapi.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return  personService.createPerson(person);

  }


}