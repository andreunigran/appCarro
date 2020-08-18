package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * recebe acao do botao Novo Veiculo
     * @param view
     */
    public void novoVeiculo(View view){
        //nova activity
        Intent it = new Intent(MainActivity.this,CadastroVeiculo.class);//cria a intent
        startActivity(it);//inicia nova activity
    }
}