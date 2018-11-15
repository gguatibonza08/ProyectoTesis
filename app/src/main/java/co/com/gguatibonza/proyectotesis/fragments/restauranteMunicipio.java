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
import co.com.gguatibonza.proyectotesis.adapters.restauranteAdapter;
import co.com.gguatibonza.proyectotesis.model.restaurante;


public class restauranteMunicipio extends android.support.v4.app.Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<restaurante> restaurantes;
    private RecyclerView recyclerView;


    public restauranteMunicipio() {

    }

    public static restauranteMunicipio newInstance() {
        restauranteMunicipio fragment = new restauranteMunicipio();
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
        View view = inflater.inflate(R.layout.fragment_restaurante_municipio, container, false);
        recyclerView = view.findViewById(R.id.listaRestaurantes);
        restaurantes = new ArrayList<>();
        restaurantes.add(new restaurante("https://i.imgur.com/IDpGiKe.jpg", "Mosto", "Carrera 29 # 41-25", "3108111814"));
        restaurantes.add(new restaurante("https://i.imgur.com/nMbuPfm.jpg", "Cabrón", "carrera 35 # 42-17", "302421259"));
        restaurantes.add(new restaurante("https://i.imgur.com/jkJko6W.jpg", "Camachos", "Carrera 35 # 34-02", "3166419240"));
        restaurantes.add(new restaurante("https://i.imgur.com/sCso0hK.jpg", "Casalins", "Carrera 41", "314541"));
        final restauranteAdapter adapter = new restauranteAdapter(getContext(), restaurantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), restaurantes.get(recyclerView.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
