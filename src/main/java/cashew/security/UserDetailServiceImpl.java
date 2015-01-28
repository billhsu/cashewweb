package cashew.security;

import cashew.entities.Account;
import cashew.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shipeng Xu on 28/1/15.
 */
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AccountService accountService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Account account = accountService.findAccountByEmail(email);
            if (account == null) throw new UsernameNotFoundException("email not found");
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(email, account.getPassword(), authorities);
        } catch (DataAccessException e) {
            throw new UsernameNotFoundException("database error ");
        }
    }
}
