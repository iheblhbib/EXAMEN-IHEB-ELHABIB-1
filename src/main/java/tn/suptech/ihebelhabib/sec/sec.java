package tn.suptech.ihebelhabib.sec;

/*import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class sec extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //in memory authentification
       /* auth.inMemoryAuthentication().withUser("ahmed").password("{noop}123").roles("admin");
        auth.inMemoryAuthentication().withUser("rafik").password("{noop}123").roles("user");*/
        //jdbc authentification
       /* PasswordEncoder passwordEncoder = passwordEncoder();
        System.out.println("*******************************************************************************************************************");
        System.out.println(passwordEncoder.encode("123"));
        auth.inMemoryAuthentication().withUser("ahmed").password(passwordEncoder.encode("123")).roles("admin");
        auth.inMemoryAuthentication().withUser("rafik").password(passwordEncoder.encode("123")).roles("user");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        //http.httpBasic();
      //

        http.authorizeRequests().anyRequest().authenticated();
       // http.csrf(); //actvatio de mecanme contre attaque csrf
        //http.csrf().disable(); //desactiver
    }

}

*/
public class sec{

}

