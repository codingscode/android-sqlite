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
        /*bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mariana', 25)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Marilia', 20)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mario', 20)");*/

        //Recuperar pessoas
           //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Vicente'";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE idade >= 21";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE idade IN(21,23)";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 21 AND 26";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE 'Cecilia'";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%cente'";
        String filtro = "mar";

           //String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%" + filtro + "%' ";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade ASC";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY nome ASC";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade DESC";
        String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY nome DESC LIMIT 3";
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
