package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.db_tables.DealerTable;
import com.colombosoft.ednasalespad.db_tables.UserTable;
import com.colombosoft.ednasalespad.helper_model.UserLoginSuccess;
import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.User;

import java.util.List;

/**
 * Created by DragonSlayer on 11/11/2015.
 */
public class StoreUser {

    private static final String TAG = "StoreDealer";

    private UserTable baseUser;

    public void storeUserInDB(SQLiteDatabase databaseInstance ,UserLoginSuccess user){

        baseUser = new UserTable();
        baseUser.insertUser(databaseInstance,user);

    }
}
