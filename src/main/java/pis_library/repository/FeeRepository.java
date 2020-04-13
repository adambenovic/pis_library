package pis_library.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import pis_library.entity.Fee;

public interface FeeRepository extends JpaRepository<Fee, Long> {

}

