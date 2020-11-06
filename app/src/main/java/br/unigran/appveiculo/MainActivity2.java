package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.unigran.db.BancoDados;
import br.unigran.domain.dao.CarroDaoBanco;
import br.unigran.domain.entidade.Carro;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private FloatingActionButton botao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        botao=findViewById(R.id.botaoacao);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity2.this,CadastroVeiculo.class);
                startActivity(it);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        conexaoBD();
    }

    public void conexaoBD(){
        BancoDados bancoDados = new BancoDados(this);
        CarroDaoBanco carroDaoBanco = new CarroDaoBanco(bancoDados.getReadableDatabase());
        inicializa(carroDaoBanco.getCarros());
    }
    MeuAdapter meuAdapter;
    public  void inicializa(List<Carro> carros){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCarros);
         meuAdapter = new MeuAdapter(carros,this,this );
        recyclerView.setAdapter(meuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Carro carro = meuAdapter.getItem(i);
        switch (view.getId()){
            case R.id.nomeCarro:
                Toast.makeText(this,"teste",Toast.LENGTH_LONG).show();
                break;
        }
    }
}