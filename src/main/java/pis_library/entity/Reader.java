package pis_library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private String photo_path;

    private Long account;

    private Boolean verified;

    private Boolean consent;

    private Long member_card;

    @OneToMany(mappedBy="reader", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Fee> fees;

    @OneToOne(mappedBy="reader", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Address address;

    public Reader(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Reader() { };

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

    public void addFee(Fee fee) {
        this.fees.add(fee);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPersonal_identification_number() {
        return personal_identification_number;
    }

    public void setPersonal_identification_number(String personal_identification_number) {
        this.personal_identification_number = personal_identification_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsic_number() {
        return isic_number;
    }

    public void setIsic_number(String isic_number) {
        this.isic_number = isic_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public Boolean getConsent() {
        return consent;
    }

    public void setConsent(Boolean consent) {
        this.consent = consent;
    }

    public Long getMember_card() {
        return member_card;
    }

    public void setMember_card(Long member_card) {
        this.member_card = member_card;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
