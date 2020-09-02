package br.com.matheuscastiglioni.treetorah.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.matheuscastiglioni.treetorah.models.Reforestation;

public class ReforestationDAO extends AppDAO {

    public ReforestationDAO(Context context) {
        super(context);
    }

    public static String createTable() {
        StringBuilder sql = new StringBuilder();
        sql.append("create table reforestations(");
        sql.append("id char(36) not null,");
        sql.append("year integer not null,");
        sql.append("state char(2) not null,");
        sql.append("trees_cutted integer not null,");
        sql.append("volume integer not null,");
        sql.append("constraint pkreforestations primary key(id)");
        sql.append(");");
        return sql.toString();
    }

    public List<Reforestation> getAll() {
        List<Reforestation> reforestations = new ArrayList<Reforestation>();
        String sql = "select * from reforestations";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            reforestations.add(new Reforestation(
                    cursor.getInt(cursor.getColumnIndex("year")),
                    cursor.getString(cursor.getColumnIndex("state")),
                    cursor.getInt(cursor.getColumnIndex("trees_cutted")),
                    cursor.getInt(cursor.getColumnIndex("volume"))));
        }
        database.close();
        return reforestations;
    }

    public void save(Reforestation reforestation) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", UUID.randomUUID().toString());
        values.put("year", reforestation.getYear());
        values.put("state", reforestation.getState());
        values.put("trees_cutted", reforestation.getTreesCutted());
        values.put("volume", reforestation.getVolume());
        database.insert("reforestations", null, values);
        database.close();
    }

}