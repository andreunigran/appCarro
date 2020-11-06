package br.unigran.appveiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import br.unigran.db.BancoDados;
import br.unigran.domain.dao.CarroDaoBanco;
import br.unigran.domain.entidade.Carro;
import br.unigran.domain.dao.CarroDao;

public class CadastroVeiculo extends AppCompatActivity {

    private EditText nome;
    private EditText ano;
    private EditText placa;
    private BancoDados bancoDados;
    private CarroDaoBanco carroDaoBanco;
    private Carro carro;
    private Spinner dados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cadastro_veiculo);
        //vinculo com a tela
        nome= findViewById(R.id.nome_veiculo);
        ano= findViewById(R.id.ano);
        placa= findViewById(R.id.placa);
        dados=findViewById(R.id.spinner);
        ArrayAdapter adapter= ArrayAdapter.createFromResource(this,R.array.dados,android.R.layout.select_dialog_multichoice);
        dados.setAdapter(adapter);


        Intent it =getIntent();
        carro= (Carro) it.getSerializableExtra("carro");
        if(carro!=null) {
            nome.setText(carro.getNome());
            placa.setText(carro.getPlaca());
            ano.setText(carro.getAno().toString());
        }

    }

    /**
     * Ação botao salvar veiculo
     * @param view
     */
    public  void salvarVeiculo(View view){
        bancoDados = new BancoDados(this);
        carroDaoBanco = new CarroDaoBanco(bancoDados.getWritableDatabase());
        //crio carro

        if(carro==null)
            carro = new Carro();
        //pego os dados e preencho o carro


        if(valida()) {
            carro.setNome(nome.getText().toString());
            carro.setAno(Integer.parseInt(ano.getText().toString()));
            carro.setPlaca(placa.getText().toString());

            //salvo carro na lista
            if(carro.getId()!=null && carro.getId()>0)
                carroDaoBanco.atualizarVeiculo(carro);
            else
                carroDaoBanco.inserirVeiculo(carro);


            //verifico se foi salvo
          //  System.out.println(CarroDao.getDados());
            //  finish();//fecha
            setResult(RESULT_OK);
            super.onBackPressed();
        }
    }

    public boolean valida(){
        return validaEditText(nome) &&validaEditText(placa)&&validaEditText(ano)?true:false;
    }
   //qualquer edittext
    public boolean validaEditText(EditText editText){
       if(!TextUtils.isEmpty(editText.getText().toString().trim())){
           return true;
       }else{
           editText.setError("O Campo deve ser preenchido");
           editText.requestFocus();
          // Toast.makeText(this,"O Campo nome deve ser preenchido",Toast.LENGTH_LONG).show();
           return  false;
       }
    }
}