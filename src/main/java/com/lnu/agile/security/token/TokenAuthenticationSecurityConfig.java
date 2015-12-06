package com.lnu.agile.security.token;

import com.lnu.agile.security.AuthUserService;
import com.lnu.agile.config.filter.TokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@Order(1)
public class TokenAuthenticationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthUserService userDetailsService;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    public TokenAuthenticationSecurityConfig() {
        super(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().and()
                .anonymous().and()
                .servletApi().and()
                .headers().cacheControl().and()
                .authorizeRequests()
                //allow anonymous resource requests
                .antMatchers("/").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/auth").permitAll()
                //allow anonymous POSTs to login
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                //allow anonymous GETs to API
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                //defined Admin only API area
                .antMatchers("/admin").hasRole("ADMIN").and()
                //all other request need to be authenticated
                //.anyRequest().hasRole("USER").and()
                // custom Token based authentication based on the header previously given to the client
                .addFilterBefore(new TokenAuthenticationFilter(tokenAuthenticationService), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    /*@Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    } */
}
