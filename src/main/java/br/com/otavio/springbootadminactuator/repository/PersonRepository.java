package br.com.otavio.springbootadminactuator.repository;

import br.com.otavio.springbootadminactuator.model.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
