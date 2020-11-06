package br.unigran.appveiculo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.unigran.domain.entidade.Carro;

public class MeuAdapter extends RecyclerView.Adapter<MeuAdapter.ViewHolder> {
    List<Carro>carros;
    private Context context;

    public MeuAdapter(List<Carro> carros, Context context, AdapterView.OnItemClickListener onItemClickListener) {
        this.carros = carros;
        this.context = context;
        this.itemClickListener=onItemClickListener;
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

    public Carro getItem(int i) {
        return carros.get(i);

    }
    private AdapterView.OnItemClickListener itemClickListener;
    public class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView nomeCarro;
        TextView placa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeCarro=itemView.findViewById(R.id.nomeCarro);
            placa=itemView.findViewById(R.id.placa);

            nomeCarro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"Ola1",Toast.LENGTH_LONG).show();
                }
            });
//            placa.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(context,"Ola11",Toast.LENGTH_LONG).show();
//                }
//            });
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(null,view,getAdapterPosition(),view.getId());
            Toast.makeText(context,"Ola12",Toast.LENGTH_LONG).show();
        }
    }
}