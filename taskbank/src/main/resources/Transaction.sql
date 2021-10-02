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

INSERT INTO `transaction` VALUES
                                (1, 1, 'Deposit', 300, '2021-01-10'),
                                (2, 1, 'Withdraw', 100, '2021-02-10'),
                                (3, 1, 'Deposit', 200, '2021-03-10'),
                                (4, 2, 'Deposit', 200, '2021-01-10'),
                                (5, 2, 'Withdraw', 100, '2021-01-10'),
                                (6, 2, 'Withdraw', 200, '2021-03-10');