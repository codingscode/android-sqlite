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
        /*bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Raul', 25)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Lucia', 20)");*/


        //Recuperar pessoas
           //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Vicente'";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE idade >= 21";
        String consulta = "SELECT nome, idade FROM pessoas WHERE idade IN(21,23)";
        Cursor cursor = bancoDados.rawQuery( consulta, null);

        //Indices da tabela
        int indiceNome = cursor.getColumnIndex("nome");
        int indiceIdade = cursor.getColumnIndex("idade");

        cursor.moveToFirst();
        while (cursor != null) {

            String nome = cursor.getString(indiceNome);
            String idade = cursor.getString(indiceIdade);

            Log.i("RESULTADO - nome: ", nome + " idade: " + idade);
            cursor.moveToNext();
        }
    }
     catch(Exception e) {
        e.printStackTrace();
    }

    }
     //ver em Logcat -> Info -> RESULTADO
}
