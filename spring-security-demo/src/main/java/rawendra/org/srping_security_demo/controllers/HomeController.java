package rawendra.org.srping_security_demo.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/product-service")
public class HomeController {

  @GetMapping("/home")
  public String getHome(){
    return "index";
  }

  @GetMapping("/")
  public String getHomeLanding(){
    return "index";
  }

  @GetMapping("/products")
  @PreAuthorize("hasAuthority('USER','ADMIN')")
  public String getProducts(){
    return "returning the products list";
  }
  @GetMapping("/products-codes")
  @PreAuthorize("hasRole('admin')")
  public String getProductsCode(){
    return "returning the products list";
  }

}
