package br.me.desafio3.minisistemadecadastro.seguraca;

import br.me.desafio3.minisistemadecadastro.models.Usuario;
import br.me.desafio3.minisistemadecadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfigSeguranca extends WebSecurityConfigurerAdapter {

//    @Bean
//    public DetalheUsuarioServico userDetailsService() {
//        return new DetalheUsuarioServico();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//        auth.setUserDetailsService(userDetailsService());
//        auth.setPasswordEncoder(passwordEncoder());
//
//        return auth;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/fornecedor/novo").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/home", true)
//                .failureUrl("/home123")
//                .permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/").permitAll();
//        return http.build();
//    }
//}




    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LoginSucesso loginSucesso;

    @Bean
    public BCryptPasswordEncoder gerarCriptografia() {
        BCryptPasswordEncoder criptografia = new BCryptPasswordEncoder();
        return criptografia;
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        DetalheUsuarioServico detalheDoUsuario = new DetalheUsuarioServico(usuarioRepository);
        return detalheDoUsuario;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/fornecedor/novo").permitAll()//.authenticated()
                .anyRequest().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/auth/auth-acesso-negado")
                .and()
                .formLogin().successHandler(loginSucesso)
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/fornecedor/novo")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetailsService detalheDoUsuario = userDetailsServiceBean();
        BCryptPasswordEncoder criptografia = gerarCriptografia();
        auth.userDetailsService(detalheDoUsuario).passwordEncoder(criptografia);
    }


}
