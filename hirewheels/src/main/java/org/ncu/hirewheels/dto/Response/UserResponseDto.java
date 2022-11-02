package org.ncu.hirewheels.dto.Response;

import org.ncu.hirewheels.entities.Role;

public class UserResponseDto {
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private String mobile_no;
    private Role role;

    public UserResponseDto() {
    }

    public UserResponseDto(String first_name, String last_name, String password, String email, String mobile_no,
            Role role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.mobile_no = mobile_no;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
