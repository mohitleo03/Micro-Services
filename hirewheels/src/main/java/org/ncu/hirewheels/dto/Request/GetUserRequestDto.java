package org.ncu.hirewheels.dto.Request;

import javax.validation.constraints.*;

public class GetUserRequestDto {
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    @Email
    private String email;

    public GetUserRequestDto(@NotBlank @Size(min = 6, max = 40) String password, @NotBlank @Email String email) {
        this.password = password;
        this.email = email;
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
}
