package ru.stuff.coworking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "points")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PointModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "img")
    private String img;
    @Column(name = "price")
    private int price;

}
