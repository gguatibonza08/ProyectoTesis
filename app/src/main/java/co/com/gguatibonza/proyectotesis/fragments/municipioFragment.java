package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.adapters.municipioAdapter;
import co.com.gguatibonza.proyectotesis.interfaces.enviarMenu;
import co.com.gguatibonza.proyectotesis.model.municipio;


public class municipioFragment extends android.support.v4.app.Fragment {


    private OnFragmentInteractionListener mListener;
    private RecyclerView listMunicipios;
    private ArrayList<municipio> nombres;

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
        nombres = new ArrayList<>();
        ayuda();
        municipioAdapter Adapter = new municipioAdapter(getContext(), nombres);
        listMunicipios.setLayoutManager(new GridLayoutManager(getContext(), 2));
        listMunicipios.setItemAnimator(new DefaultItemAnimator());
        Adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), nombres.get(listMunicipios.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        listMunicipios.setAdapter(Adapter);

        return v;
    }


    private void ayuda() {
        ArrayList<String> simbolos = new ArrayList<>();
        simbolos.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Escudo_de_Bucaramanga.svg");
        simbolos.add("http://www.bucaramanga.gov.co/el-mapa/wp-content/uploads/2016/10/bandera_Bucaramanga-300x150.png");
        nombres.add(new municipio("Bucaramanga", getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), simbolos, "https://files.rcnradio.com/public/migration/212.jpg"));
        simbolos.clear();
        simbolos.add("http://www.elplayon-santander.gov.co/sites/elplayonsantander/content/files/000021/1010_escudoooooooo_200x200.png");
        simbolos.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Flag_of_El_Play%C3%B3n_%28Santander%29.svg/750px-Flag_of_El_Play%C3%B3n_%28Santander%29.svg.png");
        nombres.add(new municipio("El PLayón", getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), simbolos, "https://files.rcnradio.com/public/migration/playon.jpg"));
        simbolos.clear();
        simbolos.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Escudo_de_Bucaramanga.svg");
        simbolos.add("http://www.bucaramanga.gov.co/el-mapa/wp-content/uploads/2016/10/bandera_Bucaramanga-300x150.png");
        nombres.add(new municipio("Veléz", getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), simbolos, "https://i.ytimg.com/vi/Q1VLPaEDcUs/maxresdefault.jpg"));
        simbolos.clear();
        simbolos.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Escudo_de_Bucaramanga.svg");
        simbolos.add("http://www.bucaramanga.gov.co/el-mapa/wp-content/uploads/2016/10/bandera_Bucaramanga-300x150.png");
        nombres.add(new municipio("Barichara", getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), simbolos, "https://photo980x880.mnstatic.com/b1c6dee81de57c3058243eb226cfc9ab/barichara_572610.jpg"));
        simbolos.clear();
        simbolos.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Escudo_de_Bucaramanga.svg");
        simbolos.add("http://www.bucaramanga.gov.co/el-mapa/wp-content/uploads/2016/10/bandera_Bucaramanga-300x150.png");
        nombres.add(new municipio("Guane", getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), simbolos, "https://i.ytimg.com/vi/Hfbg2GQElRQ/maxresdefault.jpg"));
        simbolos.clear();
        simbolos.add("https://upload.wikimedia.org/wikipedia/commons/f/f9/Escudo_de_Bucaramanga.svg");
        simbolos.add("http://www.bucaramanga.gov.co/el-mapa/wp-content/uploads/2016/10/bandera_Bucaramanga-300x150.png");
        nombres.add(new municipio("Chárala", getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), simbolos, "https://www.fotopaises.com/Fotos-Paises/t/2006/4/21/359_1145756033.jpg"));

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
