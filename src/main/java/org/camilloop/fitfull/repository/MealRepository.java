package org.camilloop.fitfull.repository;

import org.camilloop.fitfull.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealRepository extends MongoRepository<Meal, String> {
}