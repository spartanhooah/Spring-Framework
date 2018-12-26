package net.frey.spring5webapp.repositories;

import net.frey.spring5webapp.net.frey.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
