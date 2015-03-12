package cashew.security;

import cashew.session.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

/**
 * Created by Shipeng Xu on 12/3/15.
 */
public class CashewUserDetailsService implements ApplicationListener<AuthenticationSuccessEvent> {
    @Autowired
    private UserSession userSession;
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        String userName = ((CashewUserDetails) event.getAuthentication().
                getPrincipal()).getUsername();
        userSession.setUserEmail(userName);
    }
}
