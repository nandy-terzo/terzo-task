use `Bank-transaction`;
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
                           `account_id` int(11) NOT NULL,
                           `transaction_type` varchar(128) DEFAULT NULL,
                           `transaction_amount` int(11) NOT NULL,
                           `transaction_date` date,
                           FOREIGN KEY (`account_id`) REFERENCES account(account_id) 
) ;

