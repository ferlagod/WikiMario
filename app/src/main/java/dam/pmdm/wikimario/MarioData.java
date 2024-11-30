package dam.pmdm.wikimario;

/**
 * Clase donde se maneja los datos de los personajes
 *
 */
public class MarioData {

    private final int image;//Imagen del personaje
    private final String name; //Nombre del personaje
    private final String description;//Descripción del personaje
    private final String skills; //Habilidades del personaje

    /**
     * Constructor principal donde inicializa al personaje seleccionado
     * @param image Imagen del personaje
     * @param name  Nombre del personaje
     * @param description Descripción del personaje
     * @param skills Habilidades del personaje
     */
    public MarioData(int image, String name, String description, String skills) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.skills=skills;
    }

    /**
     * Método getter para obtener la imagen del personaje
     * @return Devuelve la imagen del personaje
     */
    public int getImage() {
        return image;
    }

    /**
     * Método getter para obtener el nombre del personaje
     * @return Devulve el nombre del personaje
     */
    public String getName() {
        return name;
    }


    /**
     * Método getter para obtener la descripción dle personaje
     * @return Devuelve la descripción del personaje
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método getter para obtener las habilidades del personaje
     * @return Devuelve las habilidades del personajes
     */
    public String getSkills() {
        return skills;
    }
}
