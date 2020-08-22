package br.unigran.appveiculo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.unigran.domain.Carro;
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

            startActivityForResult(it,121);//inicia nova activity
    }
    public void editar(){

        Carro carro=null;
        Intent it = new Intent(MainActivity.this,CadastroVeiculo.class);//cria a intent
        it.putExtra("carro",carro);
        startActivityForResult(it,RESULT_OK);//inicia nova activity
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        atualizaListagem();//executa após fechar activity chamada pelo startActivityForResult
    }

    public void atualizaListagem(){
        //crio adapter passando contexto, layout e lista
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, CarroDao.getDados());
        listagemCarro.setAdapter(adapter);//envio para lista
    }

}