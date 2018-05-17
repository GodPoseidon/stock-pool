package com.huanxian.core.swagger2;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnProperty(name = "swagger2.enabled", havingValue = "true")
@EnableConfigurationProperties(Swagger2Properties.class)
@EnableSwagger2
public class Swagger2AutoConfiguration {
	
    /**
     * 描述 : addResourceHandlers
     *
     * @return WebMvcConfigurerAdapter
     */
    @Bean
    public WebMvcConfigurer addResourceHandlers() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("swagger-ui.html")
                        .addResourceLocations("classpath:/META-INF/resources/");
                registry.addResourceHandler("/webjars/**")
                        .addResourceLocations("classpath:/META-INF/resources/webjars/");
            }
        };
    }
    
    /**
     * 创建api文档
     *
     * @return createRestApi
     */
    @Bean
    @ConditionalOnMissingBean
    public Docket createRestApi(Swagger2Properties swagger2Properties) {
    	Docket docket = new Docket(DocumentationType.SWAGGER_2);
    	docket.apiInfo(apiInfo(swagger2Properties));
    	docket.groupName(swagger2Properties.getGroupName());
    	ApiSelectorBuilder apiSelectorBuilder = docket.select();
    	if(swagger2Properties.getScanBasePackage() != null && swagger2Properties.getScanBasePackage().size() > 0) {
    		List<Predicate<RequestHandler>> packges = new ArrayList<>();
    		for (String s : swagger2Properties.getScanBasePackage()) {
    			if(!StringUtils.isEmpty(s)) {
        			packges.add(RequestHandlerSelectors.basePackage(s));
    			}
			}
    		apiSelectorBuilder.apis(Predicates.or(packges));
    	}
		List<Predicate<RequestHandler>> annotations = new ArrayList<>();
    	if(swagger2Properties.getClassAnnotation() != null && swagger2Properties.getClassAnnotation().size() > 0) {
    		for (Class<? extends Annotation> a : swagger2Properties.getClassAnnotation()) {
    			annotations.add(RequestHandlerSelectors.withClassAnnotation(a));
			}
    	}
    	if(swagger2Properties.getMethodAnnotation() != null && swagger2Properties.getMethodAnnotation().size() > 0) {
    		for (Class<? extends Annotation> m : swagger2Properties.getMethodAnnotation()) {
    			annotations.add(RequestHandlerSelectors.withMethodAnnotation(m));
			}
    	}
    	if(!annotations.isEmpty()) {
    		apiSelectorBuilder.apis(Predicates.or(annotations));
    	}
    	return apiSelectorBuilder.paths(PathSelectors.any()).build();
    }

    /**
     * 描述 : apiInfo
     *
     * @return apiInfo
     */
    private ApiInfo apiInfo(Swagger2Properties swagger2Properties) {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title(swagger2Properties.getTitle());
        apiInfoBuilder.version(swagger2Properties.getVersion());
        apiInfoBuilder.description(swagger2Properties.getDesc());
        return apiInfoBuilder.build();
    }
	

}
