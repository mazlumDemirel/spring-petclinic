package org.springframework.samples.petclinic;

import java.lang.Override;
import org.springframework.aot.generate.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Configure the environment with AOT optimizations.
 */
@Generated
public class PostgresIntegrationTests__TestContext002_EnvironmentPostProcessor implements EnvironmentPostProcessor {
  @Override
  public void postProcessEnvironment(ConfigurableEnvironment environment,
      SpringApplication application) {
    environment.addActiveProfile("postgres");
  }
}
