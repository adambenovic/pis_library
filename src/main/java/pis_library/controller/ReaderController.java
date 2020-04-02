package pis_library.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import pis_library.entity.Reader;
import pis_library.exception.ReaderNotFoundException;
import pis_library.repository.ReaderRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ReaderController {
    private final ReaderRepository repository;

    ReaderController(ReaderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/readers")
    CollectionModel<EntityModel<Reader>> all() {

        List<EntityModel<Reader>> readers = repository.findAll().stream()
                .map(reader -> new EntityModel<>(reader,
                        linkTo(methodOn(ReaderController.class).one(reader.getId())).withSelfRel(),
                        linkTo(methodOn(ReaderController.class).all()).withRel("readers")))
                .collect(Collectors.toList());

        return new CollectionModel<>(readers,
                linkTo(methodOn(ReaderController.class).all()).withSelfRel());
    }

    @PostMapping("/readers")
    Reader newReader(@RequestBody Reader newReader) {
        return repository.save(newReader);
    }

    @GetMapping("/readers/{id}")
    EntityModel<Reader> one(@PathVariable Long id) {
        Reader reader =  repository.findById(id)
                .orElseThrow(() -> new ReaderNotFoundException(id));

        return new EntityModel<>(reader,
                linkTo(methodOn(ReaderController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ReaderController.class).all()).withRel("readers"));
    }

    @PutMapping("/readers/{id}")
    Reader replaceReader(@RequestBody Reader newReader, @PathVariable Long id) {
        return repository.findById(id)
                .map(reader -> {
                    newReader.setName(newReader.getName());
                    newReader.setSurname(newReader.getSurname());
                    return repository.save(reader);
                })
                .orElseGet(() -> {
                    newReader.setId(id);
                    return repository.save(newReader);
                });
    }

    @DeleteMapping("/readers/{id}")
    void deleteReader(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
