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
        //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");
        //bancoDados.execSQL("UPDATE pessoas SET idade = 30 WHERE nome = 'Valeria'");
        //bancoDados.execSQL("UPDATE pessoas SET idade = 30, nome = 'Luana' WHERE nome = 'Valeria'");
        //bancoDados.execSQL("DROP TABLE pessoas");
        bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas2 (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");


        //Inserir dados
        /*bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Raul', 25)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Lucia', 20)");*/
        /*bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mariana', 25)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Marilia', 20)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mario', 20)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Valeria', 36)");
        bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Aladin', 32)");*/

        bancoDados.execSQL("INSERT INTO pessoas2(nome, idade) VALUES('Cesar', 18)");
        bancoDados.execSQL("INSERT INTO pessoas2(nome, idade) VALUES('Albert', 19)");
        bancoDados.execSQL("INSERT INTO pessoas2(nome, idade) VALUES('Alberto', 20)");
        bancoDados.execSQL("INSERT INTO pessoas2(nome, idade) VALUES('Celso', 21)");
        bancoDados.execSQL("INSERT INTO pessoas2(nome, idade) VALUES('Vladimir', 22)");
        bancoDados.execSQL("INSERT INTO pessoas2(nome, idade) VALUES('Daniel', 23)");
        bancoDados.execSQL("INSERT INTO pessoas2(nome, idade) VALUES('Luiza', 24)");
        bancoDados.execSQL("INSERT INTO pessoas2(nome, idade) VALUES('Isadora', 25)");

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
           //String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY nome DESC LIMIT 3";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Valeria'";
           //String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Luana'";
        String consulta = "SELECT * FROM pessoas2";
        Cursor cursor = bancoDados.rawQuery( consulta, null);

        //Indices da tabela
        int indiceId = cursor.getColumnIndex("id");
        int indiceNome = cursor.getColumnIndex("nome");
        int indiceIdade = cursor.getColumnIndex("idade");

        cursor.moveToFirst();
        while (cursor != null) {

            String nome = cursor.getString(indiceNome);
            String idade = cursor.getString(indiceIdade);
            String id = cursor.getString(indiceId);

            Log.i("RESULTADO - id: ", id + " nome: " + nome + " idade: " + idade);
            cursor.moveToNext();
        }
    }
     catch(Exception e) {
        e.printStackTrace();
    }

    }
     //ver em Logcat -> Info -> RESULTADO
}
