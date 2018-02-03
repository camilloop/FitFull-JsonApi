package org.camilloop.fitfull.model;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonApiResource(type = "product")
@Document
public class Product {

    @Id
    @JsonApiId
    private String id;

    private String name;

    private float energy;

    private float protein;

    private float carbohydrates;

    private float fat;

    public Product() {
    }

    public Product(String name, float energy, float protein, float carbohydrates, float fat) {
        this.name = name;
        this.energy = energy;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
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

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Float.compare(product.getEnergy(), getEnergy()) != 0) return false;
        if (Float.compare(product.getProtein(), getProtein()) != 0) return false;
        if (Float.compare(product.getCarbohydrates(), getCarbohydrates()) != 0) return false;
        if (Float.compare(product.getFat(), getFat()) != 0) return false;
        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) return false;
        return getName() != null ? getName().equals(product.getName()) : product.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEnergy() != +0.0f ? Float.floatToIntBits(getEnergy()) : 0);
        result = 31 * result + (getProtein() != +0.0f ? Float.floatToIntBits(getProtein()) : 0);
        result = 31 * result + (getCarbohydrates() != +0.0f ? Float.floatToIntBits(getCarbohydrates()) : 0);
        result = 31 * result + (getFat() != +0.0f ? Float.floatToIntBits(getFat()) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", energy=" + energy +
                ", protein=" + protein +
                ", carbohydrates=" + carbohydrates +
                ", fat=" + fat +
                '}';
    }
}
