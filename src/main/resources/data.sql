DROP TABLE IF EXISTS `documents`;
CREATE TABLE `documents`  (
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `creation_date` datetime(0) NOT NULL,
  `status` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `file` varchar(255) NOT NULL
);

INSERT INTO `documents` VALUES (1, '2020-09-30', 'deprecated', 'ivan', 'ivan.txt');
INSERT INTO `documents` VALUES (2, '2020-06-03', 'new', 'sasha', 'sasha.txt');
INSERT INTO `documents` VALUES (3, '2020-10-03', 'need to fix', 'petya', 'petya.txt');
INSERT INTO `documents` VALUES (4, '2019-02-05', 'need to fix', 'zhora', 'zhora.txt');
INSERT INTO `documents` VALUES (5, '2018-12-15', 'new', 'valera', 'valera.txt');