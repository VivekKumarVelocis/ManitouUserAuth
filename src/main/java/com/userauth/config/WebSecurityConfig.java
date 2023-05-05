package com.userauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import com.userauth.filter.JwtFilterConfig;
import com.userauth.security.CustomUserDetailsService;

/*
 * added by Vivek Kumar. Spring security bussness logic is written in that class 
*/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPointConfig szjwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService szjwtUserDetailsService;

	@Autowired
	private JwtFilterConfig szjwtRequestFilter;


	/*
	 * configure AuthenticationManager so that it knows from where to load user for
	 * matching credentials Use BCryptPasswordEncoder
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(szjwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean
	 * 
	 * @Override public AuthenticationManager authenticationManagerBean() throws
	 * Exception { return super.authenticationManagerBean(); }
	 */
//	@Bean
//	public UserDetailsService getuserdeDetailsService() {
//		return new UserDetailsService() {
//			
//			@Override
//			public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//	}
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new CustomUserDetailsService();
//	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(HttpSecurity l_httpSecurity) throws Exception {
 
		l_httpSecurity.csrf().disable()
//		.authorizeRequests().antMatchers("/authenticate/**").permitAll()
				.authorizeRequests().antMatchers("/authenticate/**").permitAll()
				.antMatchers("/user/**").hasAuthority("SUPERADMIN")
				.antMatchers("/dispatch/**").hasAnyAuthority("MACHINE_SALES_ADMIN","SUPERADMIN") 
				.anyRequest().authenticated().and()
				.exceptionHandling().authenticationEntryPoint(szjwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		l_httpSecurity.addFilterBefore(szjwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

//	@Bean
//	public UserDetailsService getuserdeDetailsService() {
//		return new UserDetailsService() {
//			
//			@Override
//			public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	 
	

}
