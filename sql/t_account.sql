SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`  (
  `account_id` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `create_date` datetime NULL DEFAULT NULL,
  `create_from` int(11) NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `last_login_channel` int(11) NULL DEFAULT NULL,
  `last_login_date` datetime NULL DEFAULT NULL,
  `last_update_date` datetime NULL DEFAULT NULL,
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `mobile_ming` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `mobile_cipher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号加密列',
  `assisted_query_mobile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `mobile_like` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号模糊查询列',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `password_ming` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `password_cipher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码加密列',
  `assisted_query_pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码辅助查询列',
  `psw_ver` int(11) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '状态，0：正常；-1：删除；1：冻结;2待审核',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `org_id` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户所属ID',
  `user_level` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户类型ID',
  `reject_reason` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO `t_account` (`account_id`, `create_date`, `create_from`, `email`, `last_login_channel`, `last_login_date`, `last_update_date`, `mobile`, `mobile_ming`, `mobile_cipher`, `assisted_query_mobile`, `mobile_like`, `password`, `password_ming`, `password_cipher`, `assisted_query_pwd`, `psw_ver`, `status`, `username`, `org_id`, `user_level`, `reject_reason`) VALUES ('6603c2ddd61d1e265c22d01a', '2024-03-27 14:55:25', 1, NULL, NULL, NULL, '2024-03-27 14:55:25', '15982261241', NULL, 'EscHL2WaoXpOhBamEfetwA==', '0b87f55b52cf979d75fd9b478a9469c5', '04891150150', '$2a$12$3NhwP6jr68d86usUHrCFA.6TD4c6OhLlCwAw8XfoX8YLv6NIwXRyW', NULL, 'BkSxofqgjdqw0N0jCHZxIZ8HbiZ2QVvsdfSEEO1lSWEFt03g+oBk+ugbSJV1cCo2SVEcEStpBWuWzrqjhK6dGw==', 'de92360c874373caedd96b110e9b8a0f', NULL, 0, '15982261241', '145', '123122', NULL);
INSERT INTO `t_account` (`account_id`, `create_date`, `create_from`, `email`, `last_login_channel`, `last_login_date`, `last_update_date`, `mobile`, `mobile_ming`, `mobile_cipher`, `assisted_query_mobile`, `mobile_like`, `password`, `password_ming`, `password_cipher`, `assisted_query_pwd`, `psw_ver`, `status`, `username`, `org_id`, `user_level`, `reject_reason`) VALUES ('6603c570d61d1e13dce11a83', '2024-03-27 15:06:25', 1, NULL, NULL, NULL, '2024-03-27 15:06:25', '15982261244', NULL, '+cb2CUFWreXtErKRd9VHIg==', '8f553aa9b1f30160921410cea8ae36a7', '04891150155', '$2a$12$/JuKbK/p8rBPSf1Brhks3.u//be7xHOi.VcKG8EzBndMZ07zmxZqe', NULL, 'QJUMUUTkiiBoSq5E08L8qMgFUzC17sQ2EnT6Y9nWNrgOdjdFUqdyDcdYAXEGObTcazS3p7r9VbVkdLq2opHfbg==', '49b0000b5d932ef4ea9b5fafa2b360a8', NULL, 0, '15982261244', '145', '123122', NULL);
