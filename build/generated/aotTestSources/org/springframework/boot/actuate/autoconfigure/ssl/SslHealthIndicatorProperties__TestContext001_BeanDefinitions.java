package org.springframework.boot.actuate.autoconfigure.ssl;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SslHealthIndicatorProperties}.
 */
@Generated
public class SslHealthIndicatorProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'sslHealthIndicatorProperties'.
   */
  public static BeanDefinition getSslHealthIndicatorPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SslHealthIndicatorProperties.class);
    beanDefinition.setInstanceSupplier(SslHealthIndicatorProperties::new);
    return beanDefinition;
  }
}
