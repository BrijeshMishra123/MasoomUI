package qutub.osahub.com.masoomui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="register_helper";
    public String CREATE_LOGIN_TABLE_QUERY=" CREATE TABLE LOGIN_DETAILS ( USERNAME VARCHAR PRIMARY KEY,PASSWORD VARCHAR,EMAIL VARCHAR,MOBILE VRCHAR) ";
    UserDatabasePOJO pojo=new UserDatabasePOJO();
    public Database(Context con)
    {
        super(con, DATABASE_NAME, null, 1);
    }

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }
    public void onCreate(SQLiteDatabase db) {

        // db=SQLiteDatabase.openOrCreateDatabase();
        db.execSQL(CREATE_LOGIN_TABLE_QUERY);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void saveLoginInfo(Database dbHelper,String name,String password,String email,String mobile)
    {
        SQLiteDatabase sq=dbHelper.getWritableDatabase();
        //  sq.execSQL("insert into LOGIN_DETAILS('qutub','ansari')");
        ContentValues cv=new ContentValues();
        cv.put("USERNAME", name);
        cv.put("PASSWORD",password);
        cv.put("EMAIL",email);
        cv.put("MOBILE",mobile);

        sq.insert("LOGIN_DETAILS",null,cv);
    }


    public List<UserDatabasePOJO> getLoginInfo(Database db,String name)
    {
       List<UserDatabasePOJO> list1= new ArrayList<UserDatabasePOJO>();
        SQLiteDatabase sq=db.getReadableDatabase();
        String columns[]={"USERNAME","PASSWORD","EMAIL","MOBILE"};
        String selArg[]={name};
        Cursor cs= sq.query("LOGIN_DETAILS",columns,"EMAIL=?",selArg,null,null,null,null);
        while(!cs.isLast())
        {
            cs.moveToNext();
            pojo.setName(cs.getString(0));
            pojo.setPassword(cs.getString(1));
            pojo.setEmail(cs.getString(2));
            pojo.setMobile(cs.getString(3));
           list1.add(pojo);

        }


        return list1;

    }

}
