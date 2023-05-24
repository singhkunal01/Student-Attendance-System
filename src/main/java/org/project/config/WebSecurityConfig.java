package org.project.config;

import org.project.model.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan("org.project")

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().
                antMatchers("/").permitAll()
                .antMatchers("/loginPage").authenticated()
                .antMatchers("/student/**").hasAuthority("STUDENT")
                .antMatchers("/faculty/**").hasAuthority("FACULTY")
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessHandler(customLogoutSuccessHandler)
                .invalidateHttpSession(true);
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
// we need to disable it for uploading and for any external resources because by default it do not authorize to upload
    }

    // this is for the jdbc authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
    }
}