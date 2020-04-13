package pis_library.resourceAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import pis_library.controller.ReaderController;
import pis_library.entity.Reader;

@Component
public class ReaderModelAssembler implements RepresentationModelAssembler<Reader, EntityModel<Reader>> {
    @Override
    public EntityModel<Reader> toModel(Reader reader) {

        return new EntityModel<>(reader,
                linkTo(methodOn(ReaderController.class).one(reader.getId())).withSelfRel(),
                linkTo(methodOn(ReaderController.class).all()).withRel("readers"));
    }
}
