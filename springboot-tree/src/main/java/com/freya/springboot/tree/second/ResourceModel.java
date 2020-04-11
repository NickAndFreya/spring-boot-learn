package com.freya.springboot.tree.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/4/11 20:12
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@EqualsAndHashCode
public class ResourceModel {
	private Integer nodeId;
	private Integer resourceId;
	private Integer resourceType;
	private String resourceName;

}
