package com.example.spring_doc.global.springDoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API서버", version = "v1"))
public class SpringDocConfig {

    // API 버전 v1에 해당하는 경로(/api/v1/**)를 그룹화하여 Swagger 문서에 표시
    @Bean
    public GroupedOpenApi groupApiV1() {
        return GroupedOpenApi.builder()
                .group("apiV1")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    // 모든 경로(/**)를 그룹화하여 Swagger 문서에 표시
    @Bean
    public GroupedOpenApi groupController() {
        return GroupedOpenApi.builder()
                .group("controller")
                .pathsToMatch("/**")
                .build();
    }
}
