package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.adapters.logroAdapter;
import co.com.gguatibonza.proyectotesis.model.logro;


public class perfilFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private OnFragmentInteractionListener mListener;
    private ArrayList<logro> logros;

    public perfilFragment() {
        // Required empty public constructor
    }


    public static perfilFragment newInstance() {
        perfilFragment fragment = new perfilFragment();
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
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        recyclerView = view.findViewById(R.id.listaLogros);
        logros = new ArrayList<>();
        logros.add(new logro("nuevo", "https://previews.123rf.com/images/yupiramos/yupiramos1611/yupiramos161110968/65808307-sabia-hombre-corona-vector-de-epifan%C3%ADa-ilustraci%C3%B3n-dise%C3%B1o.jpg"));
        logros.add(new logro("segundo", "https://http2.mlstatic.com/juguete-disney-elena-de-avalor-magico-cetro-de-la-luz-con-s-D_NQ_NP_657454-MLA26434325366_112017-F.jpg"));
        logros.add(new logro("tercero", "https://www.rabat.net/pub/media/catalog/product/cache/image/700x700/e9c3970ab036de70892d86c6d221abfe/p/0/p021511460_1.jpg"));
        logros.add(new logro("Cuarto", "https://www.rabat.net/pub/media/catalog/product/cache/image/700x700/e9c3970ab036de70892d86c6d221abfe/p/0/p021511460_1.jpg"));
        logros.add(new logro("nuevo", "https://previews.123rf.com/images/yupiramos/yupiramos1611/yupiramos161110968/65808307-sabia-hombre-corona-vector-de-epifan%C3%ADa-ilustraci%C3%B3n-dise%C3%B1o.jpg"));
        logros.add(new logro("segundo", "https://http2.mlstatic.com/juguete-disney-elena-de-avalor-magico-cetro-de-la-luz-con-s-D_NQ_NP_657454-MLA26434325366_112017-F.jpg"));
        logros.add(new logro("tercero", "https://www.rabat.net/pub/media/catalog/product/cache/image/700x700/e9c3970ab036de70892d86c6d221abfe/p/0/p021511460_1.jpg"));
        logros.add(new logro("Cuarto", "https://www.rabat.net/pub/media/catalog/product/cache/image/700x700/e9c3970ab036de70892d86c6d221abfe/p/0/p021511460_1.jpg"));



        logroAdapter logroAdapter = new logroAdapter(getContext(), logros);
       // recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(logroAdapter);


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
