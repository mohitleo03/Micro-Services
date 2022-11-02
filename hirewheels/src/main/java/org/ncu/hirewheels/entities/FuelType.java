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
@Table(name = "fuel_type")
public class FuelType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fuel_type_id", columnDefinition = "numeric(10)")
    private Integer fuel_type_id;

    @Column(name = "fuel_type_name", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String fuel_type_name;

    @OneToMany(mappedBy = "fuelType",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles ;
}
