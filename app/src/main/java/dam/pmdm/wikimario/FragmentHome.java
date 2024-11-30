package dam.pmdm.wikimario;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.snackbar.Snackbar;
import java.util.Arrays;
import java.util.List;

import dam.pmdm.wikimario.databinding.FragmentHomeBinding;
/**
 * Fragmento que muestra un listado de los personajes que se pueden seleccionar.
 *
 *  Este fragmento utiliza View Binding para gestionar las vistas y un RecyclerView
 *  para mostrar los datos de los personajes.
 */
public class FragmentHome extends Fragment {

    // View Binding para manejar las vistas
    private FragmentHomeBinding binding;
    //Adaptador para el Recycleview
    private MarioRecyclerViewAdapter adapter;

    /**
     * Infla el diseño del FragmentHome y configura el RecyclerView.
     *
     * @param inflater  el objeto LayoutInflater para inflar la vista.
     * @param container el contenedor padre al que se añadirá la vista (puede ser nulo).
     * @param savedInstanceState si no es nulo, contiene datos de estado previos.
     * @return la vista raíz del fragmento.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento con View Binding
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // Configurar el RecyclerView con un LinearLayoutManager
        binding.homeRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crea la lista de personajes
        List<MarioData> characters = Arrays.asList(
                new MarioData(R.drawable.mario, getString(R.string.mario_name), getString(R.string.descripton_mario), getString(R.string.skills_mario)),
                new MarioData(R.drawable.luigi, getString(R.string.luigi_name), getString(R.string.description_luigi), getString(R.string.skills_luigi)),
                new MarioData(R.drawable.peach, getString(R.string.peach_name), getString(R.string.description_peach), getString(R.string.skills_peach)),
                new MarioData(R.drawable.toad, getString(R.string.toad_name), getString(R.string.description_toad), getString(R.string.skills_toad))
        );

        // Configurar el adaptador del RecyclerView
        if (!characters.isEmpty()) {
            adapter = new MarioRecyclerViewAdapter(characters, requireContext());
            binding.homeRecyclerview.setAdapter(adapter);
        }

        return binding.getRoot();
    }

    /**
     * Configura el título del ActionBar y registra un  menú.
     *
     * @param view la vista raíz del fragmento.
     * @param savedInstanceState si no es nulo, contiene datos de estado previos.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Cambiar el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.elegir);
        }

        Snackbar.make(view,R.string.welcome, Snackbar.LENGTH_SHORT).show();

        // Registrar el MenuProvider para manejar el menú
        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                // Inflar el menú desde el recurso XML
                menuInflater.inflate(R.menu.menu, menu);
            }

            /**
             * Acciona los elementos del menú creado
             * @param menuItem elemento del menú que se seleccionó
             * @return
             */
            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                // Accionar los elementos del menú
                if (menuItem.getItemId() == R.id.menu_acerca) {
                    showAboutDialog();
                    return true;
                }
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

    }

    /**
     * Método para mostrar el diálogo "Acerca de"
     */
    private void showAboutDialog() {
        new AlertDialog.Builder(requireContext())
                .setTitle(R.string.acerca_de)
                .setMessage(R.string.app_desarrollada)
                .setIcon(R.drawable.logo) // Cambia por el ícono de tu app
                .setPositiveButton(R.string.accept, (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }
}
