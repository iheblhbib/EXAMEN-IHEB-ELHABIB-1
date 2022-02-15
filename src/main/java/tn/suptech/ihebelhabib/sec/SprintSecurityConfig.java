package tn.suptech.ihebelhabib.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SprintSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin();
        http.authorizeRequests().antMatchers("/agence/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/banque/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/client/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/compte/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/frias/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/offre/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/credit/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/role/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("Admin");
        http.authorizeRequests().antMatchers("/carte/**").hasAuthority("Admin");

        http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
