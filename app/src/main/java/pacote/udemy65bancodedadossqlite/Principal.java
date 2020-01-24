package pacote.udemy65bancodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

    try {

        //Criar banco de dados
        SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

        //Criar tabela
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

        //Inserir dados
        /*bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Denis', 19)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Cecilia', 21)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Vicente', 20)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Rivka', 23)");*/

        //Recuperar pessoas
        Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);

        //Indices da tabela
        int indiceNome = cursor.getColumnIndex("nome");
        int indiceIdade = cursor.getColumnIndex("idade");

        cursor.moveToFirst();
        while (cursor != null) {
            Log.i("RESULTADO - nome: ", cursor.getString(indiceNome));
            Log.i("RESULTADO - idade: ", cursor.getString(indiceIdade));
            cursor.moveToNext();
        }
    }
     catch(Exception e) {
        e.printStackTrace();
    }

    }
     //ver em Logcat -> Info -> RESULTADO
}
