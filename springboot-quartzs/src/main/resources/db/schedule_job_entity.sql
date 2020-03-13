/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50027
Source Host           : localhost:3308
Source Database       : renren_security

Target Server Type    : MYSQL
Target Server Version : 50027
File Encoding         : 65001

Date: 2018-12-28 17:27:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for schedule_job_entity
-- ----------------------------
DROP TABLE IF EXISTS `schedule_job_entity`;
CREATE TABLE `schedule_job_entity` (
  `job_id` bigint(20) NOT NULL auto_increment COMMENT '任务id',
  `bean_name` varchar(200) default NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) default NULL COMMENT '方法名',
  `params` varchar(2000) default NULL COMMENT '参数',
  `cron_expression` varchar(100) default NULL COMMENT 'cron表达式',
  `status` tinyint(4) default NULL COMMENT '任务状态  0：正常  1：暂停',
  `remark` varchar(255) default NULL COMMENT '备注',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务';
