package rawendra.org.srping_security_demo.config;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rawendra.org.srping_security_demo.services.UserInfoDetailsService;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.UUID;


//@Configuration
//@EnableWebSecurity
public class JwtSecurityConfig {
//
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//  @Bean
//  @Lazy
//  public UserDetailsService userDetailsService() {
//    return new UserInfoDetailsService();// InMemoryUserDetailsManager(admin, user);
//  }
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.csrf(AbstractHttpConfigurer::disable)
//
//            .authorizeHttpRequests(auth ->
//                    auth.requestMatchers("/product-service/**").
//
//                            permitAll().requestMatchers("/spring-security-custom/add-userDetails").permitAll()
//
//                            .anyRequest().authenticated()
//
//            );
////            .httpBasic(Customizer.withDefaults());
//    http.oauth2ResourceServer(oauth2 -> oauth2
//            .jwt(jwt -> jwt
//                    .jwtAuthenticationConverter(jwtAuthenticationConverter())
//            ));
//    http.sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//    return http.build();
//  }
//
//  private JwtAuthenticationConverter jwtAuthenticationConverter() {
//    JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
//    // Customize the converter if necessary
//    return converter;
//  }
//
//  @Bean
//  public AuthenticationProvider authenticationProvider() {
//    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//    authenticationProvider.setUserDetailsService(userDetailsService());
//    authenticationProvider.setPasswordEncoder(passwordEncoder());
//    return authenticationProvider;
//  }
//
//  @Bean
//  public WebMvcConfigurer corsConfigurer() {
//    return new WebMvcConfigurer() {
//      @Override
//      public void addCorsMappings(CorsRegistry registry) {
//        WebMvcConfigurer.super.addCorsMappings(registry);
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173") // Replace with your React app's URL
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                .allowedHeaders("*")
//                .allowCredentials(true);
//      }
//    };
//  }
//
//
//  @Bean
//  public KeyPair keyPair() {
//    KeyPairGenerator rsa = null;
//    try {
//      rsa = KeyPairGenerator.getInstance("RSA");
//      rsa.initialize(2048);
//      return rsa.generateKeyPair();
//
//    } catch (NoSuchAlgorithmException e) {
//      e.printStackTrace();
//      throw new RuntimeException("Unable to generate keyPair");
//    }
//
//
//  }
//
//
//  @Bean
//  public RSAKey rsaKey(KeyPair keyPair) {
//    return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
//            .privateKey(keyPair.getPrivate())
//            .keyID(UUID.randomUUID().toString())
//            .build();
//  }
//
//  @Bean
//  public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
//    JWKSet jwkSet = new JWKSet(rsaKey);
//
//   return  (jwkSelector, securityContext) -> {
//      return jwkSelector.select(jwkSet);
//
//    };
//
//  }
//
//  @Bean
//  public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
//    return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
//  }
//
//  @Bean
//  public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource){
//    return  new NimbusJwtEncoder(jwkSource);
//
//  }
//

}
