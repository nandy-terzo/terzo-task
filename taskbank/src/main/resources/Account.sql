DROP SCHEMA IF EXISTS `Bank-transaction`;
CREATE SCHEMA `Bank-transaction`;
use `Bank-transaction`;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
                           `account_id` int(11) NOT NULL AUTO_INCREMENT,
                           `account_holder_name` varchar(128) DEFAULT NULL,
                           `current_balance` int(45) DEFAULT NULL,
                           PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
INSERT INTO `account` VALUES
                          (1,'Leslie',200),
                          (2,'Emma',300),
                          (3,'Avani',400),
                          (4,'Yuri',500),
                          (5,'Juan',600),
                          (6,'Lisa',700),
                          (7,'John',800),
                          (8,'Jane',900),
                          (9,'Patrick',100),
                          (10,'Peter',200);