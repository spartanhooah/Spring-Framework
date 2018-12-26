package net.frey.spring5webapp.bootstrap;

import net.frey.spring5webapp.net.frey.spring5webapp.model.Author;
import net.frey.spring5webapp.net.frey.spring5webapp.model.Book;
import net.frey.spring5webapp.net.frey.spring5webapp.model.Publisher;
import net.frey.spring5webapp.repositories.AuthorRepository;
import net.frey.spring5webapp.repositories.BookRepository;
import net.frey.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher harperCollins = new Publisher("Harper Collins", "123 Main NY, NY");
        publisherRepository.save(harperCollins);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(harperCollins);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Publisher worx = new Publisher("Worx", "321 Other St. Joseph, MI");
        publisherRepository.save(worx);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(worx);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
