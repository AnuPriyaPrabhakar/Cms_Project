package com.ponsun.cms.master.Bank.data;

import lombok.Data;

@Data
public class BankData {
    private Integer id;
    private String bankName;


    public BankData(final Integer id, final String bankName) {

        this.id = id;
        this.bankName = bankName;
    }

    public static BankData newInstance(final Integer id, final String bankName) {
        return new BankData(id, bankName);
    }
}
