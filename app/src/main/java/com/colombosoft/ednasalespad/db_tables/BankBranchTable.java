package com.colombosoft.ednasalespad.db_tables;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class BankBranchTable {

    public static final String BANK_BRANCH_TABLE_NAME = "tbl_bank_branch";

    public static final String BANK_BRANCH_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                            + "tbl_bank_branch" + " ("
                                                            + "BankBranchId" + " integer(32) primary key, "
                                                            + "Branch" + " varchar(32), "
                                                            + "BranchCode" + " varchar(32), "
                                                            + "BankId" + " integer(32), "
                                                            + "AddedDate" + " varchar(32), "
                                                            + "AddedBy" + " varchar(32), "
                                                            + "LastModified" + " varchar(32), "
                                                            + "LastModifiedBy" + " varchar(32) "
                                                            + ")";


}
