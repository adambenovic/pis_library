package pis_library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Fee {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Reader reader;

    private double amount;

    private boolean paid;

    private Date valid_from;

    private Date valid_to;

    public Fee() {};
}
