package org.camilloop.fitfull.katharsis;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.camilloop.fitfull.model.Meal;
import org.camilloop.fitfull.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class MealResourceRepository extends ResourceRepositoryBase<Meal, String> {

    private MealRepository mealRepository;

    @Autowired
    public MealResourceRepository(MealRepository mealRepository) {
        super(Meal.class);
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal findOne(String id, QuerySpec querySpec) {
        Optional<Meal> meal = this.mealRepository.findById(id);
        return meal.get();
    }

    @Override
    public ResourceList<Meal> findAll(QuerySpec querySpec) {
        return querySpec.apply(this.mealRepository.findAll());
    }

    @Override
    public <S extends Meal> S save(S resource) {
        this.mealRepository.save(resource);
        return resource;
    }

    @Override
    public void delete(String id) {
        this.mealRepository.deleteById(id);
    }
}
