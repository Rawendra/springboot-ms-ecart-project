package rawendra.org.srping_security_demo.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import rawendra.org.srping_security_demo.entities.UserInfoEntity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class UserInfoUserDetails implements UserDetails {

  private final String name;
  private final String password;
  private final List<GrantedAuthority> authorities;


  public UserInfoUserDetails(UserInfoEntity userInfoEntity){
    name=userInfoEntity.getName();
    password=userInfoEntity.getPassword();
    authorities= Arrays.stream(userInfoEntity.getRoles().split(","))
            .map(SimpleGrantedAuthority::new).collect(Collectors.toList());

  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return name;
  }
}
