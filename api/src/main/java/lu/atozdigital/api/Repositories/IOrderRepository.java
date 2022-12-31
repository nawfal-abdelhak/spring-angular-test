package lu.atozdigital.api.Repositories;

import lu.atozdigital.api.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Long> {
}
