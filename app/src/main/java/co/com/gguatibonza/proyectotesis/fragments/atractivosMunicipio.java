package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.adapters.atractivoAdapter;
import co.com.gguatibonza.proyectotesis.model.atractivo;


public class atractivosMunicipio extends android.support.v4.app.Fragment {

    private OnFragmentInteractionListener mListener;

    private ArrayList<atractivo> atractivos;
    private RecyclerView recyclerView;


    public atractivosMunicipio() {
        // Required empty public constructor
    }


    public static atractivosMunicipio newInstance() {
        atractivosMunicipio fragment = new atractivosMunicipio();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_atractivos_municipio, container, false);
        recyclerView = view.findViewById(R.id.listaAtractivos);
        atractivos = new ArrayList<>();
        atractivos.add(new atractivo("https://media-cdn.tripadvisor.com/media/photo-s/08/65/4b/55/catedral-de-la-sagrada.jpg", "Catedral de la sagrada familia"));
        atractivos.add(new atractivo("http://www.viztaz.com.co/colombia/banco/galleries/santander/1165478.jpg", "Jardín Botánico Eloy Valenzuela"));
        atractivos.add(new atractivo("http://cr00.epimg.net/emisora/imagenes/2015/11/24/bucaramanga/1448405393_250391_1449244381_noticia_normal.jpg", "Ecoparque cerro del Santísimo"));
        atractivos.add(new atractivo("https://media-cdn.tripadvisor.com/media/photo-s/0a/31/44/78/parque-san-pio-de-noche.jpg", "Parque San Pio"));
        atractivos.add(new atractivo("https://files.rcnradio.com/public/migration/CasaBolivar13.jpg", "Museo casa de Bolívar"));
        atractivos.add(new atractivo("https://media-cdn.tripadvisor.com/media/photo-s/09/3d/0b/c0/palacio-de-justicia.jpg", "Palacio de Justicia"));
        atractivos.add(new atractivo("http://www.wradio.com.co/images_remote/365/3652622_n_vir3.jpg", "Parque Santander"));

        final atractivoAdapter adapter = new atractivoAdapter(getContext(), atractivos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), atractivos.get(recyclerView.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
        return view;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
