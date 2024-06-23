package rawendra.org.spring_security_basic.controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import rawendra.org.spring_security_basic.dto.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class HelloController {

  private List<Person> personList = new ArrayList<>();

  public HelloController() {
    personList.add(new Person("R2", "male"));
    personList.add(new Person("R4", "female"));
    personList.add(new Person("R6", "male"));

  }

  @GetMapping
  @RequestMapping("/hello")

  public String getHello() {
    return "HELLOWORLD";
  }


  @GetMapping
  @RequestMapping("/get-csrf-token")
  public CsrfToken csrfToken(HttpServletRequest httpServletRequest) {
    return (CsrfToken) httpServletRequest.getAttribute("_csrf");

  }


  @PostMapping
  @RequestMapping("/add")
  public String create(@RequestBody Person person) {

    return "person created";
  }

  @GetMapping
  @RequestMapping("/getPerson/{id}")
  public Person getPerson(@PathVariable Integer id) {
    Person person = personList.get(id);
    log.info("person acquired {} for id {} ", person, id);
    return person;
  }

  @GetMapping
  @RequestMapping("/getPerson/all")
  public List<Person> getPerson() {
    log.info("person list acquired {}  ", personList);
    return personList;
  }


}
