package dam.pmdm.wikimario;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

import dam.pmdm.wikimario.databinding.FragmentHomeBinding;
import dam.pmdm.wikimario.databinding.FragmentSettingsBinding;

public class FragmentSettings extends Fragment {

    // View Binding para manejar las vistas
    private FragmentSettingsBinding binding;

    // Preferencias para almacenar configuraciones persistentes.
    private SharedPreferences sharedPreferences;

    // Guardar el idioma actual en las preferencias compartidas.
    private static final String CURRENT_LANGUAGE = "current_language";

    /**
     * Inflar la vista para fragmentSettings y configurar las preferencias.
     *
     * @param inflater Objeto para inflar la vista.
     * @param container Contenedor donde se insertará la vista inflada.
     * @param savedInstanceState Estado guardado del fragmento.
     * @return La vista inflada del fragmento.
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para este fragmento con View Binding
        binding = FragmentSettingsBinding.inflate(inflater, container, false);

        // Inicializar las preferencias compartidas
        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE);

        // Cambiar el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.vacio);
        }

        return binding.getRoot();
    }

    /**
     * Configurar las interacciones de la vista.
     *
     * @param view Vista fragmento.
     * @param savedInstanceState Estado previo del fragmento.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Establecer el estado inicial del Switch según el idioma actual
        String currentLanguage = sharedPreferences.getString(CURRENT_LANGUAGE, "es");
        binding.switchLanguage.setChecked(currentLanguage.equals("en"));

        // Configurar el listener para el Switch
        binding.switchLanguage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String newLanguage = isChecked ? "en" : "es";
            toggleLanguage(newLanguage);
        });
    }

    /**
     * Cambia el idioma de la aplicación y lo guarda en las preferencias.
     *
     * @param languageCode Código del idioma (es/en).
     */
    private void toggleLanguage(String languageCode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CURRENT_LANGUAGE, languageCode);
        editor.apply();

        setLocale(languageCode);

        // Reiniciar la actividad para aplicar los cambios de idioma
        requireActivity().recreate();
    }

    /**
     * Configura el idioma de la aplicación.
     *
     * @param languageCode Código del idioma.
     */
    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);

        // Actualizar el contexto de configuración
        requireActivity().getResources().updateConfiguration(config,
                requireActivity().getResources().getDisplayMetrics());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
