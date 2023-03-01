package homework.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfigNew extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;
    public SecurityConfigNew(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
        //          положили это в хранилище паролей наших, описанное выше
//         User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//         auth.inMemoryAuthentication()
//                 .withUser(userBuilder.username("Ivan").password("first").roles("Employee"))
//                 .withUser(userBuilder.username("Petr").password("second").roles("IT"))
//                 .withUser(userBuilder.username("Olga").password("third").roles("Security", "IT", "Employee"))
//                 .withUser(userBuilder.username("Nikita").password("four").roles("Director", "Security", "IT", "Employee"));

            }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests(authorize -> {
//            authorize.requestMatchers("/").permitAll();
//            authorize.requestMatchers("/employee").hasAnyRole("Employee");
//            authorize.requestMatchers("/IT").hasAnyRole("IT");
//            authorize.requestMatchers("/security").hasAnyRole("Security", "IT", "Employee");
//            authorize.requestMatchers("/director").hasAnyRole("Director", "Security", "IT", "Employee");
//                }).logout(logout -> logout.logoutUrl("/logout")).formLogin().loginProcessingUrl("/").permitAll();
//            http.build();

        http.authorizeHttpRequests()
                .antMatchers("/").hasAnyRole("Employee", "IT", "Security", "Director")
                .antMatchers("/employee").hasAnyRole("Employee")
                .antMatchers("/it").hasAnyRole("IT")
                .antMatchers("/security").hasAnyRole("Security", "IT", "Employee")
                .antMatchers("/director").hasAnyRole("Director", "Security", "IT", "Employee")
                .and().formLogin().permitAll();
    }
        }
