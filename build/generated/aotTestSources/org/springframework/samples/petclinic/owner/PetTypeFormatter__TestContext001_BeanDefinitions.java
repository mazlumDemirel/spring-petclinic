package org.springframework.samples.petclinic.owner;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link PetTypeFormatter}.
 */
@Generated
public class PetTypeFormatter__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'petTypeFormatter'.
   */
  private static BeanInstanceSupplier<PetTypeFormatter> getPetTypeFormatterInstanceSupplier() {
    return BeanInstanceSupplier.<PetTypeFormatter>forConstructor(PetTypeRepository.class)
            .withGenerator((registeredBean, args) -> new PetTypeFormatter(args.get(0)));
  }

  /**
   * Get the bean definition for 'petTypeFormatter'.
   */
  public static BeanDefinition getPetTypeFormatterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PetTypeFormatter.class);
    beanDefinition.setInstanceSupplier(getPetTypeFormatterInstanceSupplier());
    return beanDefinition;
  }
}
