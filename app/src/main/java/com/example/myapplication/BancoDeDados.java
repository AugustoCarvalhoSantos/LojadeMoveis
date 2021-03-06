package com.example.myapplication;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import androidx.annotation.Nullable;

        import java.util.ArrayList;
        import java.util.List;

public class BancoDados extends SQLiteOpenHelper {
    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CLIENTE = "bd_clientes";

    private static final String TABELA_MOVEL = "tb_clientes";

    private static final String COLUNA_TIPOS = "tipo";
    private static final String COLUNA_MEDIDAS = "medida";
    private static final String COLUNA_PRECO = "preco";
    private static final String COLUNA_COR = "cor";
    private static final String COLUNA_MATERIAL = "material";
    private static final String COLUNA_COD = "cod";

    public BancoDados(@Nullable Context context) {
        super(context, BANCO_CLIENTE, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_COLUNA = "CREATE TABLE " + TABELA_MOVEL + "("
                + COLUNA_COD + " INTEGER PRIMARY KEY, " + COLUNA_TIPOS + " TEXT, " +
                COLUNA_MEDIDAS + " TEXT, " + COLUNA_COR + " TEXT, " +
                COLUNA_MATERIAL + " TEXT, " + COLUNA_PRECO + " TEXT)";

        db.execSQL(QUERY_COLUNA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*CRUD*/

    void addMovel(Movel movel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUNA_COD, movel.getCod());
        values.put(COLUNA_TIPOS, movel.getTipo());
        values.put(COLUNA_MEDIDAS, movel.getMedida());
        values.put(COLUNA_COR, movel.getCor());
        values.put(COLUNA_MATERIAL, movel.getMaterial());
        values.put(COLUNA_PRECO, movel.getPreco());

        db.insert(TABELA_MOVEL,  null, values);
        db.close();
    }
}
