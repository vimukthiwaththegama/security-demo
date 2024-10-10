package com.vimukthi.security_demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig
{
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity httpSecurity ) throws Exception
    {

        return
                httpSecurity.csrf( AbstractHttpConfigurer::disable ).
                            authorizeHttpRequests( request -> request.anyRequest().authenticated() ).
                            httpBasic( Customizer.withDefaults() ).
                            sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ) ).
                            build();
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception
    {
        UserDetails user1 = User.withDefaultPasswordEncoder().
                                      username( "Vimukthi" ).
                                      password( "Vimukthi" ).
                                      roles( "Admin" ).build();

        UserDetails user2 = User.withDefaultPasswordEncoder().
                                username( "Waththe" ).
                                password( "Waththe" ).
                                roles( "Admin" ).build();

        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder( NoOpPasswordEncoder.getInstance());
        daoAuthenticationProvider.setUserDetailsService( userDetailsService );
        return authenticationProvider();
    }
}
