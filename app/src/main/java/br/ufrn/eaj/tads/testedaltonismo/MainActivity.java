package br.ufrn.eaj.tads.testedaltonismo;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int TESTE_HUM = 55;
    private static final int TESTE_DOIS = 56;
    private static final int TESTE_TRES = 57;

    public static class MyViewModel extends ViewModel{
        private String r1, r2, r3;
    }

    MyViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        TextView tv1 = findViewById(R.id.resposta1);
        TextView tv2 = findViewById(R.id.resposta2);
        TextView tv3 = findViewById(R.id.resposta3);

        tv1.setText(mViewModel.r1);
        tv2.setText(mViewModel.r2);
        tv3.setText(mViewModel.r3);
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



        if( mViewModel.r1 == null || mViewModel.r2 == null || mViewModel.r3 == null){
            Toast.makeText(this, "Responda os testes.", Toast.LENGTH_SHORT).show();
        }else if (mViewModel.r1.equals("2") && mViewModel.r2.equals("29") && mViewModel.r3.equals("74")){
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
                    mViewModel.r1 = resposta;
                    break;
                }
            }case TESTE_DOIS:{
                if (resultCode == RESULT_OK){
                    TextView tv = findViewById(R.id.resposta2);

                    String resposta = data.getStringExtra("resposta");
                    tv.setText(resposta);
                    mViewModel.r2 = resposta;
                    break;
                }
            }case TESTE_TRES:{
                if (resultCode == RESULT_OK){
                    TextView tv = findViewById(R.id.resposta3);

                    String resposta = data.getStringExtra("resposta");
                    tv.setText(resposta);
                    mViewModel.r3 = resposta;
                    break;
                }
            }
        }

    }
}
