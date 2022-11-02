package org.ncu.hirewheels.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id", columnDefinition = "numeric(10)")
    private Integer location_id;

    @Column(name = "location_name", columnDefinition = "varchar(50)", nullable = false)
    private String location_name;

    @Column(name = "address", columnDefinition = "varchar(100)", nullable = false)
    private String address;

    @Column(name = "pincode", columnDefinition = "char(6)", nullable = false)
    private String pincode;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", columnDefinition = "numeric(10)", nullable = false)
    private City city;

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
    private List<Booking> bookings;
}
