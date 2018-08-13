package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TesteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        try {
            int teste_id = getIntent().getIntExtra("teste", 0);

            ImageView iv = findViewById(R.id.imageView);

            switch (teste_id){
                case 1:{
                    iv.setImageResource(R.drawable.teste1);
                    break;
                }case 2:{
                    iv.setImageResource(R.drawable.teste2);
                    break;
                }case 3:{
                    iv.setImageResource(R.drawable.teste3);
                    break;
                }
            }

        }catch (NullPointerException e){
            Toast.makeText(this, "Erro.", Toast.LENGTH_SHORT).show();
        }

    }

    public void cliqueOk(View v){

        EditText et = findViewById(R.id.editText);


        if (!et.getText().toString().isEmpty()){

            String resposta = et.getText().toString();

            Intent i = new Intent();
            i.putExtra("resposta", resposta);

            setResult(RESULT_OK, i);

            finish();

        }else{
            Toast.makeText(this, "Preecha um valor.", Toast.LENGTH_SHORT).show();
        }
    }

    public void cliqueCancel(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}
