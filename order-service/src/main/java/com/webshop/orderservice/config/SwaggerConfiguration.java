package com.webshop.orderservice.config;

import com.webshop.orderservice.OrderServiceApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class)
public class SwaggerConfiguration {

    // TODO: make it work for OrderRepository

    @Bean
    public Docket apiDoc() {
        return new Docket(DocumentationType.SWAGGER_12)
                .select()
                .apis(RequestHandlerSelectors.basePackage(OrderServiceApplication.class.getPackage().getName()))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildMetadata());
    }

    private ApiInfo buildMetadata() {
        return new ApiInfoBuilder()
                .title("Order Service - REST API documentation")
                .version("v0.1")
                .contact(new Contact("Robert Balazsi", "http://robertbalazsi.com", "contact@robertbalazsi.com"))
                .build();
    }
}
