package com.freya.springboot.tree.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.LinkedHashSet;
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
public class Node2 implements Serializable {
	private static final long serialVersionUID = -8430361738349058061L;

	//主键
	private String uuid;
	//节点ID
	private Integer nodeId;
	//节点名称
	private String nodeName;
	//父节点ID
	private Integer parentId;
	//节点排序编码
	private int orderNum;
	//节点所在层级
	private Integer level;
	//子节点
	private List<Node2> children;
	//节点挂载资源
	private LinkedHashSet<ResourceModel> resources;

}
