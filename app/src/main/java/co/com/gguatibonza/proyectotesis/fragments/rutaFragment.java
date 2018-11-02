package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.adapters.rutaAdapter;
import co.com.gguatibonza.proyectotesis.model.ruta;

public class rutaFragment extends android.support.v4.app.Fragment {

    private OnFragmentInteractionListener mListener;
    RecyclerView listRutas;
    ArrayList<ruta> rutas;

    public rutaFragment() {
        // Required empty public constructor
    }


    public static rutaFragment newInstance() {
        rutaFragment fragment = new rutaFragment();
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
        View v = inflater.inflate(R.layout.fragment_ruta, container, false);
        rutas = new ArrayList<>();
        rutas.add(new ruta("num1", "https://cdn-images-1.medium.com/max/1600/1*b1cBcGGOy1djw8kbBkWOng.jpeg", "uafs ahsfas fihasvf asihfvsai fisagfv asifas y8f00"));
        rutas.add(new ruta("num1", "https://cdn-images-1.medium.com/max/1600/1*b1cBcGGOy1djw8kbBkWOng.jpeg", "uafs ahsfas fihasvf asihfvsai fisagfv asifas y8f00"));
        rutas.add(new ruta("num1", "https://cdn-images-1.medium.com/max/1600/1*b1cBcGGOy1djw8kbBkWOng.jpeg", "uafs ahsfas fihasvf asihfvsai fisagfv asifas y8f00"));
        rutas.add(new ruta("num1", "https://cdn-images-1.medium.com/max/1600/1*b1cBcGGOy1djw8kbBkWOng.jpeg", "uafs ahsfas fihasvf asihfvsai fisagfv asifas y8f00"));
        rutas.add(new ruta("num1", "https://cdn-images-1.medium.com/max/1600/1*b1cBcGGOy1djw8kbBkWOng.jpeg", "uafs ahsfas fihasvf asihfvsai fisagfv asifas y8f00"));

        listRutas = v.findViewById(R.id.listRutas);
        rutaAdapter Adapter = new rutaAdapter(getContext(), rutas);
        listRutas.setLayoutManager(new GridLayoutManager(getContext(), 2));
        listRutas.setItemAnimator(new DefaultItemAnimator());

        Adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "sadaf", Toast.LENGTH_SHORT).show();
            }
        });
        listRutas.setAdapter(Adapter);

        return v;
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
