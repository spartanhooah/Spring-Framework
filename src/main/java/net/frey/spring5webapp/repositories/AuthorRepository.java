package net.frey.spring5webapp.repositories;

import net.frey.spring5webapp.net.frey.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
