package org.camilloop.fitfull.model;

import io.katharsis.resource.annotations.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@JsonApiResource(type = "meal")
@Document
public class Meal {

    @Id
    @JsonApiId
    private String id;

    private String name;

    @DBRef
    @JsonApiRelation(opposite = "meal")
    private List<Product> products;

    public Meal() {
    }

    public Meal(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        if (getId() != null ? !getId().equals(meal.getId()) : meal.getId() != null) return false;
        if (getName() != null ? !getName().equals(meal.getName()) : meal.getName() != null) return false;
        return getProducts() != null ? getProducts().equals(meal.getProducts()) : meal.getProducts() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
