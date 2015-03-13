package cashew.controller.web;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Shipeng Xu on 13/3/15.
 */
public class LoginForm {
    @NotNull(message = "Email address is compulsory.")
    @NotBlank(message="Email address is compulsory.")
    @Size(min=3, max=256, message="Email addresses are between 3 and 256 characters long.")
    @Email(message = "Email address is not valid.")
    private String email;

    @NotNull(message = "Password is compulsory.")
    @NotBlank(message="Password is compulsory.")
    @Size(min=6, max=256, message="Passwords are between 6 and 256 characters long.")
    private String password;

    @NotNull
    private boolean rememberMe;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
