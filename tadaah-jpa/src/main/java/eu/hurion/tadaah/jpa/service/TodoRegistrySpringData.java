package eu.hurion.tadaah.jpa.service;

import eu.hurion.tadaah.jpa.model.TodoJpa;
import org.springframework.data.repository.CrudRepository;

public interface TodoRegistrySpringData extends CrudRepository<TodoJpa, Long> {
}
