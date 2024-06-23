package rawendra.org.srping_security_demo.services;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rawendra.org.srping_security_demo.config.UserInfoUserDetails;
import rawendra.org.srping_security_demo.dto.UserInfoDto;
import rawendra.org.srping_security_demo.entities.UserInfoEntity;
import rawendra.org.srping_security_demo.repositories.UserRepository;

import java.util.Optional;


@Component
public class UserInfoDetailsService implements UserDetailsService, UserInfoDetailsServiceInterface {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserInfoEntity> userInfoEntity = userRepository.findByName(username);
    return userInfoEntity.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("no user found" + username));

  }

  @Override
  public String addUser(UserInfoDto userInfoDto) {
    String pwd=passwordEncoder.encode(userInfoDto.getPassword());
    System.out.println(pwd);
    UserInfoEntity userInfoEntity = UserInfoEntity.builder()
            .email(userInfoDto.getEmail())
            .name(userInfoDto.getName()).roles(userInfoDto.getRoles()).password(pwd).build();

    userRepository.save(userInfoEntity);
    return "user added successfully";
  }


}
