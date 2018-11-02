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
import co.com.gguatibonza.proyectotesis.model.logro;
import co.com.gguatibonza.proyectotesis.model.municipio;
import io.realm.RealmResults;

public class logroAdapter extends RecyclerView.Adapter<logroAdapter.ViewHolder> implements View.OnClickListener {

    private Context context;
    private static int lastpostion = -1;
    private ArrayList<logro> listaLogros;
    private View.OnClickListener listener;

    public logroAdapter(Context context, ArrayList<logro> listaLogros) {
        this.context = context;
        this.listaLogros = listaLogros;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.logro_item, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.nombreLogro.setText(listaLogros.get(i).getNombreLogro());
        Picasso.get().load(listaLogros.get(i).getFotoLogro()).into(viewHolder.fotoLogro);
    }

    @Override
    public int getItemCount() {
        return listaLogros.size();
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
        private TextView nombreLogro;
        private ImageView fotoLogro;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreLogro = itemView.findViewById(R.id.nombreLogroItem);
            fotoLogro = itemView.findViewById(R.id.imagenLogroItem);
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
