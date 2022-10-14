//package br.me.desafio3.minisistemadecadastro.configs.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import java.util.WeakHashMap;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
//
//        }
//        @Override
//    protected void  configure(AuthenticationManagerBuilder auth)   throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("salomao")
//                .password("1111")
//                .roles("ADMIN");
//        }
//
//}
