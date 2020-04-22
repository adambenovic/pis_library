package pis_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pis_library.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    @Query("SELECT true FROM Reader WHERE personal_identification_number = :personal_identification_number")
    Boolean findByPIN(@Param("personal_identification_number") String personal_identification_number);
}
