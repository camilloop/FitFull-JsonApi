package org.camilloop.fitfull.repository;

import org.camilloop.fitfull.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
