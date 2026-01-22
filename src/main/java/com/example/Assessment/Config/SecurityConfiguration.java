package com.example.Assessment.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.Assessment.Service.UserService;

// import com.example.Assessment.Model.User;

@Configuration
@EnableWebSecurity
// @EnableWebSecurity meka use kale thiya security eka epa me hadana eka us karanna kiyanna
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        return(
        http.csrf(customizer -> customizer.disable()) //methanin karanne security eken hadana login eka ain karanawa
        .authorizeHttpRequests(request ->request
            .requestMatchers("/User/login", "/User/creat")//this will be permited
            .permitAll() //any other request must be authenticated
            .anyRequest().authenticated())
        // http.formLogin(Customizer.withDefaults());
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .build());        
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userService);
        return provider;

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Throwable{
        return config.getAuthenticationManager();
    }



    // mekedi kiyanne yanna me thiya security eken kiyala. default eken yanna epa kiyala kiyanne

//     @Bean
//     public UserDetailsService userDetailsService(){
// //meke me thiya user1 user2 kiyana data walata witharai enna puluwn 
//         UserDetails user1 = User
//         .withDefaultPasswordEncoder()
//         .username("waruna")
//         .password("w@123")
//         .roles("USER")
//         .build();

//         UserDetails user2 = User
//         .withDefaultPasswordEncoder()
//         .username("selaka")
//         .password("s@123")
//         .roles("ADMID")
//         .build();

//         return new InMemoryUserDetailsManager(user1, user2);
//     }








    
}
