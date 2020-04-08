package com.freya.springboot.tree.first;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/4/8 17:25
 * @Description
 */

import java.util.List;

public interface ITree {
	public List<TreeNode> getTree();

	public List<TreeNode> getRoot();

	public TreeNode getTreeNode(String nodeId);
}
