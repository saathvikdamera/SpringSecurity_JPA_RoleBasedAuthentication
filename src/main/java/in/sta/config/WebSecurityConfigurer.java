package in.sta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.sta.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer{
	
	private static final String ADMIN = "ADMIN";
	private static final String USER = "USER";
	
	@Autowired
	private MyUserDetailsService service;
	
	@Autowired
	public void authManager(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(service)
		       .passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Bean
	public SecurityFilterChain secure(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(req ->
		                                  req.antMatchers("/all").permitAll()
		                                     .antMatchers("/admin").hasAuthority(ADMIN)
		                                     .antMatchers("/user").hasAnyAuthority(ADMIN,USER)
		                                     .anyRequest().authenticated()
		                                  ).formLogin();
		
		return http.build();
	}

}
