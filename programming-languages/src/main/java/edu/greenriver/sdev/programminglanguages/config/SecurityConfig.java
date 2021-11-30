package edu.greenriver.sdev.programminglanguages.config;

import edu.greenriver.sdev.programminglanguages.services.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    private LoginService service;

    public SecurityConfig(LoginService service)
    {
        this.service = service;
    }

    /**
     * Provide Spring security (and our configuration) with a
     * password hash algorithm.
     */
    @Bean
    public BCryptPasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }

    /**
     * We configure the mechanism for authentication in this
     * method (how we determine who a user is).
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        BCryptPasswordEncoder encoder = encoder();
        System.out.println(encoder.encode("pass"));

        //we will authenticate users with our own db records
        auth
            .userDetailsService(service)
            .passwordEncoder(encoder);

        //we will authenticate users with default test accounts
        /*auth
            .inMemoryAuthentication()
            .withUser("myuser")
                .password(encoder.encode("pass"))
                .roles("useracct")
            .and()
            .withUser("myadmin")
                .password(encoder.encode("pass"))
                .roles("useracct", "adminacct");*/
    }

    /**
     * Configure which files and folders are publicly available
     * in the app.
     */
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web
            .ignoring().antMatchers("/resources/**")
            .and()
            .ignoring().antMatchers("/h2-console/**");
    }

    /**
     * Configures permissions (authorization) and the login/logout
     * routines on the app.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .authorizeRequests()
                .antMatchers("/languages/random")
                    .hasAnyAuthority("admin")
                .antMatchers("/languages/top3")
                    .hasAnyAuthority("user")
                .antMatchers("/**")
                    .permitAll()
            .and()
            .formLogin()
                .failureForwardUrl("/login");
    }
}
