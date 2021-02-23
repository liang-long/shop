package cn.kgc.product.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Tiler on 2020/5/29
 */
//启用swagger:接口文档+在线调试
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    //basePackage:需要扫描swagger注解的包
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.kgc.product.server.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //title:页面标题，description:文档描述
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("商品管理API")
                .description("提供商品的增删改查等服务。")
                .termsOfServiceUrl("http://www.jwkt.net")
                .version("1.0")
                .build();
    }
}
