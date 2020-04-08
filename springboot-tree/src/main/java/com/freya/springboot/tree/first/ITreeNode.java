package com.freya.springboot.tree.first;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/4/8 17:24
 * @Description
 */
public interface ITreeNode {
	String getNodeId();
	String getNodeName();
	String getNodeParentId();
	Integer getOrderNum();
}

