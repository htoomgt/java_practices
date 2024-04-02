package xyz.htoomaungthait.JPA.paging.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String  city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;
}
