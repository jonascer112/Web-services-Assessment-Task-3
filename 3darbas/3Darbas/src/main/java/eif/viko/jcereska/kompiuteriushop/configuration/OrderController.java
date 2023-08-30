package eif.viko.jcereska.kompiuteriushop.configuration;


import eif.viko.jcereska.kompiuteriushop.OrderRepository;
import eif.viko.jcereska.kompiuteriushop.exception.OrderNotFoundException;
import eif.viko.jcereska.kompiuteriushop.model.Order;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class OrderController {

    private final OrderRepository repository;

    private final OrderModelAssembler assembler;

    OrderController(OrderRepository repository, OrderModelAssembler assembler)
    {
        this.repository = repository;
        this.assembler = assembler;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/orders")
    CollectionModel<EntityModel<Order>> all(){

        List<EntityModel<Order>> orders = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(orders, linkTo(methodOn(OrderController.class).all()).withSelfRel());
    }

    @PutMapping("/orders/{id}")
    ResponseEntity<?> updateOrder(@RequestBody Order newOrder, @PathVariable Long id){

        Order updatedOrder = repository.findById(id)
                .map(order -> {
                    order.setOrderDate(newOrder.getOrderDate());
                    order.setCustomers(newOrder.getCustomers());
                    order.setComputers(newOrder.getComputers());
                    return repository.save(order);
                })
                .orElseGet(()->{
                    newOrder.setId(id);
                    return repository.save(newOrder);
                });

        EntityModel<Order> entityModel = assembler.toModel(updatedOrder);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/orders/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("orders/{id}")
    EntityModel<Order> one(@PathVariable Long id){

        Order order = repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        return assembler.toModel(order);
    }

    @PostMapping("/orders")
    ResponseEntity<?> newOrder(@RequestBody Order newOrder){

        EntityModel<Order> entityModel = assembler.toModel(repository.save(newOrder));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }
}