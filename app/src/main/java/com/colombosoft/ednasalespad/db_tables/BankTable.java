package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */

public class BankTable {

    public static final String BANK_TABLE_NAME = "tbl_bank";

    public static final String BANK_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                        + "tbl_bank" + " ("
                                                        + "BankId" + " integer(32) primary key, "
                                                        + "BankName" + " varchar(32), "
                                                        + "Address" + " varchar(32), "
                                                        + "BankCode" + " varchar(32), "
                                                        + "AddedDate" + " varchar(32), "
                                                        + "AddedBy" + " varchar(32), "
                                                        + "LastModified" + " varchar(32), "
                                                        + "LastModifiedBy" + " varchar(32) "
                                                        + ")";

}
