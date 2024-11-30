package dam.pmdm.wikimario;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import dam.pmdm.wikimario.databinding.FragmentDetailsBinding;

/**
 * Fragmento que muestra los detalles de un personaje en la aplicación.
 *
 * Utiliza View Binding para gestionar las vistas. Los datos del personaje
 * (imagen, nombre, descripción y habilidades) se reciben a través de argumentos.
 */
public class FragmentDetails extends Fragment {

    private FragmentDetailsBinding binding;


    /**
     * Infla el diseño del fragmento y configura View Binding.
     *
     * @param inflater  el objeto LayoutInflater para inflar la vista.
     * @param container el contenedor padre al que se añadirá la vista.
     * @param savedInstanceState si no es nulo, contiene datos de estado previos.
     * @return la vista raíz del fragmento.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding=FragmentDetailsBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    /**
     * Configura las vistas del fragmento con los datos recibidos.
     *
     * @param view la vista raíz del fragmento.
     * @param savedInstanceState si no es nulo, contiene datos de estado previos.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            int image = getArguments().getInt("image");
            String name = getArguments().getString("name");
            String description = getArguments().getString("description");
            String skills = getArguments().getString("skills");

            // Asignar los datos a los componentes
            binding.image.setImageResource(image);
            binding.name.setText(name);
            binding.description.setText(description);
            binding.skills.setText(skills);

            // Mostrar un Toast con el nombre del personaje seleccionado
            Toast.makeText(requireContext(), getString(R.string.mostrar_toast) + name, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Configura el título del ActionBar.
     *
     * Establece el título del ActionBar al nombre del personaje al iniciar el fragmento.
     * */
    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar por el del personaje elegido
        if (getActivity() != null) {
            String name = getArguments().getString("name");
            binding.name.setText(name);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(name);
        }
    }
}