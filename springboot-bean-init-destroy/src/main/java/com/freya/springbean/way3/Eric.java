package com.freya.springbean.way3;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 19:41
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Eric {
	private String name;

	private Integer months;

	private int height;
}
