package entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration  		//Hace referencia a que se trata a la clase con la configuracion de la seguridad
@EnableWebSecurity		//Hace que las solicitudes pasen por el filtro de seguridad
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override 	//Le decimos como se llevara a cabo el proceso de seguridad
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		//configuración basica de seguridad
		httpSecurity.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic(); 
	}

	@Autowired	//Le damos un acceso a los usuarios
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
		authentication.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin"))
				.authorities("ROLE_USER");
	}

	@Bean		//Encriptación de la contraseña
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
