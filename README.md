# WikiMario

WikiMario es una aplicación Android dedicada a los personajes del universo de Super Mario. La aplicación permite explorar una lista de personajes, visualizar sus detalles y gestionar configuraciones personalizadas como idioma y ajustes generales.

## Características

- **Lista de personajes**: Muestra un listado dinámico de los personajes de Super Mario usando `RecyclerView` y `CardView`.
- **Detalles de personajes**: Información detallada de cada personaje, incluyendo su imagen, descripción y habilidades.
- **Menú lateral**: Incluye un **Navigation Drawer** con las siguientes opciones:
  - Home: Navegar al listado de personajes.
  - Ajustes: Personalización de la aplicación con `SharedPreferences`.
  - Idioma: Alterna entre español e inglés.
- **Diseño temático**: Inspirado en los colores del universo Mario Bros, con un estilo visual atractivo y moderno.

## Tecnologías utilizadas

- **Lenguaje**: Java
- **Frameworks y librerías**:
  - Android Jetpack (Navigation, ViewBinding, RecyclerView, etc.)
  - Material Design para componentes de interfaz.
- **Gestión de vistas**: `ViewBinding` para un acceso seguro y eficiente a las vistas.
- **Navegación**: Implementada con `NavController` y `NavigationUI`.

## Requisitos

- Android Studio.
- SDK mínimo: 31 (Android 12).
- Dispositivo físico o emulador con Android 12 o superior.

## Instalación y ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/WikiMario.git
