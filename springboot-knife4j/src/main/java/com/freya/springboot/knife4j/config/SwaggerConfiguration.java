package com.freya.springboot.knife4j.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
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
				.apis(RequestHandlerSelectors.basePackage("com.freya.springboot.knife4j.controller"))
				.paths(PathSelectors.any())
				.build()
				.globalOperationParameters(parameters);
		return docket;
	}

	@Bean
	public Docket defaultApi2() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo2())
				//分组名称
				.groupName("2.0.0版本")
				.select()
				//指定添加了ApiOperation注解的类，才生成接口文档
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("# Test1 Knife4j")
				.description("# swagger-bootstrap-ui-demo RESTful APIs")
				.termsOfServiceUrl("localhost:8001/knife4j/")
				.version("1.0.0")
				.build();
	}

	private ApiInfo apiInfo2() {
		return new ApiInfoBuilder()
				.title("# Test2 Knife4j")
				.description("# swagger-bootstrap-ui-demo RESTful APIs")
				.termsOfServiceUrl("localhost:8001/knife4j/")
				.version("1.0.0")
				.build();
	}

}
