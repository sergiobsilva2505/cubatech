package br.com.sbs.cubatech.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket cubatechCategoriesApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.sbs.cubatech.category.api"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Cubatech",
                "Programa de aceleração Level-Up Alura",
                "1.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new Contact("Sergio",
                        "https://github.com/sergiobsilva2505/cubatech",
                        "sergio@google.com.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }

}
