package za.absa.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired
  private OrderRepository repository;

  @GetMapping("/find-all")
  public List<Order> findAll() {
    List<Order> orders = new ArrayList<>();
    repository.findAll().iterator().forEachRemaining(orders::add);
    return orders;
  }

  @PostMapping(value = "/create-order", consumes = "application/json")
  public Order newOrder(@RequestBody Order order) {
    return repository.save(order);
  }

  @GetMapping("/")
  public String healthCheck() {
    ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
    return responseEntity.getStatusCode().toString();
  }

  @GetMapping("/user")
  public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
    return Collections.singletonMap("name", principal.getAttribute("name"));
  }
}
