package dk.gadekryds.threewebshop.domain.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "address")
public class Address {
    public Address() {
    }

    public Address(Integer id, String streetName, String streetNo) {
        this.id = id;
        this.street = streetName;
        this.suite = streetNo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "suite")
    private String suite;

    @OneToOne(mappedBy = "address")
    @PrimaryKeyJoinColumn(name = "customer_id")
    private Customer customer;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return suite;
    }

    public void setSuite(String streetNo) {
        this.suite = streetNo;
    }

    public String getSuite() {
        return street;
    }

    public void setStreet(String streetName) {
        this.street = streetName;
    }
}