package org.clojug.gradle.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración principal del contexto de spring
 */
@Configuration
@ComponentScan("org.clojug.gradle.services")
public class AppConfig {

}
