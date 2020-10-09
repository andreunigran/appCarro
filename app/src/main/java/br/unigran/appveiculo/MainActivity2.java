package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import br.unigran.db.BancoDados;
import br.unigran.domain.dao.CarroDaoBanco;
import br.unigran.domain.entidade.Carro;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

    public  void inicializa(List<Carro> carros){
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCarros);
        MeuAdapter meuAdapter = new MeuAdapter(carros,this);
        recyclerView.setAdapter(meuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}