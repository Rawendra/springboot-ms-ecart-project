package rawendra.org.srping_security_demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import rawendra.org.srping_security_demo.dto.UserInfoDto;
import rawendra.org.srping_security_demo.services.UserInfoDetailsServiceInterface;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserDetailsController {

  @Autowired
  private UserInfoDetailsServiceInterface userDetailsService;

  @PostMapping("/add-userDetails")
  public String addUser(@RequestBody UserInfoDto userInfoDto) {
    return userDetailsService.addUser(userInfoDto);
  }

  @GetMapping("/login-with-user")
  public String loginUser() {
    return "success";
  }




}
