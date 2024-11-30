package dam.pmdm.wikimario;

import androidx.recyclerview.widget.RecyclerView;

import dam.pmdm.wikimario.databinding.ItemCardviewBinding;

/**
 * ViewHolder personalizado para gestionar las vistas de cada elemento en el RecyclerView.
 */
public class MarioViewHolder extends RecyclerView.ViewHolder {

    // Binding para las vistas del diseño individual.
    private final ItemCardviewBinding binding;

    /**
     * Constructor del ViewHolder.
     *
     * @param binding Objeto de ItemCardviewBinding que permite acceder a las vistas del diseño.
     */
    public MarioViewHolder(ItemCardviewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    /**
     * Vincula los datos de un objeto MarioData a las vistas del diseño.
     *
     * @param character Datos del personaje que se mostrarán.
     */
    public void bind (MarioData character){
        binding.name.setText(character.getName()); // Usar DataBinding para enlazar los datos
        binding.image.setImageResource(character.getImage()); // Cargar imagen con setImageResource()

        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato

    }
}
