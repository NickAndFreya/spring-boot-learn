package com.freya.springboot.tree.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/4/8 21:01
 * @Description
 */
public class TreeUtil {
	List<Node> nodes = new ArrayList<Node>();

	public TreeUtil(List<Node> nodes) {
		super();
		this.nodes = nodes;

	}

	/**
	 * 构建树形结构
	 *
	 * @return
	 */

	public List<Node> buidTree() {
		List<Node> treeNodes = new ArrayList<Node>();
		List<Node> rootNodes = getRootNodes();
		for (Node rootNode : rootNodes) {
			buildChildNodes(rootNode);
			treeNodes.add(rootNode);
		}
		return treeNodes;

	}

	/**
	 * 递归子节点
	 */
	private void buildChildNodes(Node node) {
		List<Node> children = getChildNodes(node);
		if (!children.isEmpty()) {
			for (Node child : children) {
				buildChildNodes(child);
			}
			node.setChildren(children);
		}

	}

	/**
	 * 获取父节点下所有子节点
	 */
	public List<Node> getChildNodes(Node pnode) {
		List<Node> childNodes = new ArrayList<Node>();
		for (Node n : nodes) {
			if (pnode.getNodeId().equals(n.getParentId())) {
				childNodes.add(n);
			}
		}
		return childNodes;
	}

	/**
	 * 判断是否为根节点
	 */
	public boolean rootNode(Node node) {
		boolean isRootNode = true;
		for (Node n : nodes) {
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
	public List<Node> getRootNodes() {
		List<Node> rootNodes = new ArrayList<Node>();
		for (Node n : nodes) {
			if (rootNode(n)) {
				rootNodes.add(n);
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
