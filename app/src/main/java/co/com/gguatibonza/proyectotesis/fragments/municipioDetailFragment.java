package co.com.gguatibonza.proyectotesis.fragments;

import android.app.Fragment;
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
import co.com.gguatibonza.proyectotesis.model.municipio;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link municipioDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link municipioDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class municipioDetailFragment extends android.support.v4.app.Fragment {

    private OnFragmentInteractionListener mListener;
    private ImageView portada, bandera, escudo;
    private TextView nombre, descripcion;
    private municipio municipio;

    public municipioDetailFragment() {

    }

    public static municipioDetailFragment newInstance() {
        municipioDetailFragment fragment = new municipioDetailFragment();
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
        View view = inflater.inflate(R.layout.fragment_municipio_detail, container, false);
        portada = view.findViewById(R.id.portadaDetail);
        bandera = view.findViewById(R.id.banderaDetail);
        escudo = view.findViewById(R.id.escudoDetail);
        nombre = view.findViewById(R.id.nombreMunicipioDetail);
        descripcion = view.findViewById(R.id.descripcionDetail);

        Picasso.get().load(municipio.getFoto()).into(portada);
        Picasso.get().load(municipio.getSimbolos().get(0)).into(escudo);
        Picasso.get().load(municipio.getSimbolos().get(1)).into(bandera);
        nombre.setText(municipio.getNombre());
        descripcion.setText(municipio.getDescripcionCompleta());


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


    public void recibirDatos(municipio municipio) {
        this.municipio = municipio;
    }
}
