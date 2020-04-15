package pis_library.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pis_library.entity.Fee;
import pis_library.entity.Reader;
import pis_library.exception.ReaderNotFoundException;
import pis_library.repository.FeeRepository;
import pis_library.repository.ReaderRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import pis_library.resourceAssembler.ReaderModelAssembler;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("readers")
public class ReaderController {
    private final ReaderRepository readerRepository;

    private final ReaderModelAssembler assembler;

    private final FeeRepository feeRepository;

    public ReaderController(
            ReaderRepository readerRepository,
            ReaderModelAssembler assembler,
            FeeRepository feeRepository
    ) {
        this.readerRepository = readerRepository;
        this.assembler = assembler;
        this.feeRepository = feeRepository;
    }

    @GetMapping
    public CollectionModel<EntityModel<Reader>> all() {
        List<EntityModel<Reader>> readers = readerRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(readers,
                linkTo(methodOn(ReaderController.class).all()).withSelfRel());
    }

    @PostMapping
    ResponseEntity<?> newReader(@RequestBody Reader newReader) throws URISyntaxException {
        EntityModel<Reader> entityModel = assembler.toModel(readerRepository.save(newReader));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @GetMapping("/{id}")
    public EntityModel<Reader> one(@PathVariable Long id) {
        Reader reader =  readerRepository.findById(id)
                .orElseThrow(() -> new ReaderNotFoundException(id));

        return assembler.toModel(reader);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> replaceEmployee(@RequestBody Reader newReader, @PathVariable Long id) throws URISyntaxException {
        Reader updatedReader = readerRepository.findById(id)
                .map(reader -> {
                    reader.setName(newReader.getName());
                    reader.setSurname(newReader.getSurname());
                    return readerRepository.save(reader);
                })
                .orElseGet(() -> {
                    newReader.setId(id);
                    return readerRepository.save(newReader);
                });

        EntityModel<Reader> entityModel = assembler.toModel(updatedReader);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteReader(@PathVariable Long id) throws URISyntaxException {
        readerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/fee")
    public List<Fee> fee(@PathVariable Long id) {
        Reader reader =  readerRepository.findById(id)
                .orElseThrow(() -> new ReaderNotFoundException(id));

        return reader.getFees();
    }
}
