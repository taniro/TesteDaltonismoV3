package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int TESTE_HUM = 55;
    private static final int TESTE_DOIS = 56;
    private static final int TESTE_TRES = 57;

    String r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("AULA", "Invocou o metodo onSaveInstanceState");

        outState.putString("resposta1", r1);
        outState.putString("resposta2", r2);
        outState.putString("resposta3", r3);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("AULA", "Invocou o metodo onRestoreInstanceState");

        r1 = savedInstanceState.getString("resposta1");
        r2 = savedInstanceState.getString("resposta2");
        r3 = savedInstanceState.getString("resposta3");

        TextView tv1 = findViewById(R.id.resposta1);
        TextView tv2 = findViewById(R.id.resposta2);
        TextView tv3 = findViewById(R.id.resposta3);

        tv1.setText(r1);
        tv2.setText(r2);
        tv3.setText(r3);
    }

    public void metodoCliqueTesteHum(View v){

        Intent i = new Intent(this, TesteActivity.class);
        i.putExtra("teste", 1);

        startActivityForResult(i, TESTE_HUM);
    }

    public void metodoCliqueTesteDois(View v){

        Intent i = new Intent(this, TesteActivity.class);
        i.putExtra("teste", 2);

        startActivityForResult(i, TESTE_DOIS);
    }

    public void metodoCliqueTesteTres(View v){

        Intent i = new Intent(this, TesteActivity.class);
        i.putExtra("teste", 3);

        startActivityForResult(i, TESTE_TRES);
    }

    public void verificar(View v){
        TextView tv = findViewById(R.id.resultado_teste);

        if(r1 == null || r2 == null || r3 == null){
            Toast.makeText(this, "Responda os testes.", Toast.LENGTH_SHORT).show();
        }else if (r1.equals("2") && r2.equals("29") && r3.equals("74")){
            tv.setText("Tudo Ok!");
        }else{
            tv.setText("Procure o médico");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null || resultCode == RESULT_CANCELED){
            return;
        }

        switch (requestCode){
            case TESTE_HUM:{
                if (resultCode == RESULT_OK){
                    TextView tv = findViewById(R.id.resposta1);

                    String resposta = data.getStringExtra("resposta");
                    tv.setText(resposta);
                    r1 = resposta;
                    break;
                }
            }case TESTE_DOIS:{
                if (resultCode == RESULT_OK){
                    TextView tv = findViewById(R.id.resposta2);

                    String resposta = data.getStringExtra("resposta");
                    tv.setText(resposta);
                    r2 = resposta;
                    break;
                }
            }case TESTE_TRES:{
                if (resultCode == RESULT_OK){
                    TextView tv = findViewById(R.id.resposta3);

                    String resposta = data.getStringExtra("resposta");
                    tv.setText(resposta);
                    r3 = resposta;
                    break;
                }
            }
        }

    }
}
