use `Bank-transaction`;
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
                               `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
                               `account_id` int(11) NOT NULL,
                               `transaction_type` varchar(128) DEFAULT NULL,
                               `transaction_amount` int(11) NOT NULL,
                               `transaction_date` varchar(128) DEFAULT NULL,
                               FOREIGN KEY (`account_id`) REFERENCES account(account_id) ,
                               PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;