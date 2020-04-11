package com.freya.springboot.tree.second;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/4/8 21:01
 * @Description
 */
public class TreeUtil2 {
	List<Node2> nodes = new ArrayList<Node2>();

	LinkedHashSet<ResourceModel> mounts = new LinkedHashSet<ResourceModel>();

	public TreeUtil2(List<Node2> nodes, LinkedHashSet<ResourceModel> mounts) {
		super();
		this.nodes = nodes;
		this.mounts = mounts;

	}

	/**
	 * 构建树形结构
	 *
	 * @return
	 */

	public List<Node2> buidTree() {
		List<Node2> treeNodes = new ArrayList<Node2>();
		List<Node2> rootNodes = getRootNodes();
		for (Node2 rootNode : rootNodes) {
			buildChildNodes(rootNode);
			treeNodes.add(rootNode);
		}
		return treeNodes;

	}

	/**
	 * 递归子节点
	 */
	public void buildChildNodes(Node2 node) {
		List<Node2> children = getChildNodes(node);
		if (!children.isEmpty()) {
			for (Node2 child : children) {
				buildChildNodes(child);
			}
			node.setChildren(children);
		}

	}

	/**
	 * 获取父节点下所有子节点
	 */
	public List<Node2> getChildNodes(Node2 pnode) {
		List<Node2> childNodes = new ArrayList<Node2>();
		for (Node2 n : nodes) {
			if (pnode.getNodeId().equals(n.getParentId())) {
				childNodes.add(n);
			}
		}
		//挂载资源
		for (Node2 n2 : childNodes) {
			LinkedHashSet<ResourceModel> models = new LinkedHashSet<ResourceModel>();
			for (ResourceModel model : mounts) {
				if (n2.getNodeId() == model.getNodeId()) {
					models.add(model);
					n2.setResources(models);
				}
			}
		}
		return childNodes;
	}

	/**
	 * 判断是否为根节点
	 */
	public boolean rootNode(Node2 node) {
		boolean isRootNode = true;
		for (Node2 n : nodes) {
			if (node.getParentId() != null && node.getParentId().equals(n.getNodeId())) {
				isRootNode = false;
				break;
			}
		}
		return isRootNode;
	}

	/**
	 * 获取集合中所有的根节点
	 */
	public List<Node2> getRootNodes() {
		List<Node2> rootNodes = new ArrayList<Node2>();
		for (Node2 n : nodes) {
			if (rootNode(n)) {
				rootNodes.add(n);
			}
		}
		//挂载资源
		for (Node2 node2 : rootNodes) {
			LinkedHashSet<ResourceModel> res = new LinkedHashSet<ResourceModel>();
			for (ResourceModel model : mounts) {
				if (node2.getNodeId() == model.getNodeId()) {
					res.add(model);
					node2.setResources(res);
				}
			}
		}
		return rootNodes;
	}

	@Override
	public String toString() {
		return "Tree{" +
				"nodes=" + nodes +
				'}';
	}
}
