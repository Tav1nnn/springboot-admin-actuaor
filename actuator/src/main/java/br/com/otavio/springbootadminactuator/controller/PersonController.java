package br.com.otavio.springbootadminactuator.controller;

import br.com.otavio.springbootadminactuator.model.entity.PersonEntity;
import br.com.otavio.springbootadminactuator.service.PersonService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void create (@RequestBody PersonEntity personEntity, HttpServletResponse response) {
        personService.create(personEntity);

        response.setStatus(201);
    }

    @GetMapping
    public ResponseEntity<List<PersonEntity>> findAll () {
        return ResponseEntity.ok().body(personService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonEntity> findById (@PathVariable  UUID id) {
       return ResponseEntity.ok().body(personService.findById(id));
    }

    @PutMapping
    public ResponseEntity<PersonEntity> update (@RequestBody PersonEntity personEntity) throws Exception {
        return ResponseEntity.ok().body(personService.update(personEntity));
    }
    @DeleteMapping(value = "/{id}")
    public void delete (@RequestBody PersonEntity personEntity, HttpServletResponse response) {
        personService.create(personEntity);

        response.setStatus(200);
    }
}
