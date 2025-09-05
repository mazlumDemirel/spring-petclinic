package org.springframework.boot.test.autoconfigure.orm.jpa;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link TestEntityManagerAutoConfiguration}.
 */
@Generated
public class TestEntityManagerAutoConfiguration__TestContext003_BeanDefinitions {
  /**
   * Get the bean definition for 'testEntityManagerAutoConfiguration'.
   */
  public static BeanDefinition getTestEntityManagerAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestEntityManagerAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(TestEntityManagerAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'testEntityManager'.
   */
  private static BeanInstanceSupplier<TestEntityManager> getTestEntityManagerInstanceSupplier() {
    return BeanInstanceSupplier.<TestEntityManager>forFactoryMethod(TestEntityManagerAutoConfiguration.class, "testEntityManager", EntityManagerFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration", TestEntityManagerAutoConfiguration.class).testEntityManager(args.get(0)));
  }

  /**
   * Get the bean definition for 'testEntityManager'.
   */
  public static BeanDefinition getTestEntityManagerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(TestEntityManager.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration");
    beanDefinition.setInstanceSupplier(getTestEntityManagerInstanceSupplier());
    return beanDefinition;
  }
}
