package com.freya.springbean.way4;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/3/17 20:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class Nick {
	private String name;

	private int height;

	private int age;
}
