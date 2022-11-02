package org.ncu.hirewheels.dto.Request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestDto {
    @NotBlank
    private String first_name;

    private String last_name;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 10, max = 10)
    private String mobile_no;

    @NotNull
    private Integer role_id;

    public UserRequestDto(@NotBlank String first_name, String last_name, @NotBlank @Size(min = 6, max = 40) String password,
            @NotBlank @Email String email, @NotBlank @Size(min = 10, max = 10) String mobile_no,
            @NotBlank Integer role_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
        this.mobile_no = mobile_no;
        this.role_id = role_id;
    }

    public UserRequestDto(@NotBlank String first_name, @NotBlank @Size(min = 6, max = 40) String password,
            @NotBlank @Email String email, @NotBlank @Size(min = 10, max = 10) String mobile_no,
            @NotBlank Integer role_id) {
        this.first_name = first_name;
        this.password = password;
        this.email = email;
        this.mobile_no = mobile_no;
        this.role_id = role_id;
    }

    public UserRequestDto() {
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

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }


}
