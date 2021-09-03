/*
 Navicat Premium Data Transfer

 Source Server         : myserver
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : 192.168.1.110:3306
 Source Schema         : shirobyjwt

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 03/09/2021 19:20:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `log_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `run_time` int(11) NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `param` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ip_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('0081478f3b70db1ba6c9c000203f3e33', '登录系统', 6, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"JPMMT\"},{\"paramName\":\"verKey\",\"paramValue\":\"2d0b7bf8256f4d5abd8cd394b1252cb8\"}]', '220.195.72.8', NULL, '2021-05-03 17:41:26', '0');
INSERT INTO `log` VALUES ('018566fe88d59f0b76443441f9467b5e', '登录系统', 35, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"hqc6k\"},{\"paramName\":\"verKey\",\"paramValue\":\"41fa33dfe7c64a269e63e707d5ea45b7\"}]', '222.35.40.162', NULL, '2021-06-22 11:28:49', '0');
INSERT INTO `log` VALUES ('04ca2c37b5eaa6f5891a23df765b8fd7', '获取用户列表', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '1.202.11.107', NULL, '2021-07-15 22:21:45', 'huhailong');
INSERT INTO `log` VALUES ('072b7c8e2ce38b5e11d5944cf4fa2a33', '登录系统', 22, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"m9wn9\"},{\"paramName\":\"verKey\",\"paramValue\":\"827291aa85d046d49cc1a94dd56b02ec\"}]', '222.35.40.165', NULL, '2021-06-02 13:32:22', '0');
INSERT INTO `log` VALUES ('1116baaaf56a41c67e7400a1fcb90c91', '登录系统', 38, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"3ehpt\"},{\"paramName\":\"verKey\",\"paramValue\":\"c0df572ab6a142cd8c2f55c36e42032d\"}]', '124.236.56.70', NULL, '2021-08-21 21:30:52', '0');
INSERT INTO `log` VALUES ('111a10b8b6a287f504b61d2e2d99eb1f', '查看个人中心', 15, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '119.28.137.131', NULL, '2021-06-24 13:08:39', 'huhailong');
INSERT INTO `log` VALUES ('167d40b2d7842a3808d134c159c5d5e1', '获取用户列表', 3, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.165', NULL, '2021-06-04 17:35:58', 'huhailong');
INSERT INTO `log` VALUES ('183da738c0a372018b6c9c4bf949e35d', '登录系统', 2, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"ebhq4\"},{\"paramName\":\"verKey\",\"paramValue\":\"65b42c66504e43cf81337c6fad2620de\"}]', '220.195.72.8', NULL, '2021-05-02 07:23:00', '0');
INSERT INTO `log` VALUES ('1845b88d2af9de5e1d587651489c0aac', '查看个人中心', 8, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 22:09:42', 'zhaoxiaochun');
INSERT INTO `log` VALUES ('1b88baab45653686729eb3bbca77a258', '获取用户列表', 140, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '124.236.56.70', NULL, '2021-08-21 19:54:27', 'huhailong');
INSERT INTO `log` VALUES ('1c74d7f2639e1ee36c94bf6822fd7d12', '获取用户列表', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '119.28.137.131', NULL, '2021-06-24 11:40:04', 'huhailong');
INSERT INTO `log` VALUES ('1f2122af7e77e901d5f7a3a858777763', '获取用户列表', 16, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '49.7.58.66', NULL, '2021-04-28 22:06:28', 'huhailong');
INSERT INTO `log` VALUES ('1f74fd81c82143d679309ff0d23057ed', '登录系统', 8, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"qq11\"},{\"paramName\":\"password\",\"paramValue\":\"q123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"wftx8\"},{\"paramName\":\"verKey\",\"paramValue\":\"5fccc5812321432884e30e7a07b93e93\"}]', '27.27.255.245', NULL, '2021-09-03 13:58:42', '0');
INSERT INTO `log` VALUES ('21ed9ad919206a60779ed5113f11d1ac', '查看个人中心', 6, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 22:11:15', 'zhaoxiaochun');
INSERT INTO `log` VALUES ('23a1584f1a37fd2b4955e01fdb12137d', '登录系统', 5, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"coolgai\"},{\"paramName\":\"password\",\"paramValue\":\"tfboyswjk0921\"},{\"paramName\":\"verCode\",\"paramValue\":\"jzr82\"},{\"paramName\":\"verKey\",\"paramValue\":\"feab4a2236b646079a42c7b2537a6ae4\"}]', '106.39.32.81', NULL, '2021-05-03 13:23:47', '0');
INSERT INTO `log` VALUES ('2552b38bf8e2e203dfdceb3459ec12a4', '登录系统', 34, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"rh6tj\"},{\"paramName\":\"verKey\",\"paramValue\":\"8b998b87687f4d8db1a20c921431bbff\"}]', '119.28.137.131', NULL, '2021-06-24 13:08:38', '0');
INSERT INTO `log` VALUES ('26350dbb46cadcf1a3feb42fb8605bbd', '获取用户列表', 3, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '61.49.113.62', NULL, '2021-05-17 13:08:42', 'huhailong');
INSERT INTO `log` VALUES ('2659fd3ab3f6a55ea81c77a907b88ee6', '登录系统', 4, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"admin\"},{\"paramName\":\"password\",\"paramValue\":\"admin\"},{\"paramName\":\"verCode\",\"paramValue\":\"tmd4k\"},{\"paramName\":\"verKey\",\"paramValue\":\"7812a5dd77e84563bcb8291e9c9210cf\"}]', '124.114.153.85', NULL, '2021-06-21 15:38:30', '0');
INSERT INTO `log` VALUES ('282943ba77ce8d9d1e8766e80aefc1d6', '查看个人中心', 6, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 22:01:21', 'huhailong');
INSERT INTO `log` VALUES ('284f75c877d8fea5f59474e66883dac1', '登录系统', 313, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"5rzud\"},{\"paramName\":\"verKey\",\"paramValue\":\"77b7ec7e494d4b01a3811a1587214c55\"}]', '124.236.56.70', NULL, '2021-08-21 19:54:23', '0');
INSERT INTO `log` VALUES ('2d1d33aab4d2c4447f637255caf48678', '登录系统', 1, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"zhaoxiaochun\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"cvxgc\"},{\"paramName\":\"verKey\",\"paramValue\":\"2e2d3f68ec6b48e0a25e66297a4a335a\"}]', '49.7.58.66', NULL, '2021-04-28 22:08:59', '0');
INSERT INTO `log` VALUES ('3083208c02af937b1a2f8de7965c64d6', '登录系统', 5, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"gnt6e\"},{\"paramName\":\"verKey\",\"paramValue\":\"2788e3ba2a164b828a9d663aedaa3a3e\"}]', '49.7.58.66', NULL, '2021-04-28 21:57:52', '0');
INSERT INTO `log` VALUES ('3773172a55a5136b2435220c4fa5ffc6', '获取用户列表', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '49.7.58.66', NULL, '2021-04-28 22:12:14', 'huhailong');
INSERT INTO `log` VALUES ('377e46f35ad5184cd3e59c36d880653f', '登录系统', 3, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"admin\"},{\"paramName\":\"password\",\"paramValue\":\"123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"bfzyh\"},{\"paramName\":\"verKey\",\"paramValue\":\"9fb8de090efe45c4b286f28fd243d55c\"}]', '124.89.86.18', NULL, '2021-05-31 17:41:57', '0');
INSERT INTO `log` VALUES ('424d321afc75fce206d4641fb8a0df56', '登录系统', 17, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"1234qwer\"},{\"paramName\":\"verCode\",\"paramValue\":\"vzfye\"},{\"paramName\":\"verKey\",\"paramValue\":\"b656157d2ece4501a6b7722522401f01\"}]', '49.7.58.66', NULL, '2021-04-28 22:01:18', '0');
INSERT INTO `log` VALUES ('42ff1751b3422287b4dbeeb5c0173d5f', '登录系统', 32, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"zqhzt\"},{\"paramName\":\"verKey\",\"paramValue\":\"cd47a1b4a21241f9b6ffe5fae3526ada\"}]', '1.202.11.107', NULL, '2021-07-15 22:21:42', '0');
INSERT INTO `log` VALUES ('445e5db3601a9eee5547c1ffc07585b1', '获取用户列表', 11, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '1.202.10.167', NULL, '2021-06-08 08:10:01', 'huhailong');
INSERT INTO `log` VALUES ('47a8ce16fb18ffac07ae8a0301ce232f', '登录系统', 11, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"admin\"},{\"paramName\":\"password\",\"paramValue\":\"admin\"},{\"paramName\":\"verCode\",\"paramValue\":\"rwruc\"},{\"paramName\":\"verKey\",\"paramValue\":\"eb645e7d98c24baf9d458e10a4d02c59\"}]', '124.114.153.85', NULL, '2021-06-21 15:38:08', '0');
INSERT INTO `log` VALUES ('4c58c1896d88cdb8c67641bb8971741e', '登录系统', 57, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"qeu4x\"},{\"paramName\":\"verKey\",\"paramValue\":\"42272d6e39154d2a82bf1cff291735a0\"}]', '119.28.137.131', NULL, '2021-06-21 21:43:06', '0');
INSERT INTO `log` VALUES ('50f83c94bea73a0de5c509478e20b144', '登录系统', 5, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"qq11\"},{\"paramName\":\"password\",\"paramValue\":\"q123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"1234\"},{\"paramName\":\"verKey\",\"paramValue\":\"ddb81034fbb748028f2e37a0bb56be9f\"}]', '27.27.255.245', NULL, '2021-09-03 13:57:47', '0');
INSERT INTO `log` VALUES ('5349debea2225a98bf3db9b57c68bc3d', '获取用户列表', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '49.7.58.66', NULL, '2021-04-28 22:10:10', 'huhailong');
INSERT INTO `log` VALUES ('5408e2420b213c536d8c875020558b3e', '登录系统', 137, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"q7tgx\"},{\"paramName\":\"verKey\",\"paramValue\":\"c1880adfad734648a0b2c7f36717d800\"}]', '222.35.40.180', NULL, '2021-07-21 12:51:32', '0');
INSERT INTO `log` VALUES ('56eb539bc6c791a7f3aed82ac25d2187', '查看个人中心', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 21:58:41', 'huhailong');
INSERT INTO `log` VALUES ('57a996ff0c119b65306c603af619d027', '登录系统', 5, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"qq11\"},{\"paramName\":\"password\",\"paramValue\":\"q123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"23144\"},{\"paramName\":\"verKey\",\"paramValue\":\"ddb81034fbb748028f2e37a0bb56be9f\"}]', '27.27.255.245', NULL, '2021-09-03 13:58:13', '0');
INSERT INTO `log` VALUES ('589a3eae304249e2cf399d008b498de6', '登录系统', 3, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"123\"},{\"paramName\":\"password\",\"paramValue\":\"123\"},{\"paramName\":\"verCode\",\"paramValue\":\"kv7nh\"},{\"paramName\":\"verKey\",\"paramValue\":\"47e206a1daf743daaab7210227642415\"}]', '124.89.86.18', NULL, '2021-05-31 17:41:16', '0');
INSERT INTO `log` VALUES ('5aab9091756b1c2113c33af5fc7c8ff8', '查看个人中心', 22, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '27.27.255.245', NULL, '2021-09-03 13:59:14', 'qq11');
INSERT INTO `log` VALUES ('5af3f17e1ed0320d968e71ab2a2bfbb7', '获取用户列表', 3, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '1.202.10.245', NULL, '2021-05-22 17:46:37', 'huhailong');
INSERT INTO `log` VALUES ('5feb60853d49a7ebef7188001b33721e', '登录系统', 3, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"123\"},{\"paramName\":\"password\",\"paramValue\":\"123\"},{\"paramName\":\"verCode\",\"paramValue\":\"d3grq\"},{\"paramName\":\"verKey\",\"paramValue\":\"1cbe6c28ecc046528f0a350eb7c79e34\"}]', '124.89.86.18', NULL, '2021-05-31 17:41:06', '0');
INSERT INTO `log` VALUES ('6039d7415055313d6e1ae28b61afd482', '获取用户列表', 13, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '49.7.58.66', NULL, '2021-04-28 22:10:26', 'huhailong');
INSERT INTO `log` VALUES ('61d6c1c3e5c813f5fe2367986facf3ff', '登录系统', 20, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"jznby\"},{\"paramName\":\"verKey\",\"paramValue\":\"4e3c4ca9c5aa43f8b39f62119b52625e\"}]', '1.202.10.245', NULL, '2021-05-22 17:46:26', '0');
INSERT INTO `log` VALUES ('647247534bf75d37c0efe25321be4531', '登录系统', 5, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"zhaoxiaochun\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"gkxgc\"},{\"paramName\":\"verKey\",\"paramValue\":\"2e2d3f68ec6b48e0a25e66297a4a335a\"}]', '49.7.58.66', NULL, '2021-04-28 22:09:14', '0');
INSERT INTO `log` VALUES ('68db909194e5c85c836d6507b34cc8d3', '查看个人中心', 6, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '119.28.137.131', NULL, '2021-06-24 13:08:46', 'huhailong');
INSERT INTO `log` VALUES ('6e8102e92abe15c8138538ee6a6c3a13', '查看个人中心', 55, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '117.174.103.221', NULL, '2021-08-17 17:04:33', 'artell2');
INSERT INTO `log` VALUES ('6fe2f278e9c4aafed2a65b49c3ed7013', '查看个人中心', 14, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '27.27.255.245', NULL, '2021-09-03 13:59:06', 'qq11');
INSERT INTO `log` VALUES ('73b44e03f99a3709dcaa765f5b4fa37f', '查看个人中心', 3, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 22:09:16', 'zhaoxiaochun');
INSERT INTO `log` VALUES ('74fe27a06a09d497f0a0fc455e25c848', '获取用户列表', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '49.7.58.66', NULL, '2021-04-28 22:11:45', 'huhailong');
INSERT INTO `log` VALUES ('77394783204f987bd35ee2ca5822fb06', '登录系统', 21, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"2234\"},{\"paramName\":\"password\",\"paramValue\":\"234\"},{\"paramName\":\"verCode\",\"paramValue\":\"q7hz4\"},{\"paramName\":\"verKey\",\"paramValue\":\"78ed4637e4c441c0b0877ceb1004f576\"}]', '124.89.86.18', NULL, '2021-06-01 13:35:48', '0');
INSERT INTO `log` VALUES ('78db1cc3e67b2ea64c8a454c0c41ecb7', '查看个人中心', 6, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 22:09:23', 'zhaoxiaochun');
INSERT INTO `log` VALUES ('795db52bcb84f5dac3c01dd09de7545d', '登录系统', 24, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"coolgai\"},{\"paramName\":\"password\",\"paramValue\":\"tfboyswjk0921\"},{\"paramName\":\"verCode\",\"paramValue\":\"tav37\"},{\"paramName\":\"verKey\",\"paramValue\":\"89b4da992cc548da8ca53fc7166cf861\"}]', '106.39.32.81', NULL, '2021-05-04 09:29:30', '0');
INSERT INTO `log` VALUES ('7a666f5c02ef6b708612d594bd8bfdd8', '登录系统', 48, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"dtpg8\"},{\"paramName\":\"verKey\",\"paramValue\":\"ea93f0cb9d17471097f8c06daa486f39\"}]', '1.202.8.68', NULL, '2021-05-30 10:23:02', '0');
INSERT INTO `log` VALUES ('7be92955108dde011754704382e3a626', '获取用户列表', 33, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.180', NULL, '2021-08-27 09:41:45', 'huhailong');
INSERT INTO `log` VALUES ('7d86b076d96ee30ec517c2c3df5af423', '登录系统', 1, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"123\"},{\"paramName\":\"password\",\"paramValue\":\"123\"},{\"paramName\":\"verCode\",\"paramValue\":\"对grq\"},{\"paramName\":\"verKey\",\"paramValue\":\"1cbe6c28ecc046528f0a350eb7c79e34\"}]', '124.89.86.18', NULL, '2021-05-31 17:40:56', '0');
INSERT INTO `log` VALUES ('82ca9e7c2c955572371aa9f16b224d74', '登录系统', 4, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"9gduh\"},{\"paramName\":\"verKey\",\"paramValue\":\"414c842aee554f59aeefcb5b591e0813\"}]', '49.7.58.66', NULL, '2021-04-28 22:10:08', '0');
INSERT INTO `log` VALUES ('85814f03fc7f76ff3c4aec1c6bbb9729', '修改个人信息', 17, 'vip.huhailong.shirobyjwt.controller.UserInfoController.updateUserInfo()', '[{\"paramName\":\"userInfo\",\"paramValue\":{\"avatar\":\"https://www.huhailong.vip/img/avatar/96a43e4d666c9c2ebc803a34bc517c82.jpg\",\"birthday\":\"2021-04-06\",\"gender\":\"w\",\"id\":\"2e52a31ba82b11ebb393b46bfc36a0ec\",\"job\":\"护士\",\"nickName\":\"小春\",\"phone\":\"12123412312\",\"userId\":\"96a43e4d666c9c2ebc803a34bc517c82\"}}]', '49.7.58.66', NULL, '2021-04-28 22:09:41', 'zhaoxiaochun');
INSERT INTO `log` VALUES ('86325d9a31f5bda89358d3b051ab7cdc', '查看个人中心', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 22:06:27', 'huhailong');
INSERT INTO `log` VALUES ('8924b0b02d4a7825e495a0c7ad68021d', '获取用户列表', 15, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"huhailong\"}}]', '222.35.40.165', NULL, '2021-06-02 13:32:35', 'huhailong');
INSERT INTO `log` VALUES ('8b0935114b1013e4e138961e43dc75c4', '获取用户列表', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.162', NULL, '2021-06-22 11:29:09', 'huhailong');
INSERT INTO `log` VALUES ('8b2cdef770baf2fb3e9439df5af12fe3', '查看个人中心', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '106.39.32.81', NULL, '2021-05-03 13:23:50', 'coolgai');
INSERT INTO `log` VALUES ('8d03c888464f60ab5300fbfb0c1f563a', '登录系统', 13, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"jmkuy\"},{\"paramName\":\"verKey\",\"paramValue\":\"fd8f3eb8266c4674900383fb9e8a0ec6\"}]', '49.7.58.66', NULL, '2021-04-28 22:03:36', '0');
INSERT INTO `log` VALUES ('8d124b50409b13e25692d346dbc78ea2', '获取用户列表', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '220.195.72.8', NULL, '2021-05-02 07:23:21', 'huhailong');
INSERT INTO `log` VALUES ('9340aacbb09bebdc20adacedae8d578a', '登录系统', 22, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"qq11\"},{\"paramName\":\"password\",\"paramValue\":\"q123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"BTmnp\"},{\"paramName\":\"verKey\",\"paramValue\":\"cfbd5dabd4604d518046468b4b92c395\"}]', '27.27.255.245', NULL, '2021-09-03 13:59:01', '0');
INSERT INTO `log` VALUES ('94558debc447ccb01231504419b0afdb', '登录系统', 2, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"qq11\"},{\"paramName\":\"password\",\"paramValue\":\"q123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"null\"},{\"paramName\":\"verKey\",\"paramValue\":\"ddb81034fbb748028f2e37a0bb56be9f\"}]', '27.27.255.245', NULL, '2021-09-03 13:57:45', '0');
INSERT INTO `log` VALUES ('94c6f3d432afffb8215b4c10c23db9f0', '登录系统', 23, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"hmrf4\"},{\"paramName\":\"verKey\",\"paramValue\":\"df558ed338274a30a6436fdb4d1de444\"}]', '49.7.58.67', NULL, '2021-05-10 23:01:36', '0');
INSERT INTO `log` VALUES ('95b9b89b07bac238e5f8823e8c6e3be4', '获取用户列表', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '116.113.3.34', NULL, '2021-05-06 10:36:49', 'huhailong');
INSERT INTO `log` VALUES ('965187fcedb69b33d78b82b746f90910', '登录系统', 3, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"admin\"},{\"paramName\":\"password\",\"paramValue\":\"123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"hjktz\"},{\"paramName\":\"verKey\",\"paramValue\":\"77a3042177874bb580f10089ffa94b7f\"}]', '124.236.243.208', NULL, '2021-06-10 16:31:55', '0');
INSERT INTO `log` VALUES ('96d68f82cd82d8616c683b07dd41c690', '获取用户列表', 15, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"小胡\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.165', NULL, '2021-06-02 13:32:47', 'huhailong');
INSERT INTO `log` VALUES ('970374e4df17f70e27c1f5123580b0e2', '登录系统', 9, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"qqqq\"},{\"paramName\":\"password\",\"paramValue\":\"a123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"null\"},{\"paramName\":\"verKey\",\"paramValue\":\"eb673cf9a028469b833e1b1d56ec71cf\"}]', '27.27.255.245', NULL, '2021-09-03 13:50:40', '0');
INSERT INTO `log` VALUES ('97791247561c849199402b4fcdd8fc88', '获取用户列表', 22, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '119.28.137.131', NULL, '2021-06-21 21:43:09', 'huhailong');
INSERT INTO `log` VALUES ('982c122532900b004708942d758f4b3e', '登录系统', 25, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"7b4eb\"},{\"paramName\":\"verKey\",\"paramValue\":\"f84fa8d8b56842f89f1fb2588815d009\"}]', '116.113.3.34', NULL, '2021-05-06 10:36:46', '0');
INSERT INTO `log` VALUES ('9a03d83245839611b8e2f56ced12e177', '修改密码', 25, 'vip.huhailong.shirobyjwt.controller.UserController.updatePassword()', '[{\"paramName\":\"map\",\"paramValue\":{\"oldPassword\":\"hhl110120119\",\"newPassword\":\"1234qwer\"}}]', '49.7.58.66', NULL, '2021-04-28 22:00:34', 'huhailong');
INSERT INTO `log` VALUES ('9b0237f3d32a0bcab2da49806514babd', '登录系统', 2, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"zhaoxiaochun\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"ckxgc\"},{\"paramName\":\"verKey\",\"paramValue\":\"2e2d3f68ec6b48e0a25e66297a4a335a\"}]', '49.7.58.66', NULL, '2021-04-28 22:09:05', '0');
INSERT INTO `log` VALUES ('9fdd517a4d9a31d5b15f4908f25d47ac', '登录系统', 2, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"hxfc7\"},{\"paramName\":\"verKey\",\"paramValue\":\"14a098d230ca49a68b863db91a5433df\"}]', '49.7.58.66', NULL, '2021-04-28 22:05:55', '0');
INSERT INTO `log` VALUES ('a07255656fb78c0d7152be53dee39c98', '登录系统', 4, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"coolgai\"},{\"paramName\":\"password\",\"paramValue\":\"tfboyswjk921\"},{\"paramName\":\"verCode\",\"paramValue\":\"jq8cp\"},{\"paramName\":\"verKey\",\"paramValue\":\"f34b507295694a8eb93b944bcf9d6f1d\"}]', '106.39.32.81', NULL, '2021-05-03 13:21:01', '0');
INSERT INTO `log` VALUES ('a0a742ae0efee0c55faec4eb2136fc3e', '登录系统', 11, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"4d4rc\"},{\"paramName\":\"verKey\",\"paramValue\":\"c4fe5f489ba34a8c997f4ecfb2ffa4c1\"}]', '49.7.58.66', NULL, '2021-04-28 21:55:42', '0');
INSERT INTO `log` VALUES ('a11f184ae9fdd97311d94be49584ae0e', '登录系统', 9, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"qqqq\"},{\"paramName\":\"password\",\"paramValue\":\"a123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"1\"},{\"paramName\":\"verKey\",\"paramValue\":\"eb673cf9a028469b833e1b1d56ec71cf\"}]', '27.27.255.245', NULL, '2021-09-03 13:50:42', '0');
INSERT INTO `log` VALUES ('a3ed0647866ae6a56b7d0d9475aec239', '登录系统', 4, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"coolgai\"},{\"paramName\":\"password\",\"paramValue\":\"tfboyswjk921\"},{\"paramName\":\"verCode\",\"paramValue\":\"agcue\"},{\"paramName\":\"verKey\",\"paramValue\":\"50ca9d96f30c47a596a4cb807abb3810\"}]', '106.39.32.81', NULL, '2021-05-03 13:19:18', '0');
INSERT INTO `log` VALUES ('a488f13a4e106d06143c97a2bbfbc5ca', '获取用户列表', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.165', NULL, '2021-06-02 13:32:27', 'huhailong');
INSERT INTO `log` VALUES ('aa516755d5e6183205693515378bb943', '获取用户列表', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.165', NULL, '2021-06-02 13:32:37', 'huhailong');
INSERT INTO `log` VALUES ('b0f6b09ea707f222b551faeedea925ec', '获取用户列表', 12, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.180', NULL, '2021-08-27 10:06:08', 'huhailong');
INSERT INTO `log` VALUES ('b140ba582574774abf38ea4c278c0287', '获取用户列表', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '220.195.72.8', NULL, '2021-05-03 17:41:29', 'huhailong');
INSERT INTO `log` VALUES ('b4d1cd4bd0f90642a35a39e88f9c270c', '登录系统', 3, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"coolgai\"},{\"paramName\":\"password\",\"paramValue\":\"tfboyswjk921\"},{\"paramName\":\"verCode\",\"paramValue\":\"stsr8\"},{\"paramName\":\"verKey\",\"paramValue\":\"641973e5353f490cbfafe268d700a856\"}]', '106.39.32.81', NULL, '2021-05-03 13:19:30', '0');
INSERT INTO `log` VALUES ('b84a7529e13d855faa09ee27fbe511bf', '获取用户列表', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '49.7.58.66', NULL, '2021-04-28 22:11:10', 'huhailong');
INSERT INTO `log` VALUES ('ba033653c5b76b221cd8540995ea58d9', '登录系统', 20, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"admin\"},{\"paramName\":\"password\",\"paramValue\":\"admin\"},{\"paramName\":\"verCode\",\"paramValue\":\"ggczt\"},{\"paramName\":\"verKey\",\"paramValue\":\"afbdaeda602f453bab68c96bc149ba1d\"}]', '223.159.115.194', NULL, '2021-06-26 16:08:30', '0');
INSERT INTO `log` VALUES ('bec20a83f6a8897b10af5589eb81408b', '登录系统', 21, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"nf89y\"},{\"paramName\":\"verKey\",\"paramValue\":\"c021638d83fe45248a50088c23e7f780\"}]', '222.35.40.180', NULL, '2021-06-23 10:08:34', '0');
INSERT INTO `log` VALUES ('c05487980b0b5e4ff7dbf51c1b83f3df', '登录系统', 343, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"gvq8r\"},{\"paramName\":\"verKey\",\"paramValue\":\"84789257222e45e0848852311464c247\"}]', '222.35.40.180', NULL, '2021-08-27 09:41:44', '0');
INSERT INTO `log` VALUES ('c151a097d829963c536992a15018ea70', '登录系统', 2, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"qqqq\"},{\"paramName\":\"password\",\"paramValue\":\"a123456\"},{\"paramName\":\"verCode\",\"paramValue\":\"1111\"},{\"paramName\":\"verKey\",\"paramValue\":\"eb673cf9a028469b833e1b1d56ec71cf\"}]', '27.27.255.245', NULL, '2021-09-03 13:50:43', '0');
INSERT INTO `log` VALUES ('c2342d08966f111bd74b34e2fa761537', '查看个人中心', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '106.39.32.81', NULL, '2021-05-03 13:21:05', 'coolgai');
INSERT INTO `log` VALUES ('c3186cf7d4fb3f085c54058f90b81b78', '登录系统', 16, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"admin123\"},{\"paramName\":\"password\",\"paramValue\":\"1qaz2wsx\"},{\"paramName\":\"verCode\",\"paramValue\":\"tmd4k\"},{\"paramName\":\"verKey\",\"paramValue\":\"7812a5dd77e84563bcb8291e9c9210cf\"}]', '124.114.153.85', NULL, '2021-06-21 15:39:13', '0');
INSERT INTO `log` VALUES ('c6ec865c32435dd1f6c672db3c1e3f19', '登录系统', 18, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"pztyx\"},{\"paramName\":\"verKey\",\"paramValue\":\"7a76ec5dd906477f9091b9390d713699\"}]', '222.35.40.165', NULL, '2021-06-04 17:35:56', '0');
INSERT INTO `log` VALUES ('c929bdaf5fecb4b2d7d2484efb864461', '登录系统', 1, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"```\"},{\"paramName\":\"password\",\"paramValue\":\"```\"},{\"paramName\":\"verCode\",\"paramValue\":\"```\"},{\"paramName\":\"verKey\",\"paramValue\":\"3056bbc34e684874b8010f52660d3d6f\"}]', '113.247.55.35', NULL, '2021-05-12 19:48:45', '0');
INSERT INTO `log` VALUES ('ca34e0339941abd1a0767bb365e445e0', '登录系统', 1, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"111\"},{\"paramName\":\"password\",\"paramValue\":\"111\"},{\"paramName\":\"verCode\",\"paramValue\":\"null\"},{\"paramName\":\"verKey\",\"paramValue\":\"ed020ff67b674244a9ae44cf25a3de75\"}]', '223.104.218.166', NULL, '2021-06-13 23:04:12', '0');
INSERT INTO `log` VALUES ('cd88d4d4caff67c9151e751f343d3ee2', '获取用户列表', 8, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '1.202.8.68', NULL, '2021-05-30 10:23:04', 'huhailong');
INSERT INTO `log` VALUES ('ce877d823162df2430d468c12c32d00c', '登录系统', 20, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"tbzzk\"},{\"paramName\":\"verKey\",\"paramValue\":\"b8deb035fd764f37b7c8e1822481defb\"}]', '1.202.8.23', NULL, '2021-06-05 08:37:17', '0');
INSERT INTO `log` VALUES ('ce9f9eb38b3d96f7825829baee735b5f', '查看个人中心', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 21:59:42', 'huhailong');
INSERT INTO `log` VALUES ('d02fd9bd8d3230933279e5a2bdacec30', '获取用户列表', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '49.7.58.66', NULL, '2021-04-28 22:12:23', 'huhailong');
INSERT INTO `log` VALUES ('d08124f9696221b3ab79e40842a69680', '查看个人中心', 17, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '222.35.40.180', NULL, '2021-08-27 10:06:02', 'huhailong');
INSERT INTO `log` VALUES ('d15436a9107c5dd3f022005236ba8399', '登录系统', 5, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"admin\"},{\"paramName\":\"password\",\"paramValue\":\"admin\"},{\"paramName\":\"verCode\",\"paramValue\":\"hahsv\"},{\"paramName\":\"verKey\",\"paramValue\":\"12466339b2554fc1bd7d922b8bc0c2a6\"}]', '124.236.243.208', NULL, '2021-06-10 16:31:39', '0');
INSERT INTO `log` VALUES ('d512818edf245387464d20872172e3f3', '登录系统', 4, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"zhaoxiaochun\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"apqd2\"},{\"paramName\":\"verKey\",\"paramValue\":\"376a92f7545d4a43ac6e9db5663b3ecc\"}]', '49.7.58.66', NULL, '2021-04-28 22:11:00', '0');
INSERT INTO `log` VALUES ('d78da4c4cc3bc828b69958a289b40575', '查看个人中心', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '119.28.137.131', NULL, '2021-06-24 13:08:50', 'huhailong');
INSERT INTO `log` VALUES ('d82bfb78dea65cf8ef998a8cea281d27', '获取用户列表', 46, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.180', NULL, '2021-07-21 12:51:34', 'huhailong');
INSERT INTO `log` VALUES ('d98a11cee90571bc8b8d762309a12133', '登录系统', 21, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"kkzms\"},{\"paramName\":\"verKey\",\"paramValue\":\"089f5c0787b641579e16e212497ab000\"}]', '1.202.10.167', NULL, '2021-06-08 08:10:00', '0');
INSERT INTO `log` VALUES ('d9e9f27fcc0440f34ac689cb748b0b57', '查看个人中心', 6, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 21:58:08', 'huhailong');
INSERT INTO `log` VALUES ('dd95568d20e2be766ead1662e2af6ab8', '修改个人信息', 19, 'vip.huhailong.shirobyjwt.controller.UserInfoController.updateUserInfo()', '[{\"paramName\":\"userInfo\",\"paramValue\":{\"avatar\":\"https://www.huhailong.vip/img/avatar/c6603e8d028c798e67c4620736e29dc1.jpg\",\"birthday\":\"1996-11-21\",\"gender\":\"m\",\"id\":\"298e1634a82911ebb393b46bfc36a0ec\",\"job\":\"程序猿\",\"nickName\":\"小胡\",\"phone\":\"12345678901\",\"userId\":\"c6603e8d028c798e67c4620736e29dc1\"}}]', '49.7.58.66', NULL, '2021-04-28 21:59:42', 'huhailong');
INSERT INTO `log` VALUES ('de9347e50dc796911fad3aeaf9487021', '登录系统', 5, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"ebh94\"},{\"paramName\":\"verKey\",\"paramValue\":\"65b42c66504e43cf81337c6fad2620de\"}]', '220.195.72.8', NULL, '2021-05-02 07:23:07', '0');
INSERT INTO `log` VALUES ('e0e71d8ea8c0e5aa87a67c3c0c0320f4', '查看个人中心', 11, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '49.7.58.66', NULL, '2021-04-28 22:03:39', 'huhailong');
INSERT INTO `log` VALUES ('e232b26a229a627813318fd8683adab7', '登录系统', 5, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"zhaoxiaochun\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"apqd2\"},{\"paramName\":\"verKey\",\"paramValue\":\"376a92f7545d4a43ac6e9db5663b3ecc\"}]', '49.7.58.66', NULL, '2021-04-28 22:11:14', '0');
INSERT INTO `log` VALUES ('e60b7fa710f94f4cec00210622f126f9', '获取用户列表', 3, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '49.7.58.67', NULL, '2021-05-10 23:01:38', 'huhailong');
INSERT INTO `log` VALUES ('e7291acf6914cb8c3c70e3fefd6c98b1', '登录系统', 1, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"juqme\"},{\"paramName\":\"verKey\",\"paramValue\":\"4ff5e33c3fe64e58adbb3e6ec2d00e38\"}]', '61.49.113.62', NULL, '2021-05-17 13:08:36', '0');
INSERT INTO `log` VALUES ('e822bb48688159172da8e843d542b160', '登录系统', 11, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"hxfcy\"},{\"paramName\":\"verKey\",\"paramValue\":\"14a098d230ca49a68b863db91a5433df\"}]', '49.7.58.66', NULL, '2021-04-28 22:06:02', '0');
INSERT INTO `log` VALUES ('ec57c9a5043a9507c3a3e12f76cab075', '获取用户列表', 4, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.165', NULL, '2021-06-02 13:32:49', 'huhailong');
INSERT INTO `log` VALUES ('f14aabb520f80e2dc2612aa44689a232', '登录系统', 36, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"8jdth\"},{\"paramName\":\"verKey\",\"paramValue\":\"b9461c7892994fecad3c1c9ca3bbd964\"}]', '119.28.137.131', NULL, '2021-06-24 11:40:02', '0');
INSERT INTO `log` VALUES ('f4c106b47bd137d86435ad8c755f52b1', '登录系统', 13, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"admin\"},{\"paramName\":\"password\",\"paramValue\":\"admin\"},{\"paramName\":\"verCode\",\"paramValue\":\"hjktz\"},{\"paramName\":\"verKey\",\"paramValue\":\"77a3042177874bb580f10089ffa94b7f\"}]', '124.236.243.208', NULL, '2021-06-10 16:31:50', '0');
INSERT INTO `log` VALUES ('f6b0a3eb1494f52d570d3b4406ce0eb1', '查看个人中心', 7, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfo()', '[]', '27.27.255.245', NULL, '2021-09-03 13:59:45', 'qq11');
INSERT INTO `log` VALUES ('f8946a5f85dc29219de037266a6fc9b3', '登录系统', 3, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"huhailong\"},{\"paramName\":\"password\",\"paramValue\":\"hhl110120119\"},{\"paramName\":\"verCode\",\"paramValue\":\"ju9me\"},{\"paramName\":\"verKey\",\"paramValue\":\"4ff5e33c3fe64e58adbb3e6ec2d00e38\"}]', '61.49.113.62', NULL, '2021-05-17 13:08:40', '0');
INSERT INTO `log` VALUES ('fc2c036de2d823d764a3bf858cc6d88f', '获取用户列表', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.180', NULL, '2021-06-23 10:08:36', 'huhailong');
INSERT INTO `log` VALUES ('fdd27e529b284f19651b7d6d40f6e2c2', '登录系统', 24, 'vip.huhailong.shirobyjwt.controller.ShiroController.login()', '[{\"paramName\":\"username\",\"paramValue\":\"coolgai\"},{\"paramName\":\"password\",\"paramValue\":\"tfboyswjk921\"},{\"paramName\":\"verCode\",\"paramValue\":\"uvtnh\"},{\"paramName\":\"verKey\",\"paramValue\":\"d988f35f56794103ab4001bf79d30b23\"}]', '106.39.32.81', NULL, '2021-05-03 12:34:58', '0');
INSERT INTO `log` VALUES ('fec200bc245b537a0168c22fa650d915', '获取用户列表', 5, 'vip.huhailong.shirobyjwt.controller.UserInfoController.getUserInfoList()', '[{\"paramName\":\"vo\",\"paramValue\":{\"enableMail\":\"\",\"nickName\":\"\",\"pageNum\":1,\"pageSize\":10,\"username\":\"\"}}]', '222.35.40.162', NULL, '2021-06-22 11:28:55', 'huhailong');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '菜单主键',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `router` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单路由',
  `click` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '点击事件方法',
  `parent` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级菜单',
  `menu_order` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('02e4dcc0942011ebbb42b46bfc36a0ec', '个人中心', 'el-icon-user-solid', '/user', '', '0', 9);
INSERT INTO `menu` VALUES ('0893d10e942111ebbb42b46bfc36a0ec', '退出系统', 'el-icon-switch-button', '/login', 'logout', '0', 1);
INSERT INTO `menu` VALUES ('1d7b6fa3942011ebbb42b46bfc36a0ec', '用户管理', 'el-icon-s-order', '/userMananger', '', '0', 8);
INSERT INTO `menu` VALUES ('30d33b79942011ebbb42b46bfc36a0ec', '角色管理', 'el-icon-view', '/role', '', '0', 7);
INSERT INTO `menu` VALUES ('3e605229942011ebbb42b46bfc36a0ec', '统计', 'el-icon-s-data', '/sta', '', '0', 4);
INSERT INTO `menu` VALUES ('59e473fd942011ebbb42b46bfc36a0ec', '系统日志', 'el-icon-s-claim', '/log', '', '0', 3);
INSERT INTO `menu` VALUES ('69050744942011ebbb42b46bfc36a0ec', '关于系统', 'el-icon-question', '/about', '', '0', 2);
INSERT INTO `menu` VALUES ('b3a82d1496cf11ebbb42b46bfc36a0ec', '菜单管理', 'el-icon-menu', '/menuManager', NULL, '0', 6);
INSERT INTO `menu` VALUES ('dabdd96b7d048cbd62c832a190b57b6a', '测试菜单', 'el-icon-search', '/about', NULL, '0', 5);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('4c55a4e487c411ebb1145405db8174c1', 'user', '普通用户');
INSERT INTO `role` VALUES ('bcfe9a7434e51c77d639eb527f874548', 'test', '测试角色');
INSERT INTO `role` VALUES ('c49540b287c211ebb1145405db8174c1', 'admin', '管理员');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('04bfbac996d511ebb393b46bfc36a0ec', 'c49540b287c211ebb1145405db8174c1', '59e473fd942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('04bfbb1a96d511ebb393b46bfc36a0ec', '4c55a4e487c411ebb1145405db8174c1', '59e473fd942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('0553a07696d611ebb393b46bfc36a0ec', 'c49540b287c211ebb1145405db8174c1', '30d33b79942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('096b1beb96d511ebb393b46bfc36a0ec', 'c49540b287c211ebb1145405db8174c1', '69050744942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('096b1c3f96d511ebb393b46bfc36a0ec', '4c55a4e487c411ebb1145405db8174c1', '69050744942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('0e93b08296d511ebb393b46bfc36a0ec', 'c49540b287c211ebb1145405db8174c1', '0893d10e942111ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('0e93b0d296d511ebb393b46bfc36a0ec', '4c55a4e487c411ebb1145405db8174c1', '0893d10e942111ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('1455b0bc96d511ebb393b46bfc36a0ec', 'c49540b287c211ebb1145405db8174c1', '02e4dcc0942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('1455b11696d511ebb393b46bfc36a0ec', '4c55a4e487c411ebb1145405db8174c1', '02e4dcc0942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('33e6439e96d311ebbb42b46bfc36a0ec', 'c49540b287c211ebb1145405db8174c1', 'b3a82d1496cf11ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('e7a408caa82b11ebb393b46bfc36a0ec', '4c55a4e487c411ebb1145405db8174c1', 'dabdd96b7d048cbd62c832a190b57b6a');
INSERT INTO `role_menu` VALUES ('f380ae7d96d511ebb393b46bfc36a0ec', 'c49540b287c211ebb1145405db8174c1', '1d7b6fa3942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('ffb2647b96d411ebb393b46bfc36a0ec', 'c49540b287c211ebb1145405db8174c1', '3e605229942011ebbb42b46bfc36a0ec');
INSERT INTO `role_menu` VALUES ('ffb264c796d411ebb393b46bfc36a0ec', '4c55a4e487c411ebb1145405db8174c1', '3e605229942011ebbb42b46bfc36a0ec');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `enable_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '激活邮箱',
  `enable` tinyint(1) NOT NULL COMMENT '是否激活',
  `locked` tinyint(1) NOT NULL COMMENT '是否锁定',
  `expire` tinyint(1) NOT NULL COMMENT '是否过期',
  `create_time` datetime(0) NOT NULL COMMENT '创建日期',
  PRIMARY KEY (`id`, `username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('03190b0078305f2db954290c20a7f2ac', 'admin', 'AC45f/IXdwiweyhdUIkpCutyBezqRNYXukF7WkMS9Ys=', '154245455@qq.com', 0, 0, 0, '2021-06-26 16:09:20');
INSERT INTO `user` VALUES ('13692491951b7b9672b93c1fbbc2b055', 'artell', 'ooHM1S2xsijLdhphJ1/5h/DSWI3K1wKxoE8YhfExj98=', '1qqq@qq.com', 0, 0, 0, '2021-08-17 17:03:01');
INSERT INTO `user` VALUES ('1c761bbbb2c16476dfd8d7ca21269696', 'artell2', 'w9tgY+KWp92mXfVxmVOLHJxIhdElPEDvEt4ZjuHdnio=', '850074298@qq.com', 1, 0, 0, '2021-08-17 17:03:20');
INSERT INTO `user` VALUES ('3318db7fc44bc23ccd59d1020ef9ce57', 'coolgai', '6h2d8gBe1jjNHrBuAP6fakP5+3sVApTJTitEtI7TJAA=', '616223916@qq.com', 1, 0, 0, '2021-05-03 13:19:50');
INSERT INTO `user` VALUES ('38d8205e006d397887fc12ef6467b53c', 'wxd095', 'ZxNIu1WMfoe64IFQIIYG1ZGrUX1gY2f7Vcl5EjhRI08=', 'wxdhld@139.com', 0, 0, 0, '2021-05-03 17:36:31');
INSERT INTO `user` VALUES ('6459a01b49aa888f54f318d8c21b34bc', 'qq11', '4Kib88TJ97dNNXErzh/Zn9Y7khQcY8IWKAsWbHGWlFQ=', '200982821@qq.com', 1, 0, 0, '2021-09-03 13:53:57');
INSERT INTO `user` VALUES ('694096fb765810086d2f63e9fafe41e0', 'admin123', '1mjlcx568we5K/74mP36Gk1zgY/AlPNdaqcMJDprUHw=', 'admin123@admin.com', 0, 0, 0, '2021-06-21 15:38:58');
INSERT INTO `user` VALUES ('96a43e4d666c9c2ebc803a34bc517c82', 'zhaoxiaochun', 'nxvIXJVeEE9fZzdddwuQSVvFKbvs097nLe66EaqOJms=', '3305767231@qq.com', 1, 0, 0, '2021-04-28 22:08:17');
INSERT INTO `user` VALUES ('c6603e8d028c798e67c4620736e29dc1', 'huhailong', 'avj54Ph2jpuQe+lq8/YAnhSCA1WoBNVOjPtq5ZXPY34=', 'hhlworkspace@qq.com', 1, 0, 0, '2021-04-28 21:53:50');
INSERT INTO `user` VALUES ('cc6567fff892530a9d8388640fd1249f', 'qqqq', 'anC0Y/upUZrY7+hcT9+zqEDbWQmawnKhAbs6pAoK4u0=', '2484815585@qq.com', 0, 0, 0, '2021-09-03 13:49:55');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户信息主键',
  `avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://www.huhailong.vip/img/default.png' COMMENT '用户头像',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'ShiroByJWT' COMMENT '用户昵称',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '性别(0-未知；1-男；2-女)',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作',
  `birthday` date NULL DEFAULT NULL COMMENT '出生年月',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('0ad0dc36abf311ebb393b46bfc36a0ec', 'https://www.huhailong.vip/img/default.png', 'ShiroByJWT', '0', NULL, NULL, NULL, '38d8205e006d397887fc12ef6467b53c');
INSERT INTO `user_info` VALUES ('298e1634a82911ebb393b46bfc36a0ec', 'https://www.huhailong.vip/img/avatar/c6603e8d028c798e67c4620736e29dc1.jpg', '小胡', 'm', '12345678901', '程序猿', '1996-11-21', 'c6603e8d028c798e67c4620736e29dc1');
INSERT INTO `user_info` VALUES ('2e52a31ba82b11ebb393b46bfc36a0ec', 'https://www.huhailong.vip/img/avatar/96a43e4d666c9c2ebc803a34bc517c82.jpg', '小春', 'w', '12123412312', '护士', '2021-04-06', '96a43e4d666c9c2ebc803a34bc517c82');
INSERT INTO `user_info` VALUES ('2f3f0a60abcf11ebb393b46bfc36a0ec', 'https://www.huhailong.vip/img/default.png', 'ShiroByJWT', '0', NULL, NULL, NULL, '3318db7fc44bc23ccd59d1020ef9ce57');
INSERT INTO `user_info` VALUES ('53f0de6f0c7b11ecb393b46bfc36a0ec', 'https://www.huhailong.vip/img/avatar/6459a01b49aa888f54f318d8c21b34bc.jpg', 'ShiroByJWT', '0', NULL, NULL, NULL, '6459a01b49aa888f54f318d8c21b34bc');
INSERT INTO `user_info` VALUES ('bd237062d26311ebb393b46bfc36a0ec', 'https://www.huhailong.vip/img/default.png', 'ShiroByJWT', '0', NULL, NULL, NULL, '694096fb765810086d2f63e9fafe41e0');
INSERT INTO `user_info` VALUES ('c3e48bf70c7a11ecb393b46bfc36a0ec', 'https://www.huhailong.vip/img/default.png', 'ShiroByJWT', '0', NULL, NULL, NULL, 'cc6567fff892530a9d8388640fd1249f');
INSERT INTO `user_info` VALUES ('cf775311d65511ebb393b46bfc36a0ec', 'https://www.huhailong.vip/img/default.png', 'ShiroByJWT', '0', NULL, NULL, NULL, '03190b0078305f2db954290c20a7f2ac');
INSERT INTO `user_info` VALUES ('ecee81d4ff3911ebb393b46bfc36a0ec', 'https://www.huhailong.vip/img/default.png', 'ShiroByJWT', '0', NULL, NULL, NULL, '13692491951b7b9672b93c1fbbc2b055');
INSERT INTO `user_info` VALUES ('f83e2ee6ff3911ebb393b46bfc36a0ec', 'https://www.huhailong.vip/img/default.png', 'ShiroByJWT', '0', NULL, NULL, NULL, '1c761bbbb2c16476dfd8d7ca21269696');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('0acfb95aabf311ebb393b46bfc36a0ec', '38d8205e006d397887fc12ef6467b53c', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('298dd28ca82911ebb393b46bfc36a0ec', 'c6603e8d028c798e67c4620736e29dc1', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('2e52720ea82b11ebb393b46bfc36a0ec', '96a43e4d666c9c2ebc803a34bc517c82', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('2f3ee1feabcf11ebb393b46bfc36a0ec', '3318db7fc44bc23ccd59d1020ef9ce57', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('53f0692b0c7b11ecb393b46bfc36a0ec', '6459a01b49aa888f54f318d8c21b34bc', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('afbf2071a82b11ebb393b46bfc36a0ec', '96a43e4d666c9c2ebc803a34bc517c82', 'c49540b287c211ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('bd234564d26311ebb393b46bfc36a0ec', '694096fb765810086d2f63e9fafe41e0', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('c3e390790c7a11ecb393b46bfc36a0ec', 'cc6567fff892530a9d8388640fd1249f', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('c60c5185a82a11ebb393b46bfc36a0ec', 'c6603e8d028c798e67c4620736e29dc1', 'c49540b287c211ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('cf7729ebd65511ebb393b46bfc36a0ec', '03190b0078305f2db954290c20a7f2ac', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('ecedde19ff3911ebb393b46bfc36a0ec', '13692491951b7b9672b93c1fbbc2b055', '4c55a4e487c411ebb1145405db8174c1');
INSERT INTO `user_role` VALUES ('f83da62fff3911ebb393b46bfc36a0ec', '1c761bbbb2c16476dfd8d7ca21269696', '4c55a4e487c411ebb1145405db8174c1');

SET FOREIGN_KEY_CHECKS = 1;
