package co.com.gguatibonza.proyectotesis;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import co.com.gguatibonza.proyectotesis.interfaces.enviarMenu;
import co.com.gguatibonza.proyectotesis.model.Usuario;
import co.com.gguatibonza.proyectotesis.model.auxiliar;
import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.Realm;

public class menuBottomSheet extends BottomSheetDialogFragment {


    private enviarMenu enviarMenu;
    private Usuario user;
    private Realm realm;
    private static final String keyFragment = "idUsuario";
    private static final String fieldQuery = "id";

    // TODO: Customize parameters
    public static menuBottomSheet newInstance() {
        final menuBottomSheet fragment = new menuBottomSheet();
        final Bundle args = new Bundle();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        final NavigationView navigationView = view.findViewById(R.id.navigation);
        realm = Realm.getDefaultInstance();
        CircleImageView perfil = view.findViewById(R.id.perfilUsuarioBottom);
        TextView nombreUsuario = view.findViewById(R.id.nombreUsurioBottom);
        TextView correoUsuario = view.findViewById(R.id.correoUsurioBottom);
        auxiliar aux = realm.where(auxiliar.class).equalTo(fieldQuery, 1).findFirst();
        user = realm.where(Usuario.class).equalTo(keyFragment, aux.getIdUsuario()).findFirst();

        nombreUsuario.setText(user.getNombreUsuario() + " " + user.getApellidoUsuario());
        correoUsuario.setText(user.getCorreoUsuario());
        Picasso.get().load(user.getFotoUsuario()).into(perfil);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.municipioMenu:
                        enviarMenu.enviarMenu(R.id.municipioMenu);
                        dismiss();
                        break;
                    case R.id.rutaMenu:
                        enviarMenu.enviarMenu(R.id.rutaMenu);
                        dismiss();
                        break;
                    case R.id.perfilMenu:
                        enviarMenu.enviarMenu(R.id.perfilMenu);
                        dismiss();
                        break;
                    case R.id.contactanosMenu:
                        enviarMenu.enviarMenu(R.id.contactanosMenu);
                        dismiss();
                        break;
                    case R.id.calificanosMenu:
                        enviarMenu.enviarMenu(R.id.calificanosMenu);
                        dismiss();
                        break;
                    case R.id.acercaDeMenu:
                        enviarMenu.enviarMenu(R.id.acercaDeMenu);
                        dismiss();
                        break;
                }


                return true;
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        final Fragment parent = getParentFragment();
        if (parent != null) {
            enviarMenu = (enviarMenu) parent;
        } else {
            enviarMenu = (enviarMenu) context;
        }
    }

    @Override
    public void onDetach() {
        enviarMenu = null;
        super.onDetach();
    }

}
