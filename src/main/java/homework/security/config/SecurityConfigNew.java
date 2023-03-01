package homework.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

         User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
         auth.inMemoryAuthentication()
                 .withUser(userBuilder.username("Ivan").password("first").roles("Employee"))
                 .withUser(userBuilder.username("Petr").password("second").roles("IT"))
                 .withUser(userBuilder.username("Olga").password("third").roles("Security(Stuff)", "IT", "Employee"))
                 .withUser(userBuilder.username("Nikita").password("four").roles("Director", "Security(Stuff)", "IT", "Employee"));

            }
        }
