package org.camilloop.fitfull.katharsis;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.camilloop.fitfull.model.Product;
import org.camilloop.fitfull.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class ProductResourceRepository extends ResourceRepositoryBase<Product, String> {

    private ProductRepository productRepository;

    @Autowired
    public ProductResourceRepository(ProductRepository productRepository) {
        super(Product.class);
        this.productRepository = productRepository;
    }

    @Override
    public Product findOne(String id, QuerySpec querySpec) {
        Optional<Product> product = this.productRepository.findById(id);
        return product.get();
    }

    @Override
    public ResourceList<Product> findAll(QuerySpec querySpec) {
        return querySpec.apply(this.productRepository.findAll());
    }

    @Override
    public <S extends Product> S save(S resource) {
        this.productRepository.save(resource);
        return resource;
    }

    @Override
    public void delete(String id) {
        this.productRepository.deleteById(id);
    }
}
