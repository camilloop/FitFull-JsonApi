package org.camilloop.fitfull;

import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(KatharsisConfigV3.class)
public class FitfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitfullApplication.class, args);
	}
}
