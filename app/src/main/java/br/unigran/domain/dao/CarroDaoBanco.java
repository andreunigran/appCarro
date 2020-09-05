package br.unigran.domain.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedList;
import java.util.List;

import br.unigran.domain.entidade.Carro;

public class CarroDaoBanco  {
    private SQLiteDatabase conexaoBD;

    public CarroDaoBanco(SQLiteDatabase conexaoBD) {
        this.conexaoBD = conexaoBD;
    }

    public void inserirVeiculo(Carro carro){
        ContentValues values = new ContentValues();
        values.put("NOME",carro.getNome());
        values.put("ANO",carro.getAno());
        values.put("PLACA",carro.getPlaca());
        conexaoBD.insert("VEICULO",null,values);
    }
    public void atualizarVeiculo(Carro carro){
        ContentValues values = new ContentValues();
        values.put("NOME",carro.getNome());
        values.put("ANO",carro.getAno());
        values.put("PLACA",carro.getPlaca());
        conexaoBD.update("VEICULO",values,"ID=?",new String[]{carro.getId().toString()});
    }
    public void inserirVeiculo(Integer id){
        conexaoBD.delete("VEICULO","ID=?",new String[]{id.toString()});
    }
    public List<Carro> getCarros(){
        List<Carro>carros = new LinkedList<>();
        Cursor cursor;
        Carro carro;


        cursor = conexaoBD.rawQuery("SELECT * FROM VEICULO",null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            carro=new Carro();
            carro.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            carro.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
            carro.setPlaca(cursor.getString(cursor.getColumnIndex("PLACA")));
            carro.setAno(cursor.getInt(cursor.getColumnIndex("ANO")));
            carros.add(carro);
            cursor.moveToNext();
        }
        return carros;
    }




}
