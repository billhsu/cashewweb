package cashew.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Shipeng Xu on 12/3/15.
 */
@Component
@Scope("session")
public class UserSession {
    private String userEmail;
    private String userNickname;

    public void invalidateSession() {
        setUserEmail(null);
        setUserNickname(null);
    }
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
