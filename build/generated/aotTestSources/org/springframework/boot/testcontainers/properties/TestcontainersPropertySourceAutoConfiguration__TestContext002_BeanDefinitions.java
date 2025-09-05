package org.springframework.boot.testcontainers.properties;

import java.lang.SuppressWarnings;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;

/**
 * Bean definitions for {@link TestcontainersPropertySourceAutoConfiguration}.
 */
@Generated
public class TestcontainersPropertySourceAutoConfiguration__TestContext002_BeanDefinitions {
  /**
   * Get the bean definition for 'testcontainersPropertySourceAutoConfiguration'.
   */
  public static BeanDefinition getTestcontainersPropertySourceAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestcontainersPropertySourceAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TestcontainersPropertySourceAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'dynamicPropertyRegistry'.
   */
  @SuppressWarnings("removal")
  private static BeanInstanceSupplier<DynamicPropertyRegistry> getDynamicPropertyRegistryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DynamicPropertyRegistry>forFactoryMethod(TestcontainersPropertySourceAutoConfiguration.class, "dynamicPropertyRegistry", ConfigurableApplicationContext.class)
            .withGenerator((registeredBean, args) -> TestcontainersPropertySourceAutoConfiguration.dynamicPropertyRegistry(args.get(0)));
  }

  /**
   * Get the bean definition for 'dynamicPropertyRegistry'.
   */
  public static BeanDefinition getDynamicPropertyRegistryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestcontainersPropertySourceAutoConfiguration.class);
    beanDefinition.setTargetType(DynamicPropertyRegistry.class);
    beanDefinition.setInstanceSupplier(getDynamicPropertyRegistryInstanceSupplier());
    return beanDefinition;
  }
}
