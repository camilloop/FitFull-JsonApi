package org.camilloop.fitfull.repository;

import org.camilloop.fitfull.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
