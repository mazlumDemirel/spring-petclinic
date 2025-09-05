package org.springframework.cache.jcache.config;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.cache.jcache.interceptor.BeanFactoryJCacheOperationSourceAdvisor;
import org.springframework.cache.jcache.interceptor.JCacheInterceptor;
import org.springframework.cache.jcache.interceptor.JCacheOperationSource;

/**
 * Bean definitions for {@link ProxyJCacheConfiguration}.
 */
@Generated
public class ProxyJCacheConfiguration__TestContext004_BeanDefinitions {
  /**
   * Get the bean definition for 'proxyJCacheConfiguration'.
   */
  public static BeanDefinition getProxyJCacheConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProxyJCacheConfiguration.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    InstanceSupplier<ProxyJCacheConfiguration> instanceSupplier = InstanceSupplier.using(ProxyJCacheConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(ProxyJCacheConfiguration__TestContext004_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'org.springframework.cache.config.internalJCacheAdvisor'.
   */
  private static BeanInstanceSupplier<BeanFactoryJCacheOperationSourceAdvisor> getInternalJCacheAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<BeanFactoryJCacheOperationSourceAdvisor>forFactoryMethod(ProxyJCacheConfiguration.class, "cacheAdvisor", JCacheOperationSource.class, JCacheInterceptor.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.cache.jcache.config.ProxyJCacheConfiguration", ProxyJCacheConfiguration.class).cacheAdvisor(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'internalJCacheAdvisor'.
   */
  public static BeanDefinition getInternalJCacheAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BeanFactoryJCacheOperationSourceAdvisor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setFactoryBeanName("org.springframework.cache.jcache.config.ProxyJCacheConfiguration");
    beanDefinition.setInstanceSupplier(getInternalJCacheAdvisorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jCacheInterceptor'.
   */
  private static BeanInstanceSupplier<JCacheInterceptor> getJCacheInterceptorInstanceSupplier() {
    return BeanInstanceSupplier.<JCacheInterceptor>forFactoryMethod(ProxyJCacheConfiguration.class, "cacheInterceptor", JCacheOperationSource.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.cache.jcache.config.ProxyJCacheConfiguration", ProxyJCacheConfiguration.class).cacheInterceptor(args.get(0)));
  }

  /**
   * Get the bean definition for 'jCacheInterceptor'.
   */
  public static BeanDefinition getJCacheInterceptorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JCacheInterceptor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setFactoryBeanName("org.springframework.cache.jcache.config.ProxyJCacheConfiguration");
    beanDefinition.setInstanceSupplier(getJCacheInterceptorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'jCacheOperationSource'.
   */
  private static BeanInstanceSupplier<JCacheOperationSource> getJCacheOperationSourceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<JCacheOperationSource>forFactoryMethod(ProxyJCacheConfiguration.class, "cacheOperationSource")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.cache.jcache.config.ProxyJCacheConfiguration", ProxyJCacheConfiguration.class).cacheOperationSource());
  }

  /**
   * Get the bean definition for 'jCacheOperationSource'.
   */
  public static BeanDefinition getJCacheOperationSourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JCacheOperationSource.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setFactoryBeanName("org.springframework.cache.jcache.config.ProxyJCacheConfiguration");
    beanDefinition.setInstanceSupplier(getJCacheOperationSourceInstanceSupplier());
    return beanDefinition;
  }
}
