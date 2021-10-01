# terzo-task

INITIAL TASK:               (27/09/2021)
  NANDHAKUMAR - create account database
  SUDARSHAN   - create transaction database

 NANDHAKUMAR - crud in Account db
  SUDARSHAN   - withdraw, deposit operation account db.
  
 
  NANDHAKUMAR - Exception handling
  SUDARSHAN   - Transaction db query
 
Test cases:-

1.particular account  get  http://localhost:8081/bank/account/1

2.all account  get    http://localhost:8081/bank/account/all

3.update        http://localhost:8081/bank/account/1
  
  {
    "accountHolderName": "Emma",
    "currentBalance": "700"
}

4.delete        http://localhost:8081/bank/account/2

5.create account

post  http://localhost:8081/bank/account/
      {
    "accountHolderName": "ananya",
    "currentBalance": "300"
      }
      
6.Deposit  put http://localhost:8081/bank/deposit/1/300

7.WithDraw  put  http://localhost:8081/bank/withdraw/1/100
