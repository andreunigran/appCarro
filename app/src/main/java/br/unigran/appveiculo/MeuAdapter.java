package br.unigran.appveiculo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.unigran.domain.entidade.Carro;

public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.ViewHolder> {
    List<Carro>carros;
    private Context context;

    public MeuAdapter(List<Carro> carros, Context context) {
        this.carros = carros;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_carros,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nomeCarro.setText(carros.get(position).getNome());
        holder.placa.setText(carros.get(position).getPlaca());
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeCarro;
        TextView placa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeCarro=itemView.findViewById(R.id.nomeCarro);
            placa=itemView.findViewById(R.id.placa);
        }
    }
}