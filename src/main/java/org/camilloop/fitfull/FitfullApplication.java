package org.camilloop.fitfull;

import com.google.common.collect.Sets;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import org.camilloop.fitfull.model.Meal;
import org.camilloop.fitfull.model.Product;
import org.camilloop.fitfull.repository.MealRepository;
import org.camilloop.fitfull.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(KatharsisConfigV3.class)
public class FitfullApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(FitfullApplication.class, args);

		//Testing data
		ProductRepository bean = run.getBean(ProductRepository.class);
		bean.deleteAll();
		Product banan = bean.save(new Product("Banan", 312, 12, 32, 23));
		Product maka = bean.save(new Product("Maka", 210, 11, 3, 1));

		MealRepository bean1 = run.getBean(MealRepository.class);
		bean1.deleteAll();
		Meal bananowiec = bean1.save(new Meal("Bananowiec"));
		bananowiec.setProducts(Sets.newHashSet(banan, maka));
		bean1.save(bananowiec);
	}
}
