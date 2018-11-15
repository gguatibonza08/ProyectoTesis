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
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.adapters.hotelAdapter;
import co.com.gguatibonza.proyectotesis.model.hotel;


public class alojamientoMunicipio extends android.support.v4.app.Fragment {


    private ArrayList<hotel> alojamientos;
    private LinearLayout layout;
    private RecyclerView recyclerView;
    private OnFragmentInteractionListener mListener;

    public alojamientoMunicipio() {
        // Required empty public constructor
    }

    public static alojamientoMunicipio newInstance() {
        alojamientoMunicipio fragment = new alojamientoMunicipio();
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
        View view = inflater.inflate(R.layout.fragment_alojamiento_municipio, container, false);
        recyclerView = view.findViewById(R.id.listaHoteles);

        alojamientos = new ArrayList<>();
        alojamientos.add(new hotel("https://i.imgur.com/IDpGiKe.jpg", "Mosto", "Carrera 29 # 41-25", "3108111814"));
        alojamientos.add(new hotel("https://i.imgur.com/nMbuPfm.jpg", "Cabrón", "carrera 35 # 42-17", "302421259"));
        alojamientos.add(new hotel("https://i.imgur.com/jkJko6W.jpg", "Camachos", "Carrera 35 # 34-02", "3166419240"));
        alojamientos.add(new hotel("https://i.imgur.com/sCso0hK.jpg", "Casalins", "Carrera 41", "314541"));

        final hotelAdapter adapter = new hotelAdapter(getContext(), alojamientos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), alojamientos.get(recyclerView.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
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
