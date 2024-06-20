package rawendra.org.srping_security_demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rawendra.org.srping_security_demo.services.UserInfoDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurity {


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Lazy
  public UserDetailsService userDetailsService() {
    return new UserInfoDetailsService();// InMemoryUserDetailsManager(admin, user);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf(AbstractHttpConfigurer::disable)

            .authorizeHttpRequests(auth ->
                    auth.requestMatchers("/product-service/**").

                            permitAll()                            .requestMatchers("/spring-security-custom/add-userDetails").permitAll()

                            .anyRequest().authenticated()

            )
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .build();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173") // Replace with your React app's URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
      }
    };
  }


}
