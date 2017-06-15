package io.aera.config.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan({"io.aera.config", "io.aera.controller", "io.aera.model"})

public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver1 = new InternalResourceViewResolver();
        viewResolver1.setPrefix("/WEB-INF/views/");
        viewResolver1.setSuffix(".jsp");
        viewResolver1.setContentType("text/html;charset=utf-8");
        return viewResolver1;
    }
}
