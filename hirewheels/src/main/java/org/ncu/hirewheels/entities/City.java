package org.ncu.hirewheels.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id", columnDefinition = "numeric(10)")
    private Integer city_id;

    @Column(name = "city_name", columnDefinition = "varchar(50)", nullable = false)
    private String city_name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Location> locations;
}
