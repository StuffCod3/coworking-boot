package ru.stuff.coworking.configuration;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.stuff.coworking.model.UserModel;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private String email;
    private String name;
    private String phone;
    private String password;
    private int code;
    private List<GrantedAuthority> authorities;

    public CustomUserDetails(UserModel userModel) {
        code = userModel.getCode();
        email = userModel.getEmail();
        password = userModel.getPassword();
        name = userModel.getName();
        phone = userModel.getPhone();
        authorities = Arrays.stream(userModel.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public int getCode(){
        return code;
    }
}
