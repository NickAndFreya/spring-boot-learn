package com.freya.springboot.knife4j.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/13 11:03
 */

@Data
@Builder
@Accessors(chain = true)
@ApiModel(value = "Nick", description = "Nick's Desc")
public class Nick {
	@ApiModelProperty(name = "名字",notes = "名字")
	private String name;

	@ApiModelProperty(name = "爱好",notes = "爱好")
	private String hobby;

	@ApiModelProperty(name = "身高",notes = "身高 单位:cm")
	private Integer hight;
}
