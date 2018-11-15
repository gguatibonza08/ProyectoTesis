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
import co.com.gguatibonza.proyectotesis.model.hotel;

public class hotelAdapter extends RecyclerView.Adapter<hotelAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private static int lastpostion = -1;
    private ArrayList<hotel> listaRestaurante;
    private View.OnClickListener listener;


    public hotelAdapter(Context context, ArrayList<hotel> listaRestaurante) {
        this.context = context;
        this.listaRestaurante = listaRestaurante;
    }

    @NonNull
    @Override
    public hotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_hotel, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull hotelAdapter.ViewHolder viewHolder, int i) {
        viewHolder.nombreMunicipio.setText(listaRestaurante.get(i).getNombre());
        viewHolder.direccion.setText(listaRestaurante.get(i).getDireccion());
        viewHolder.telefono.setText(listaRestaurante.get(i).getTelefono());
        Picasso.get().load(listaRestaurante.get(i).getUrl()).into(viewHolder.imagenMunicipio);
        setAnimation(viewHolder.cardItem, i);
    }

    @Override
    public int getItemCount() {
        return listaRestaurante.size();
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
        private TextView telefono;
        private TextView direccion;
        private CardView cardItem;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardItem = itemView.findViewById(R.id.cardOhotelItem);
            nombreMunicipio = itemView.findViewById(R.id.nombrehotelItem);
            imagenMunicipio = itemView.findViewById(R.id.imagenHotelItem);
            direccion = itemView.findViewById(R.id.direccionHotelItem);
            telefono = itemView.findViewById(R.id.telefonoHotelItem);
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
