/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : d1

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 20/10/2021 19:56:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for persons
-- ----------------------------
DROP TABLE IF EXISTS `persons`;
CREATE TABLE `persons`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `name` varchar(5) CHARACTER SET utf32 COLLATE utf32_bin NULL DEFAULT NULL COMMENT '姓名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `time` datetime NULL DEFAULT NULL COMMENT '时间',
  `sex` varchar(5) CHARACTER SET utf32 COLLATE utf32_bin NULL DEFAULT NULL COMMENT '性别',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf32 COLLATE = utf32_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of persons
-- ----------------------------
INSERT INTO `persons` VALUES ('1429079590477955074', 'lsx', 2, '1999-09-09 00:00:00', 'nan', '1999-09-09 09:00:08', '1999-09-09 09:00:10');
INSERT INTO `persons` VALUES ('1429079591060963330', 'lsx', 3, '1999-09-09 00:00:00', 'nan', '1999-09-09 09:00:08', '1999-09-09 09:00:10');
INSERT INTO `persons` VALUES ('1429079591631388673', 'lsx', 4, '1999-09-09 00:00:00', 'nan', '1999-09-09 09:00:08', '1999-09-09 09:00:10');
INSERT INTO `persons` VALUES ('1429079592176648194', 'lsx', 5, '1999-09-09 00:00:00', 'nan', '1999-09-09 09:00:08', '1999-09-09 09:00:10');
INSERT INTO `persons` VALUES ('1429079592713519106', 'lsx', 6, '1999-09-09 00:00:00', 'nan', '1999-09-09 09:00:08', '1999-09-09 09:00:10');
INSERT INTO `persons` VALUES ('1429079593313304577', 'lsx', 7, '1999-09-09 00:00:00', 'nan', '1999-09-09 09:00:08', '1999-09-09 09:00:10');
INSERT INTO `persons` VALUES ('1429378169784393730', '赖世雄', 8, '1999-09-09 09:00:09', '男', '1999-09-09 09:00:08', '2021-10-20 18:59:02');

SET FOREIGN_KEY_CHECKS = 1;
