package co.com.gguatibonza.proyectotesis.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.model.atractivo;

public class atractivoAdapter extends RecyclerView.Adapter<atractivoAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private static int lastpostion = -1;
    private ArrayList<atractivo> listaAtractivos;
    private View.OnClickListener listener;


    public atractivoAdapter(Context context, ArrayList<atractivo> listaAtractivos) {
        this.context = context;
        this.listaAtractivos = listaAtractivos;
    }

    @NonNull
    @Override
    public atractivoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_atractivo, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull atractivoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.nombreMunicipio.setText(listaAtractivos.get(i).getNombre());
        Picasso.get().load(listaAtractivos.get(i).getUrl()).into(viewHolder.imagenMunicipio);
        setAnimation(viewHolder.cardItem, i);
    }

    @Override
    public int getItemCount() {
        return listaAtractivos.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nombreMunicipio;
        private ImageView imagenMunicipio;
        private CardView cardItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardItem = itemView.findViewById(R.id.cardAtractivoItem);
            nombreMunicipio = itemView.findViewById(R.id.nombreAtractivoItem);
            imagenMunicipio = itemView.findViewById(R.id.imagenAtractivoItem);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    private void setAnimation(View view, int position) {
        if (position > lastpostion) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.animrecycler);
            view.startAnimation(animation);
            lastpostion = position;
        }
    }
}
