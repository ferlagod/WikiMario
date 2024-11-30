package dam.pmdm.wikimario;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import dam.pmdm.wikimario.databinding.ActivityMainBinding;

/**
 * Actividad principal de la aplicación WikiMario.
 *
 * Esta clase gestiona la configuración principal de la interfaz de usuario,
 * incluyendo el DrawerLayout, la navegación entre fragmentos.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // Controlador de navegación.
    private NavController navController;

    // Diseño del contenedor lateral deslizante.
    private DrawerLayout drawerLayout;

    //Vista que contiene los elementos del menú.
    private NavigationView navigationView;

    // Botón para abrir y cerrar el menú lateral.
    private ActionBarDrawerToggle toggle;

    /**
     * Configura la actividad al ser creada.
     *
     * @param savedInstanceState Estado guardado previamente de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        // Configura el enlace a la vista
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configura el toolbar
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        drawerLayout = binding.drawerLayout;
        navigationView = binding.navView;

        // Configura el controlador de navegación
        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            navController = NavHostFragment.findNavController(navHostFragment);
            NavigationUI.setupActionBarWithNavController(this, navController);
            NavigationUI.setupWithNavController(navigationView, navController);
        }

        // Configura el botón  del menú lateral
        toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                binding.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Configura el listener para los elementos del menú de navegación
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                navController.navigate(R.id.fragmentHome);

            } else if (id == R.id.nav_settings) {
                navController.navigate(R.id.fragmentSettings);

            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }


    /**
     * Acción al hacer clic sobre un personaje.
     *
     * @param character Información del personaje seleccionada.
     * @param view Vista donde ocurrió el clic.
     */
    public void characterClicked(MarioData character, View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("image", character.getImage());
        bundle.putString("name", character.getName());
        bundle.putString("description", character.getDescription());
        bundle.putString("skills", String.valueOf(character.getSkills()));

        Navigation.findNavController(view).navigate(R.id.fragmentDetails, bundle);
    }

    /**
     * Comportamiento al presionar el botón de navegación "Up".
     *
     * @return true si la navegación fue manejada correctamente, de lo contrario, llama al comportamiento por defecto.
     */
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, drawerLayout) ||
                super.onSupportNavigateUp();
    }

    /**
     * Sincroniza el estado del botón de alternancia tras restaurar el estado de la actividad.
     *
     * @param savedInstanceState Estado guardado previamente de la actividad.
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    /**
     * Maneja los cambios de configuración, como la orientación del dispositivo.
     *
     * @param newConfig Nueva configuración del dispositivo.
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    }


