package br.com.otavio.springbootadminactuator.service;

import br.com.otavio.springbootadminactuator.model.dto.PersonDto;
import br.com.otavio.springbootadminactuator.model.entity.PersonEntity;
import br.com.otavio.springbootadminactuator.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void create (PersonEntity personEntity) {
        personRepository.save(personEntity);
    }

    public List<PersonEntity> findAll () {
        return personRepository.findAll();
    }

    public PersonEntity findById (UUID id) {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);

        return optionalPersonEntity.get();
    }

    public PersonEntity update (PersonEntity personEntity) throws Exception {
        if (!personRepository.existsById(personEntity.getId())) {
            throw new Exception("id not found");
        }

        return personRepository.save(personEntity);
    }

    public void delete (UUID id) {
        personRepository.delete(findById(id));
    }
}
