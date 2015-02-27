package cashew.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;

/**
 * Created by Shipeng Xu on 28/1/15.
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        AuthenticationManager authenticationManager = new ProviderManager(
                Arrays.asList(authenticationProvider()));
        return authenticationManager;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() throws Exception {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setSaltSource(saltSource());
        authenticationProvider.setPasswordEncoder(shaPasswordEncoder());
        authenticationProvider.afterPropertiesSet();
        return authenticationProvider;
    }

    @Bean
    public SaltSource saltSource() throws Exception {
        ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("salt");
        saltSource.afterPropertiesSet();
        return saltSource;
    }
    
    @Bean
    ShaPasswordEncoder shaPasswordEncoder() throws Exception {
        ShaPasswordEncoder shaEncoder = new ShaPasswordEncoder(256);
        shaEncoder.setEncodeHashAsBase64(false);
        return shaEncoder;
    }

    @Override
    public void configure( WebSecurity web ) throws Exception
    {
        // This is here to ensure that the static content (JavaScript, CSS, etc)
        // is accessible from the login page without authentication
        web
                .ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/webjars/**")
                .antMatchers("/register");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().anyRequest().authenticated();
        http
                .formLogin().failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .permitAll();
    }
}
