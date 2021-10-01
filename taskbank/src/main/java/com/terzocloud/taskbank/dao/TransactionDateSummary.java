package com.terzocloud.taskbank.dao;

import com.terzocloud.taskbank.entity.Transaction;

import java.util.List;

public class TransactionDateSummary {


        private int totalTransactions=0;
        private int totalwithdrawnAmt=0;
        private int totalDepositedAmt=0;

        public  TransactionDateSummary(int totalTransactions, int totalwithdrawnAmt, int totalDepositedAmt)
        {
            this.totalDepositedAmt=totalDepositedAmt;
            this.totalTransactions=totalTransactions;
            this.totalwithdrawnAmt=totalwithdrawnAmt;
        }

        public int getTotalTransactions() {
            return totalTransactions;
        }

        public int getTotalwithdrawnAmt() {
            return totalwithdrawnAmt;
        }

        public int getTotalDepositedAmt() {
            return totalDepositedAmt;
        }


}
