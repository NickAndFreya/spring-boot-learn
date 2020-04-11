package com.freya.springboot.tree.second;

import com.freya.springboot.tree.utils.SnowFlateWorker;
import com.freya.springboot.tree.utils.SnowFlateWorkerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author chengpiny
 * @version 1.0.0
 * @date 2020/4/11 20:38
 * @Description
 */
@RestController
@Slf4j
public class TestController {
	private List<Node> nodeList;
	private List<Node2> node2List;
	private LinkedHashSet<ResourceModel> resourceModels;

	@PostConstruct
	private void init() {
		nodeList = new ArrayList<>();
		nodeList.add(new Node().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(1).setNodeName("根目录").setParentId(null).setLevel(1));
		nodeList.add(new Node().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(2).setNodeName("二级目录1").setParentId(1).setLevel(2));
		nodeList.add(new Node().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(3).setNodeName("二级目录2").setParentId(1).setLevel(2));
		nodeList.add(new Node().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(4).setNodeName("三级目录1").setParentId(2).setLevel(3));
		nodeList.add(new Node().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(5).setNodeName("三级目录2").setParentId(3).setLevel(3));
		nodeList.add(new Node().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(6).setNodeName("四级目录1").setParentId(4).setLevel(4));
		nodeList.add(new Node().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(7).setNodeName("四级目录1").setParentId(5).setLevel(4));

		node2List = new ArrayList<>();
		node2List.add(new Node2().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(1).setNodeName("根目录").setParentId(null).setLevel(1));
		node2List.add(new Node2().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(2).setNodeName("二级目录1").setParentId(1).setLevel(2));
		node2List.add(new Node2().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(3).setNodeName("二级目录2").setParentId(1).setLevel(2));
		node2List.add(new Node2().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(4).setNodeName("三级目录1").setParentId(2).setLevel(3));
		node2List.add(new Node2().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(5).setNodeName("三级目录2").setParentId(3).setLevel(3));
		node2List.add(new Node2().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(6).setNodeName("四级目录1").setParentId(4).setLevel(4));
		node2List.add(new Node2().setUuid(SnowFlateWorkerUtil.uuid()).setNodeId(7).setNodeName("四级目录1").setParentId(5).setLevel(4));

		resourceModels = new LinkedHashSet<>();
		resourceModels.add(new ResourceModel().setNodeId(1).setResourceId(1).setResourceName("123").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(2).setResourceId(2).setResourceName("124").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(2).setResourceId(3).setResourceName("125").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(3).setResourceId(4).setResourceName("126").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(3).setResourceId(5).setResourceName("127").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(4).setResourceId(6).setResourceName("128").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(4).setResourceId(7).setResourceName("129").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(5).setResourceId(8).setResourceName("130").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(5).setResourceId(9).setResourceName("131").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(6).setResourceId(10).setResourceName("132").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(6).setResourceId(11).setResourceName("133").setResourceType(1));
		resourceModels.add(new ResourceModel().setNodeId(7).setResourceId(12).setResourceName("134").setResourceType(1));


	}

	@GetMapping("tree")
	public List<Node> treeList() {
		TreeUtil util = new TreeUtil(nodeList);
		log.info("树大小:{}", nodeList.size());
		List<Node> tree = util.buidTree();
		return tree;
	}

	@GetMapping("tree1")
	public List<Node2> tree2List() {
		TreeUtil2 util = new TreeUtil2(node2List, resourceModels);
		List<Node2> tree = util.buidTree();
		return tree;
	}

}
