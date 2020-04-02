package pis_library.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Reader {
    private @Id @GeneratedValue Long id;
    private String name;
    private String surname;
    private Date date_of_birth;
    private String personal_identification_number;
    private String type;
    private String isic_number;
    private String email;
    private String phone;
    private Long address;
    private String photo_path;
    private Long account;
    private Boolean verified;
    private Boolean consent;
    private Long member_card;

    public Reader() {}

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Reader(
            String name,
            String surname,
            Date date_of_birth,
            String personal_identification_number,
            String type,
            String email,
            String photo_path,
            Boolean consent
    ){
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.personal_identification_number = personal_identification_number;
        this.type = type;
        this.email = email;
        this.photo_path = photo_path;
        this.consent = consent;
    }
}
