package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.adapters.municipioAdapter;
import co.com.gguatibonza.proyectotesis.model.municipio;


public class municipioFragment extends android.support.v4.app.Fragment {


    private OnFragmentInteractionListener mListener;
    private RecyclerView listMunicipios;
    private ArrayList<municipio> nombres = new ArrayList<>();

    public municipioFragment() {

    }


    public static municipioFragment newInstance() {
        municipioFragment fragment = new municipioFragment();
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
        View v = inflater.inflate(R.layout.fragment_municipio, container, false);
        listMunicipios = v.findViewById(R.id.listMunicipios);
        ayuda();
        municipioAdapter municipioAdapter = new municipioAdapter(getContext(), nombres);
        listMunicipios.setLayoutManager(new GridLayoutManager(getContext(), 2));
        listMunicipios.setItemAnimator(new DefaultItemAnimator());
        listMunicipios.setAdapter(municipioAdapter);
        listMunicipios.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("prueba", "onScrollStateChanged: " + newState);
            }
        });
        return v;
    }

    private void ayuda() {
        nombres.add(new municipio("Bucaramanga", "https://files.rcnradio.com/public/migration/212.jpg", getString(R.string.descripcionMunicipio)));
        nombres.add(new municipio("El PLayón", "https://files.rcnradio.com/public/migration/playon.jpg", getString(R.string.descripcionMunicipio)));
        nombres.add(new municipio("Veléz", "https://i.ytimg.com/vi/Q1VLPaEDcUs/maxresdefault.jpg", getString(R.string.descripcionMunicipio)));
        nombres.add(new municipio("Barichara", "https://photo980x880.mnstatic.com/b1c6dee81de57c3058243eb226cfc9ab/barichara_572610.jpg", getString(R.string.descripcionMunicipio)));
        nombres.add(new municipio("Guane", "https://i.ytimg.com/vi/Hfbg2GQElRQ/maxresdefault.jpg", getString(R.string.descripcionMunicipio)));
        nombres.add(new municipio("Chárala", "https://www.fotopaises.com/Fotos-Paises/t/2006/4/21/359_1145756033.jpg", getString(R.string.descripcionMunicipio)));


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
