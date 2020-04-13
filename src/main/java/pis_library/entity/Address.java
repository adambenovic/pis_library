package pis_library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;

    private String number;

    private String city;

    private String zip;

    @OneToOne
    @JsonBackReference
    private Reader reader;

    public Address() {};
}
