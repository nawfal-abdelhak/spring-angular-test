package lu.atozdigital.api.Controllers;

import lu.atozdigital.api.DTO.ArticleDTO;
import lu.atozdigital.api.DTO.OrderDTO;
import lu.atozdigital.api.Models.Order;
import lu.atozdigital.api.Services.IOrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@CrossOrigin("*")
@RestController
public class OrderController {

    private final IOrderService orderService;

    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllOrders(){
        List<OrderDTO> orders = orderService.getAllOrders();

        return ResponseEntity.ok().body(orders);

    }

    @PostMapping("")
    public ResponseEntity<?> addOrder(@RequestBody List<ArticleDTO> articlesDTO){

        return ResponseEntity.ok().body(orderService.addOrder(articlesDTO));

    }

    @PutMapping ("{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id,@RequestBody List<ArticleDTO> articlesDTO){

       Order order = orderService.updateOrder(id,articlesDTO);

        if(order==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("not found");
        }
        else {
            return ResponseEntity.ok().body(order);
        }


    }
}
