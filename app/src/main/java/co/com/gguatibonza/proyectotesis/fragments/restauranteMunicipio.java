package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.model.restaurante;


public class restauranteMunicipio extends android.support.v4.app.Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<restaurante> restaurantes;
    private LinearLayout layout;

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
        layout = view.findViewById(R.id.contenedorPrincipalRestaurante);

        restaurantes = new ArrayList<>();
        restaurantes.add(new restaurante("https://i.imgur.com/IDpGiKe.jpg", "Mosto", "Carrera 29 # 41-25", "3108111814"));
        restaurantes.add(new restaurante("https://i.imgur.com/nMbuPfm.jpg", "Cabrón", "carrera 35 # 42-17", "302421259"));
        restaurantes.add(new restaurante("https://i.imgur.com/jkJko6W.jpg", "Camachos", "Carrera 35 # 34-02", "3166419240"));
        restaurantes.add(new restaurante("https://i.imgur.com/sCso0hK.jpg", "Casalins", "Carrera 41", "314541"));

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(10, 10, 10, 40);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 600);
        LinearLayout.LayoutParams textoParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "crimsontextbold.ttf");
        Typeface face2 = Typeface.createFromAsset(getActivity().getAssets(),
                "worksansmedium.ttf");

        for (final restaurante restaurante : restaurantes) {
            CardView card = new CardView(getContext());
            card.setRadius(10);
            card.setLayoutParams(cardParams);

            LinearLayout aux = new LinearLayout(getContext());
            aux.setLayoutParams(layoutParams);
            aux.setOrientation(LinearLayout.VERTICAL);
            aux.setGravity(Gravity.CENTER_VERTICAL);
            ImageView imagen = new ImageView(getContext());
            imagen.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imagen.setLayoutParams(imageParams);
            Picasso.get().load(restaurante.getUrl()).into(imagen);
            TextView nombre = new TextView(getContext());
            nombre.setLayoutParams(textoParams);
            nombre.setText(restaurante.getNombre());
            nombre.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            nombre.setTextSize(25);
            nombre.setTypeface(face);
            nombre.setTextColor(getResources().getColor(R.color.dark));
            textoParams.setMargins(50, 0, 20, 0);
            TextView direccion = new TextView(getContext());
            direccion.setLayoutParams(textoParams);
            direccion.setText(restaurante.getDireccion());
            direccion.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            direccion.setTextSize(16);
            direccion.setTypeface(face2);
            direccion.setTextColor(getResources().getColor(R.color.dark));
            TextView telefono = new TextView(getContext());

            telefono.setLayoutParams(textoParams);
            telefono.setText(restaurante.getTelefono());
            telefono.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            telefono.setTextSize(16);
            telefono.setTypeface(face2);
            telefono.setTextColor(getResources().getColor(R.color.dark));
            aux.addView(imagen);
            aux.addView(nombre);
            aux.addView(direccion);
            aux.addView(telefono);
            card.addView(aux);
            layout.addView(card);


        }


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
