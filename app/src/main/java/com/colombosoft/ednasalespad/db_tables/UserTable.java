package com.colombosoft.ednasalespad.db_tables;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.colombosoft.ednasalespad.helper_model.UserLoginSuccess;
import com.colombosoft.ednasalespad.model.Area;
import com.colombosoft.ednasalespad.model.User;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class UserTable {

    public static final String USER_TABLE_NAME = "tbl_user";

    public static final String USER_TABLE = "CREATE TABLE IF NOT EXISTS "
                                                    + "tbl_user" + " ("
                                                    + "UserToken" + "  varchar(500) primary key, "
                                                    + "Email" + " varchar(32) "
                                                    + ")";

    public SQLiteDatabase insertUser(SQLiteDatabase databaseInstance , UserLoginSuccess user){

        ContentValues userInsert = new ContentValues();

        userInsert.put("UserToken", user.getAccess_token());
        userInsert.put("Email", user.getUserName());
        databaseInstance.insert(USER_TABLE_NAME, null, userInsert);

        return databaseInstance;

    }
}
