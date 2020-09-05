package br.unigran.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDados extends SQLiteOpenHelper {


    public BancoDados(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public BancoDados(@Nullable Context context) {
        super(context, "bancoVeiculo", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        StringBuilder stringBuilder = new StringBuilder();
//
//        stringBuilder.append("CREATE TABLE  VEICULO ( " +
//                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
//                " NOME VARCHAR(50) NOT NULL," +
//                "PLACA VARCHAR(8)," +
//                "ANO INTEGER " +
//                ")");
//        sqLiteDatabase.execSQL(stringBuilder.toString());

        sqLiteDatabase.execSQL("CREATE TABLE  VEICULO ( " +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " NOME VARCHAR(50) NOT NULL," +
                "PLACA VARCHAR(8)," +
                "ANO INTEGER " +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
