package br.unigran.domain;

import java.util.ArrayList;
import java.util.List;

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
