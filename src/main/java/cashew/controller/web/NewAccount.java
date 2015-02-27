package cashew.controller.web;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Shipeng Xu on 2/27/15.
 */
public class NewAccount {
    @NotNull(message = "Email address is compulsory.")
    @NotBlank(message="Email address is compulsory.")
    @Size(min=3, max=256, message="Email addresses are between 3 and 256 characters long.")
    @Email(message = "Email address is not valid.")
    private String email;

    @NotNull(message = "Nickname is compulsory.")
    @NotBlank(message="Nickname is compulsory.")
    @Size(min=3, max=256, message="Nicknames are between 3 and 256 characters long.")
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "Only alphanumeric and underscore allowed in nicknames.")
    private String nickname;

    @NotNull(message = "Password is compulsory.")
    @NotBlank(message="Password is compulsory.")
    @Size(min=6, max=256, message="Passwords are between 6 and 256 characters long.")
    private String password;

    @NotNull(message = "Retype Password is compulsory.")
    @NotBlank(message="Retype Password is compulsory.")
    @Size(min=6, max=256, message="Passwords are between 6 and 256 characters long.")
    private String rePassword;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}