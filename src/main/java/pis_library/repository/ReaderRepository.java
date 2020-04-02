package pis_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pis_library.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
