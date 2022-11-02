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
@Table(name = "vehicle_category")
public class VehicleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_category_id", columnDefinition = "numeric(10)")
    private Integer vehicle_category_id;

    @Column(name = "vehicle_category_name", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String vehicle_category_name;

    @OneToMany(mappedBy = "vehicleCategory",cascade = CascadeType.ALL)
    private List<VehicleSubcategory> vehicleSubcategories;
}
