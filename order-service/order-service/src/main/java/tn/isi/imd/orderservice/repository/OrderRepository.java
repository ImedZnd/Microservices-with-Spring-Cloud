package tn.isi.imd.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.imd.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
