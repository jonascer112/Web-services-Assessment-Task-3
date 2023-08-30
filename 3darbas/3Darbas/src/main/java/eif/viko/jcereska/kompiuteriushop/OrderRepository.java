package eif.viko.jcereska.kompiuteriushop;

import eif.viko.jcereska.kompiuteriushop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}