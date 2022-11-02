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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", columnDefinition = "numeric(10)")
    private Integer user_id;

    @Column(name = "first_name", nullable = false, columnDefinition = "varchar(50)")
    private String first_name;

    @Column(name = "last_name", columnDefinition = "varchar(50)")
    private String last_name;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(50)")
    private String password;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(50)", unique = true)
    private String email;

    @Column(name = "mobile_no", nullable = false, columnDefinition = "char(10)", unique = true)
    private String mobile_no;

    @Column(name = "wallet_money", columnDefinition = "numeric(10, 2) default 10000.0")
    private Integer wallet_money;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", columnDefinition = "numeric(10)", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public User(String first_name, String last_name, String password, String email, String mobile_no, Role role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.mobile_no = mobile_no;
        this.role = role;
    }

    public User() {
    }

    public User(String first_name, String last_name, String password, String email, String mobile_no) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.mobile_no = mobile_no;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public Integer getWallet_money() {
        return wallet_money;
    }

    public void setWallet_money(Integer wallet_money) {
        this.wallet_money = wallet_money;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", password="
                + password + ", email=" + email + ", mobile_no=" + mobile_no
                + ", wallet_money=" + wallet_money + ", role=" + role + "]";
    }
}
