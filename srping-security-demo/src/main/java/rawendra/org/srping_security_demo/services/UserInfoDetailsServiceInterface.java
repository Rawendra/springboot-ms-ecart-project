package rawendra.org.srping_security_demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rawendra.org.srping_security_demo.dto.UserInfoDto;


public interface UserInfoDetailsServiceInterface {

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

  String addUser(UserInfoDto userInfoDto);
}
