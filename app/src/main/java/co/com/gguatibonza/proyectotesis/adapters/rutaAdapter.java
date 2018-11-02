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
import co.com.gguatibonza.proyectotesis.model.ruta;

public class rutaAdapter extends RecyclerView.Adapter<rutaAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private static int lastpostion = -1;
    private ArrayList<ruta> listaRutas;
    private View.OnClickListener listener;

    public rutaAdapter(Context context, ArrayList<ruta> listaRutas) {
        this.context = context;
        this.listaRutas = listaRutas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.municipio_item, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nombreMunicipio.setText(listaRutas.get(i).getNombre());
        viewHolder.descriptionMunicipio.setText(listaRutas.get(i).getDescripcion());
        Picasso.get().load(listaRutas.get(i).getFoto()).into(viewHolder.imagenMunicipio);
        setAnimation(viewHolder.cardItem, i);
    }

    @Override
    public int getItemCount() {
        return listaRutas.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
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
        private TextView descriptionMunicipio;
        private CardView cardItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardItem = itemView.findViewById(R.id.cardMunicipioItem);
            nombreMunicipio = itemView.findViewById(R.id.nombreMunicipioItem);
            imagenMunicipio = itemView.findViewById(R.id.imagenMunicipioItem);
            descriptionMunicipio = itemView.findViewById(R.id.descripcionMunicipioItem);

        }

    }

    private void setAnimation(View view, int position) {
        if (position > lastpostion) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.animrecycler);
            view.startAnimation(animation);
            lastpostion = position;
        }
    }
}