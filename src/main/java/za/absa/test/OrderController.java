package za.absa.test;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
  @Autowired
  private OrderRepository  repository;

  @GetMapping("/orders")
  public List<Order> findAll() {
    List<Order> orders = new ArrayList<>();
    repository.findAll().iterator().forEachRemaining(orders::add);
    return orders;
  }
  @PostMapping(value = "/order",consumes = "application/json")
  public Order newOrder( @RequestBody Order order) {
    return repository.save(order);
  }
  @GetMapping("/")
  public ResponseEntity healthCheck(){
    ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
    return responseEntity;
  }
}
