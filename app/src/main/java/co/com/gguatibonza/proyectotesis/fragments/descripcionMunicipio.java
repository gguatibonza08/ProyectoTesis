package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.model.auxiliar;
import co.com.gguatibonza.proyectotesis.model.municipio;
import io.realm.Realm;


public class descripcionMunicipio extends android.support.v4.app.Fragment {
    private Realm realm;
    private auxiliar aux;
    private municipio lugar;
    private static final String keyMunicipio = "idMunicipio";

    private ImageView bandera, escudo;
    private TextView descripcion;

    private OnFragmentInteractionListener mListener;

    public descripcionMunicipio() {
        // Required empty public constructor
    }

    public static descripcionMunicipio newInstance(String param1, String param2) {
        descripcionMunicipio fragment = new descripcionMunicipio();
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
        View view = inflater.inflate(R.layout.fragment_descripcion_municipio, container, false);
        realm = Realm.getDefaultInstance();
        aux = realm.where(auxiliar.class).equalTo("id", 1).findFirst();
        lugar = realm.where(municipio.class).equalTo(keyMunicipio, aux.getIdMunicipio()).findFirst();
        descripcion = view.findViewById(R.id.descripcionLarga);
        descripcion.setText(lugar.getDescripcionLargaMunicipio());


        bandera = view.findViewById(R.id.banderaDescripcion);
        escudo = view.findViewById(R.id.escudoDescripcion);
        Picasso.get().load("https://st2.depositphotos.com/1482106/12261/i/950/depositphotos_122617832-stock-photo-waving-flag-of-bucaramanga-colombia.jpg").into(bandera);
        Picasso.get().load("http://www.bucaramanga.gov.co/el-mapa/wp-content/uploads/2016/10/escudo.png").into(escudo);

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
