package com.example.onlinelibrary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseUser extends SQLiteOpenHelper {

    Context context;

    public DataBaseUser(Context context) {
        super(context, "userdb.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table users ( name Text primary key, password Text , email Text  , counter Text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }



    public boolean insertToDb(UserAccount userAccount) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            db.execSQL("insert into users values(\"" + userAccount.getName() + "\" , \"" + userAccount.getPassword() + "\" , \"" + userAccount.getEmail() + "\" , \"" + userAccount.getCounter() + "\")");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void deleteFromDb(UserAccount userAccount) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from users where name=\"" + userAccount.getName() + "\"  ");
    }

    public boolean updateNameDb(String name_old, String name_new) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL("update users set name=\"" + name_new + "\" where name=\"" + name_old + "\" ");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void updatePasswordDb(String name_user, String password_new) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("update users set password=\"" + password_new + "\" where name=\"" + name_user + "\" ");
    }

    private boolean checkSameEmail(String name_user,String email_new) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                if (cursor.getString(cursor.getColumnIndex("name")).equals(name_user)) {
                    if (cursor.getString(cursor.getColumnIndex("email")).equals(email_new)) {
                        return false;
                    }
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return true;
    }

    public boolean updateEmailDb(String name_user, String email_new) {
        if (checkSameEmail(name_user, email_new)) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("update users set email=\"" + email_new + "\" where name=\"" + name_user + "\" ");
            return true;
        }
        return false;
    }

    public String checkUserFromDb(String name_sent) {

        String result = "";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from users", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                if (cursor.getString(cursor.getColumnIndex("name")).equals(name_sent)) {
                    result = cursor.getString(cursor.getColumnIndex("password"));
                    return result;
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return result;
    }



}
