package ru.stuff.coworking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketsModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "title")
    private String title;
    @Column(name = "question")
    private String question;
}
