package com.zj.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * SpringIOC的工具类
 * 1.从IOC容器中获取指定类型的bean对象
 * 2.将任意一个对象注册到IOC容器中（跟@Component @Bean 注解的效果是完全一样的）
 */
@Component
public class ApplicationUtils implements BeanDefinitionRegistryPostProcessor, ApplicationContextAware {

    private static BeanDefinitionRegistry registry;

    private static ApplicationContext applicationContext;

    /**
     * 根据class对象获取IOC容器的bean
     * @param cls
     * @return
     * @param <T>
     */
    public static <T> T getBean(Class<T> cls) {
        return applicationContext.getBean(cls);
    }

    /**
     * 手动注册Bean对象
     */
    public static void registerBean(String beanName, Object bean) {

        // 将自定义的对象，包装成beanDefinition对象
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(bean.getClass(), new Supplier() {
            @Override
            public Object get() {
                return bean;
            }
        });

        // 注册Bean对象
        registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
    }


    /**
     * BeanDefinitionRegistry 把任意一个对象注册到IOC容器
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        ApplicationUtils.registry = registry;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationUtils.applicationContext = applicationContext;
    }
}
