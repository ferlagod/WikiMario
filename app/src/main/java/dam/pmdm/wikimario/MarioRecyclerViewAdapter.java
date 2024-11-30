package dam.pmdm.wikimario;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dam.pmdm.wikimario.databinding.ItemCardviewBinding;

/**
 * Adaptador para gestionar un RecyclerView que muestra una lista de personajes del universo de Mario.
 *
 * Utiliza View Binding para manejar las vistas de los elementos.
 */
public class MarioRecyclerViewAdapter extends RecyclerView.Adapter<MarioViewHolder> {

    // Lista de personajes
    private final ArrayList<MarioData> characters;
    // Contexto de la actividad o fragmento que utiliza este adaptador
    private final Context context;

    /**
     * Constructor del adaptador
     * @param characters Lista de datos de los personajes.
     * @param context Contexto donde se utiliza el adaptador
     */
    public MarioRecyclerViewAdapter(List<MarioData> characters, Context context){
        this.characters = new ArrayList<>(characters); // Crear un ArrayList a partir de characters
        this.context = context;
    }


    /**
     * Método que crea el ViewHolder
     * @param parent   El ViewGroup en el que se agregará la nueva vista después de que se vincule
     *                a una posición del adaptador.
     * @param viewType El tipo de vista de la nueva vista.
     * @return Un nuevo objeto MarioViewHolder.
     */
    @NonNull
    @Override
    public MarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el RecyclerView
        ItemCardviewBinding binding = ItemCardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new MarioViewHolder(binding);
    }

    /**
     * Método para enlazar con el ViewHolder
     * @param holder   ViewHolder, que debe actualizarse para representar el contenido del elemento
     *                en la posición especificada en el conjunto de datos.
     * @param position La posición del elemento dentro del conjunto de datos del adaptador.
     */
    @Override
    public void onBindViewHolder(@NonNull MarioViewHolder holder, int position) {
        MarioData currentCharacter = characters.get(position);
        holder.bind(currentCharacter);
        //Manejamos el evento de click
        holder.itemView.setOnClickListener(view -> itemClicked(currentCharacter, view));
    }

    /**
     * Maneja el evento de clic en un elemento, delegándolo a la actividad principal.
     *
     * @param currentCharacter El personaje seleccionado.
     * @param view la vista donde ocurrió el clic.
     */
    private void itemClicked(MarioData currentCharacter, View view) {
        ((MainActivity) context).characterClicked(currentCharacter, view);
    }


    /**
     * Método que devuelve el número de elementos en la lista.
     *
     * @return el tamaño de la lista de personajes.
     */
    @Override
    public int getItemCount() {
        return characters.size();
    }
}
