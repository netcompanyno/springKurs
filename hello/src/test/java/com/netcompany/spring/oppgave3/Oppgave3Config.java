package com.netcompany.spring.oppgave3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Config for oppgave 3.
 *
 * @author Torbjørn S. Knutsen
 */
@Configuration
@ComponentScan(basePackages = "com.netcompany.spring.oppgave3")
@PropertySource("classpath:spring.properties")
public class Oppgave3Config {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
