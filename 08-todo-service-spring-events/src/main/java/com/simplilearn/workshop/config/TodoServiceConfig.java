package com.simplilearn.workshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = InfrastructueConfig.class) // We are saying there is another configuration
@ComponentScan(basePackages = "com.simplilearn.workshop.repository, com.simplilearn.workshop.service, com.simplilearn.workshop.repository, com.simplilearn.workshop.events")
public class TodoServiceConfig {


}
