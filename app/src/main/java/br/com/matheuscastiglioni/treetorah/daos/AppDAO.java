package br.com.matheuscastiglioni.treetorah.daos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class AppDAO extends SQLiteOpenHelper {

    private final static String DB_NAME = "tree_torah";
    private final static int DB_VERSION = 1;
    protected final Context context;

    public AppDAO(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ReforestationDAO.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "";
        sqLiteDatabase.close();
    }

}