package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.adapters.municipioAdapter;
import co.com.gguatibonza.proyectotesis.model.auxiliar;
import co.com.gguatibonza.proyectotesis.model.municipio;
import co.com.gguatibonza.proyectotesis.municipioDetail;
import io.realm.Realm;
import io.realm.RealmResults;


public class municipioFragment extends android.support.v4.app.Fragment {


    private OnFragmentInteractionListener mListener;
    private RecyclerView listMunicipios;
    private RealmResults<municipio> nombres;
    private Realm realm;
    private auxiliar aux;
    private static final String keyMunicipio = "municipio";

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
        realm = Realm.getDefaultInstance();
        aux = realm.where(auxiliar.class).equalTo("id", 1).findFirst();
        obtener();
        municipioAdapter Adapter = new municipioAdapter(getContext(), nombres);
        listMunicipios.setLayoutManager(new GridLayoutManager(getContext(), 2));
        listMunicipios.setItemAnimator(new DefaultItemAnimator());

        Adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int idMunicipio = nombres.get(listMunicipios.getChildAdapterPosition(view)).getIdMunicipio();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        aux.setIdMunicipio(idMunicipio);
                        realm.insertOrUpdate(aux);
                    }
                });
                Intent i = new Intent(getContext(), municipioDetail.class);
                startActivity(i);
            }
        });
        listMunicipios.setAdapter(Adapter);

        return v;
    }

    private void obtener() {
        nombres = realm.where(municipio.class).findAll();
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
