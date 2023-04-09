package ru.stuff.coworking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.stuff.coworking.model.enums.Role;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;

    @Column(name = "discount")
    private boolean discount;
    @Column(name = "coffee")
    private boolean coffee;
    @Column(name = "booking")
    private boolean booking;
    @Column(name = "closet")
    private boolean closet;

    @Column(name = "role")
    private String role;
//    @Enumerated(EnumType.STRING)
//    private Role role;

    @Column(name = "code")
    private int code;
}
