package com.kinopoisk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * Created by Maksim Shkurko on 12/8/2017
 *
 * @author m.shkurko
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {

        return or(regex("/api/refresh"), regex("/api/auth"),
                regex("/api/auth/status"), regex("/api/register"),
                regex("/api/user"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Auth Service")
                .description("Auth Service for Kinopoisk Application")
                .termsOfServiceUrl("http://javainuse.com")
                .contact("Max Shkurko").version("1.0").build();
    }

}