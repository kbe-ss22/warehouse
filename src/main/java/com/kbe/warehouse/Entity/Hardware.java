package com.kbe.warehouse.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hardware")
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private HardwareType type;
    private String name;
    private String description;
    private double price;
    private int stock;
}
