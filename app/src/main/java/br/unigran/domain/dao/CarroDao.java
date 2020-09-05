package br.unigran.domain.dao;

import java.util.ArrayList;
import java.util.List;

import br.unigran.domain.entidade.Carro;

public class CarroDao {
    private static List<Carro>dados = new ArrayList<>();
    private CarroDao(){
    }
    public static  void salvar(Carro carro){
        dados.add(carro);
    }
    public static  void remove(Carro carro){
        dados.remove(carro);
    }
    public static List getDados(){
        return dados;
    }
}
