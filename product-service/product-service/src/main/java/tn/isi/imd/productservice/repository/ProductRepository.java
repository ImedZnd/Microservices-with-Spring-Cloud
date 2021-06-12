package tn.isi.imd.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.isi.imd.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
}
