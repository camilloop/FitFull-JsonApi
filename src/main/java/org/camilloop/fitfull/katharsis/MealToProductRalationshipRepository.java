package org.camilloop.fitfull.katharsis;

import com.google.common.collect.Lists;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.RelationshipRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import org.camilloop.fitfull.model.Meal;
import org.camilloop.fitfull.model.Product;
import org.camilloop.fitfull.repository.MealRepository;
import org.camilloop.fitfull.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MealToProductRalationshipRepository implements RelationshipRepositoryV2<Meal, String, Product, String> {

    private MealRepository mealRepository;

    private ProductRepository productRepository;

    @Autowired
    public MealToProductRalationshipRepository(MealRepository mealRepository, ProductRepository productRepository) {
        this.mealRepository = mealRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Class<Meal> getSourceResourceClass() {
        return Meal.class;
    }

    @Override
    public Class<Product> getTargetResourceClass() {
        return Product.class;
    }

    @Override
    public void setRelation(Meal meal, String s, String s2) {

    }

    @Override
    public void setRelations(Meal meal, Iterable<String> iterable, String s) {
        Iterable<Product> products = productRepository.findAllById(iterable);
        meal.setProducts(Lists.newArrayList(products));
        mealRepository.save(meal);
    }

    @Override
    public void addRelations(Meal meal, Iterable<String> iterable, String s) {
        List<Product> products = meal.getProducts();
        Iterable<Product> newProducts = productRepository.findAllById(iterable);
        products.addAll(Lists.newArrayList(newProducts));
        meal.setProducts(products);
        mealRepository.save(meal);
    }

    @Override
    public void removeRelations(Meal meal, Iterable<String> iterable, String s) {
        List<Product> products = meal.getProducts();
        products.removeAll(Lists.newArrayList(productRepository.findAllById(iterable)));
        meal.setProducts(products);
        mealRepository.save(meal);
    }

    @Override
    public Product findOneTarget(String s, String s2, QuerySpec querySpec) {
        return null;
    }

    @Override
    public ResourceList<Product> findManyTargets(String s, String s2, QuerySpec querySpec) {
        return querySpec.apply(this.mealRepository.findById(s).get().getProducts());
    }
}
