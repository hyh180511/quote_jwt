package com.demo.quote;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyh on 2018/10/17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.imec.quote.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
//                .globalResponseMessage(RequestMethod.GET, responseMessages());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Data API",
                "后端接口测试数据",
                "v1.0",
                "数据插入",
                "654758778@qq.com",
                "License of HYH",
                "http://www.baidu.com/");
        return apiInfo;
    }

//    private List<ResponseMessage> responseMessages(){
//        List<ResponseMessage> rms = new ArrayList<>();
//        rms.add(new ResponseMessageBuilder()
//                .code(500)
//                .message("系统出错")
//                .build());
//        rms.add(new ResponseMessageBuilder()
//                        .code(403)
//                        .message("拒绝访问")
//                        .build());
//        return rms;
//    }
}