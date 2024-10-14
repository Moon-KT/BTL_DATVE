//package com.example.SB_Week9.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig<Docket> {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.SB_Week9.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(api(apiEndPointsInfo));
//    }
//
//    private ApiInfo apiEndPointsInfo() {
//        return new ApiInfoBuilder().title("Spring Boot REST API")
//                .description("Movie Ticket Booking System REST API")
//                .version("1.0")
//                .contact(new Contact("Your Name", "www.example.com", ""))
//                .license("Apache 2.0")
//                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
//                .build();
//    }
//}
