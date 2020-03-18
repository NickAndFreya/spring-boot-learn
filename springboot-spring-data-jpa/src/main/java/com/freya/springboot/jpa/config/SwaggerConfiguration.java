package com.freya.springboot.jpa.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Predicate;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/12 23:45
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
	/**
	 * 可指定多个Docket区分不同的分组
	 *
	 * @return
	 */
	@Bean
	public Docket defaultApi() {
		ParameterBuilder parameterBuilder = new ParameterBuilder();
		List<Parameter> parameters = new ArrayList();
		parameterBuilder.name("Access-Token").description("token 令牌").modelRef(new ModelRef("string"))
				.parameterType("header").required(true).build();
		parameters.add(parameterBuilder.build());
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				//分组名称
				.groupName("1.0.0版本")
				.select()
				//这里指定Controller扫描包路径
				.apis(RequestHandlerSelectors.basePackage("com.freya.springboot.jpa.controller"))
				//添加Api注解才显示
//				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any())
				.build();
//				.globalOperationParameters(parameters);
		return docket;
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("# Freya's API")
				.contact(new Contact("Freya", "https://github.com/NickAndFreya/springboot-learning", "freya@163.com"))
				.description("# Freya's RESTful APIs")
				.termsOfServiceUrl("localhost:8001/freya/")
				.version("1.0.0")
				.build();
	}

}
