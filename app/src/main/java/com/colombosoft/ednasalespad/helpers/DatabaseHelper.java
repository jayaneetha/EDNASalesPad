package com.colombosoft.ednasalespad.helpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.colombosoft.ednasalespad.db_tables.AgentTable;
import com.colombosoft.ednasalespad.db_tables.AreaTable;
import com.colombosoft.ednasalespad.db_tables.AttendanceTable;
import com.colombosoft.ednasalespad.db_tables.BankBranchTable;
import com.colombosoft.ednasalespad.db_tables.BankTable;
import com.colombosoft.ednasalespad.db_tables.DealerClassTable;
import com.colombosoft.ednasalespad.db_tables.DealerImageTable;
import com.colombosoft.ednasalespad.db_tables.DealerTable;
import com.colombosoft.ednasalespad.db_tables.ProductBatchTable;
import com.colombosoft.ednasalespad.db_tables.ProductBrandTable;
import com.colombosoft.ednasalespad.db_tables.ProductCategoryTable;
import com.colombosoft.ednasalespad.db_tables.ProductLevelTable;
import com.colombosoft.ednasalespad.db_tables.ProductTable;
import com.colombosoft.ednasalespad.db_tables.ProductUnitTable;
import com.colombosoft.ednasalespad.db_tables.RegionTable;
import com.colombosoft.ednasalespad.db_tables.RouteTable;
import com.colombosoft.ednasalespad.db_tables.TeritoryTable;
import com.colombosoft.ednasalespad.db_tables.UserTable;
import com.colombosoft.ednasalespad.model.Dealer;
import com.colombosoft.ednasalespad.model.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DragonSlayer on 11/5/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper databaseHelper;
    //private static SQLiteDatabase sqLiteDatabase;

    private static final String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "edna_sales_pad_db";

    private DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    public static synchronized DatabaseHelper getInstance( Context context){

        if(databaseHelper == null) {
            return new DatabaseHelper(context);
        }
        return databaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(AgentTable.AGENT_TABLE);
        db.execSQL(AreaTable.AREA_TABLE);
        db.execSQL(BankBranchTable.BANK_BRANCH_TABLE);
        db.execSQL(BankTable.BANK_TABLE);
        db.execSQL(DealerClassTable.DEALER_CLASS_TABLE);
        db.execSQL(DealerImageTable.DEALER_IMAGE_TABLE);
        db.execSQL(DealerTable.DEALER_TABLE);
        db.execSQL(ProductBatchTable.PRODUCT_BATCH_TABLE);
        db.execSQL(ProductBrandTable.PRODUCT_BRAND_TABLE);
        db.execSQL(ProductCategoryTable.PRODUCT_CATEGORY_TABLE);
        db.execSQL(ProductLevelTable.PRODUCT_LEVEL_TABLE);
        db.execSQL(ProductTable.PRODUCT_TABLE);
        db.execSQL(ProductUnitTable.PRODUCT_UNIT_TABLE);
        db.execSQL(RegionTable.REGION_TABLE);
        db.execSQL(RouteTable.ROUTE_TABLE);
        db.execSQL(TeritoryTable.TERITORY_TABLE);
        db.execSQL(UserTable.USER_TABLE);
        db.execSQL(AttendanceTable.ATTENDANCE_TABLE);

        Log.d(TAG,"********************* DatabaseHelper.onCreate() method end *************************");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        clearAllTables();
        Log.d(TAG, "********************* DatabaseHelper.onUpgrade() method will start *************************");
        onCreate(db);

    }

    public void clearAllTables(){

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("drop table if exists "+AgentTable.AGENT_TABLE_NAME);
        db.execSQL("drop table if exists "+AreaTable.AREA_TABLE_NAME);
        db.execSQL("drop table if exists "+BankBranchTable.BANK_BRANCH_TABLE_NAME);
        db.execSQL("drop table if exists "+BankTable.BANK_TABLE_NAME);
        db.execSQL("drop table if exists "+DealerClassTable.DEALER_CLASS_TABLE_NAME);
        db.execSQL("drop table if exists "+DealerImageTable.DEALER_IMAGE_TABLE_NAME);
        db.execSQL("drop table if exists "+DealerTable.DEALER_TABLE_NAME);
        db.execSQL("drop table if exists "+ProductBatchTable.PRODUCT_BATCH_TABLE_NAME);
        db.execSQL("drop table if exists "+ProductBrandTable.PRODUCT_BRAND_TABLE_NAME);
        db.execSQL("drop table if exists "+ProductCategoryTable.PRODUCT_CATEGORY_TABLE_NAME);
        db.execSQL("drop table if exists "+ProductLevelTable.PRODUCT_LEVEL_TABLE_NAME);
        db.execSQL("drop table if exists "+ProductTable.PRODUCT_TABLE_NAME);
        db.execSQL("drop table if exists "+ProductUnitTable.PRODUCT_UNIT_TABLE_NAME);
        db.execSQL("drop table if exists "+RegionTable.REGION_TABLE_NAME);
        db.execSQL("drop table if exists "+RouteTable.ROUTE_TABLE_NAME);
        db.execSQL("drop table if exists "+TeritoryTable.TERITORY_TABLE_NAME);
        db.execSQL("drop table if exists "+UserTable.USER_TABLE_NAME);
        db.execSQL("drop table if exists "+AttendanceTable.ATTENDANCE_TABLE_NAME);

        Log.d(TAG, "****************** DatabaseHelper.clearAllTables() method end ************************");

    }

    public List<Route> getAllRoutes(){

        SQLiteDatabase db = this.getReadableDatabase();
        String selectAllRoutes = "SELECT RouteId,RouteName FROM tbl_route;";

        List<Route> routes = new ArrayList<Route>();
        Cursor routeCursor = db.rawQuery(selectAllRoutes, null);

        if (routeCursor.moveToFirst()) {
            do {
                Route simpleRoute = new Route();
                simpleRoute.setRouteId(routeCursor.getInt(0));
                simpleRoute.setRouteName(routeCursor.getString(1));
                routes.add(simpleRoute);

            } while (routeCursor.moveToNext());

        }

        db.close();
        return routes;
    }


    public List<Dealer> getAllDealers(){

        SQLiteDatabase db = this.getWritableDatabase();
        String selectAllDealers = "SELECT DealerId,RouteId,ContactPerson FROM tbl_dealer";

        List<Dealer> dealers = new ArrayList<Dealer>();
        Cursor dealerCursor = db.rawQuery(selectAllDealers,null);

        if (dealerCursor.moveToFirst()){
            do{
                Dealer dealer = new Dealer();
                dealer.setDealerId(dealerCursor.getString(0));
                dealer.setRouteId(dealerCursor.getInt(1));
                dealers.add(dealer);
            }while (dealerCursor.moveToNext());
        }

        return dealers;
    }


}
