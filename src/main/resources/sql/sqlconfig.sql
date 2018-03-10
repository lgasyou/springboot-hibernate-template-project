# 预置角色
INSERT INTO `system_role`(`id`,`name`) VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

# 预置用户
INSERT INTO `user`(`id`,`password`,`username`) VALUES (1,'root','root'),(2,'xenon','xenon');

# 预置用户角色
INSERT INTO `user_roles`(`user_id`,`roles_id`) VALUES (1,1),(2,2);
