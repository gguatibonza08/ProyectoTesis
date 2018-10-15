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

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     menuBottomSheet.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class menuBottomSheet extends BottomSheetDialogFragment {


    private enviarMenu enviarMenu;

    // TODO: Customize parameters
    public static menuBottomSheet newInstance() {
        final menuBottomSheet fragment = new menuBottomSheet();
        final Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menuBottomSheet, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        final NavigationView navigationView = view.findViewById(R.id.navigation);
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
