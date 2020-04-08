package com.freya.springboot.tree.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/4/8 21:01
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Node implements Serializable {
	private static final long serialVersionUID = -8430361738349058061L;

	private long uuid;
	private Integer nodeId;
	private String nodeName;
	private Integer parentId;
	private Integer orderNum;
	private Integer level;
	private List<Node> children;
}
