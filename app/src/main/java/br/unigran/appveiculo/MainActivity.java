package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.unigran.domain.CarroDao;

public class MainActivity extends AppCompatActivity {

    private ListView listagemCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listagemCarro=findViewById(R.id.listagemCarro);
        atualizaListagem();
    }
    /**
     * recebe acao do botao Novo Veiculo
     * @param view
     */
    public void novoVeiculo(View view){
        //nova activity

            Intent it = new Intent(MainActivity.this,CadastroVeiculo.class);//cria a intent
            startActivity(it);//inicia nova activity
            atualizaListagem();

    }
    public void atualizaListagem(){
        //crio adapter passando contexto, layout e lista
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, CarroDao.getDados());
        listagemCarro.setAdapter(adapter);//envio para lista
    }

}