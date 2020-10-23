DROP TABLE IF EXISTS `documents`;
CREATE TABLE `documents`  (
  `id` INT AUTO_INCREMENT PRIMARY KEY ,
  `creation_date` DATE NOT NULL,
  `status` varchar NOT NULL,
  `author` varchar NOT NULL,
  `file` varchar
);

INSERT INTO documents(creation_date, status, author, file) VALUES ('2020-09-30', 'deprecated', 'ivan', 'ivan.txt');
INSERT INTO documents(creation_date, status, author, file) VALUES ('2020-06-03', 'new', 'sasha', 'sasha.txt');
INSERT INTO documents(creation_date, status, author, file) VALUES ('2020-10-03', 'need to fix', 'petya', 'petya.txt');
INSERT INTO documents(creation_date, status, author, file) VALUES ('2019-02-05', 'need to fix', 'zhora', 'zhora.txt');
INSERT INTO documents(creation_date, status, author, file) VALUES ('2018-12-15', 'new', 'valera', 'valera.txt');
INSERT INTO documents(creation_date, status, author, file) VALUES ('2019-12-04', 'deprecated', 'kolya', 'kolya.txt');





INSERT INTO t_user(username, password) VALUES ('admin','admin');
INSERT INTO t_user(username, password) VALUES ('user', 'user');


INSERT INTO t_role(name) VALUES ('ADMIN');
INSERT INTO t_role(name) VALUES ('USER');


INSERT INTO t_user_roles(user_id, role_id)  VALUES (1, 1);
INSERT INTO t_user_roles(user_id, role_id)  VALUES (2, 2);