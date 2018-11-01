package co.com.gguatibonza.proyectotesis.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.R;
import co.com.gguatibonza.proyectotesis.model.atractivo;


public class atractivosMunicipio extends android.support.v4.app.Fragment {

    private OnFragmentInteractionListener mListener;

    private ArrayList<atractivo> atractivos;
    private LinearLayout layout;

    public atractivosMunicipio() {
        // Required empty public constructor
    }


    public static atractivosMunicipio newInstance() {
        atractivosMunicipio fragment = new atractivosMunicipio();
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
        View view = inflater.inflate(R.layout.fragment_atractivos_municipio, container, false);
        layout = view.findViewById(R.id.contenedorPrincipalAtractivo);

        atractivos = new ArrayList<>();
        atractivos.add(new atractivo("https://media-cdn.tripadvisor.com/media/photo-s/0e/15/6e/f5/las-piscinas.jpg", "Cañon del Chicamocha"));
        atractivos.add(new atractivo("https://www.las2orillas.co/wp-content/uploads/2017/09/gachas-santander.jpg", "Las Gachas"));
        atractivos.add(new atractivo("https://www.santanderalextremo.com/wp-content/uploads/2018/02/Zapatoca-Historia-naturaleza-y-Vino.jpg", "Zapatoca"));
        atractivos.add(new atractivo("https://www.laopinion.com.co/sites/default/files/styles/640x370/public/2016/04/10/imagen/santur.jpg", "Paramo de Santurban"));

        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        cardParams.setMargins(10, 10, 10, 10);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 600);
        LinearLayout.LayoutParams textoParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "crimsontextbold.ttf");

        for (final atractivo atractivo : atractivos) {
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
            Picasso.get().load(atractivo.getUrl()).into(imagen);
            TextView texto = new TextView(getContext());
            texto.setLayoutParams(textoParams);
            texto.setText(atractivo.getNombre());
            texto.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            texto.setTextSize(25);
            texto.setTypeface(face);
            texto.setTextColor(getResources().getColor(R.color.dark));
            aux.addView(imagen);
            aux.addView(texto);
            card.addView(aux);
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "prueba" + atractivo.getNombre(), Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(card);


        }


        return view;
    }


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
