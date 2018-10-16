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
import co.com.gguatibonza.proyectotesis.model.municipio;

public class municipioAdapter extends RecyclerView.Adapter<municipioAdapter.ViewHolder> {

    private Context context;
    private static int lastpostion = -1;
    private ArrayList<municipio> listaMunicipios;

    public municipioAdapter(Context context, ArrayList<municipio> listaMunicipios) {
        this.context = context;
        this.listaMunicipios = listaMunicipios;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.municipio_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nombreMunicipio.setText(listaMunicipios.get(i).getNombre());
        viewHolder.descriptionMunicipio.setText(listaMunicipios.get(i).getDescripcion());
        Picasso.get().load(listaMunicipios.get(i).getFoto()).into(viewHolder.imagenMunicipio);
        setAnimation(viewHolder.cardItem, i);

    }

    @Override
    public int getItemCount() {
        return listaMunicipios.size();
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
