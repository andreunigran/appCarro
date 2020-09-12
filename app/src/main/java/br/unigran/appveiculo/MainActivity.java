package br.unigran.appveiculo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.unigran.db.BancoDados;
import br.unigran.domain.dao.CarroDaoBanco;
import br.unigran.domain.entidade.Carro;
import br.unigran.domain.dao.CarroDao;

public class MainActivity extends AppCompatActivity {

    private ListView listagemCarro;
    private List <Carro>carros;
    private Integer indice;
    private final Integer OK_TELA_CADASTR0=201;
    private CarroDaoBanco carroDaoBanco ;
    private BancoDados bancoDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bancoDados= new BancoDados(this);



        setContentView(R.layout.activity_main);
        listagemCarro=findViewById(R.id.listagemCarro);
        atualizaListagem();


        listagemCarro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"valor "+i,Toast.LENGTH_LONG).show();

                Carro carro= (Carro) carros.get(i);

                Intent it = new Intent(MainActivity.this,CadastroVeiculo.class);//cria a intent
                it.putExtra("carro", carro);
                startActivityForResult(it,OK_TELA_CADASTR0);//inicia nova activity
            }
        });
        listagemCarro.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                                 @Override
                                                 public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                                                     carroDaoBanco.removeVeiculo( carros.get(i).getId());
                                                     atualizaListagem();
                                                     return false;
                                                 }
                                             }

                );

    }
    /**
     * recebe acao do botao Novo Veiculo
     * @param view
     */
    public void novoVeiculo(View view){
        //nova activity

            Intent it = new Intent(MainActivity.this,CadastroVeiculo.class);//cria a intent

            startActivityForResult(it,OK_TELA_CADASTR0);//inicia nova activity
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==OK_TELA_CADASTR0 && resultCode==RESULT_OK) {
            atualizaListagem();//executa após fechar activity chamada pelo startActivityForResult
        }
    }

    public void atualizaListagem(){
        carroDaoBanco = new CarroDaoBanco(bancoDados.getReadableDatabase());
        carros= carroDaoBanco.getCarros();
        //crio adapter passando contexto, layout e lista
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, carros);
        listagemCarro.setAdapter(adapter);//envio para lista
    }

}