package rawendra.org.spring_security_basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BasicAuthConfiguration {


  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((requests) -> {
      requests.anyRequest().authenticated();
    });
    http.sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    //http.formLogin(Customizer.withDefaults());
    http.headers(header->header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
    http.httpBasic(Customizer.withDefaults());
    http.csrf(AbstractHttpConfigurer::disable);
    return (SecurityFilterChain) http.build();
  }


  @Bean
  WebMvcConfigurer webMvcConfigurer(){
    return  new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*").allowedOrigins("http://localhost:3000");
      }
    };
  }

  @Bean
  public UserDetailsService userDetailsService(){
    var user1=User.withUsername("root1").password("{noop}root1").roles("USER").build();
    var user2=User.withUsername("root2").password("{noop}root2").roles("ADMIN").build();
    return  new InMemoryUserDetailsManager(user2,user1);
  }
}
