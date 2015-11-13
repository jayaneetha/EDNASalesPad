package com.colombosoft.ednasalespad.db_transaction;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.colombosoft.ednasalespad.db_tables.DealerTable;
import com.colombosoft.ednasalespad.model.Dealer;

import java.util.List;

/**
 * Created by DragonSlayer on 11/7/2015.
 */
public class StoreDealer {

    private static final String TAG = "StoreDealer";

    private DealerTable baseDealer;

    public SQLiteDatabase storeDealerListInDB(SQLiteDatabase databaseInstance ,List<Dealer> dealers){

        baseDealer = new DealerTable();

        for(Dealer dealer : dealers){

            baseDealer.insertDealer(databaseInstance,dealer);
        }

        Log.d(TAG, "**************** successfully added dealers *****************");
        return databaseInstance;
    }

}
