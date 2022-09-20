package com.kbe.warehouse;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hardware")
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private String name;
    private String description;
    private double price;
    private int stock;
}
