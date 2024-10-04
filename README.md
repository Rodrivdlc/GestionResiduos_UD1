# Gestión de Residuos - App

## Participantes
- Hugo SANCHEZ
- Jose Antonio OYONO
- Jose Daniel MARTIN
- Daniel Andres MORENO REY
- Rodrigo ROJAS REDONDO

## Enlace al Repositorio
Repositorio en GitHub: https://github.com/Rodrivdlc/GestionResiduos_UD1

## Descripción
Este proyecto es una aplicación de Android que permite a los usuarios gestionar sus residuos mediante recordatorios y ver estadísticas personales. La aplicación incluye funcionalidades como añadir recordatorios, consultar estadísticas de residuos a lo largo del tiempo, y seleccionar puntos de recogida específicos.

## Credenciales de Usuario
(Si aplica, puedes eliminar esta sección si no es necesaria en tu aplicación).

- Usuario: demo
- Contraseña: demo

## Ubicación del Código
El código de este proyecto se encuentra en la siguiente ruta: /app/src/main/java/com/example/gestionresiduos_ud1/


## Componentes Principales

### `MainComposeActivity.kt`
**Clase MainComposeActivity:**
- Es una subclase de `ComponentActivity`.
- Configura la navegación entre las diferentes pantallas usando Jetpack Compose.
- Define el flujo principal de la aplicación, dirigiendo al usuario desde la pantalla de entrada hasta el menú principal.

### `NameInputScreen.kt`
**Función NameInputScreen:**
- Es una función composable que define la UI donde el usuario ingresa su nombre.
- Navega a `MenuScreen` después de que se haya ingresado el nombre correctamente.

### `MenuScreen.kt`
**Función MenuScreen:**
- Muestra un saludo personalizado basado en el nombre del usuario.
- Incluye botones para acceder a la pantalla de añadir recordatorio y ver estadísticas personales de residuos.

### `AddReminderActivity.kt`
**Clase AddReminderActivity:**
- Es una subclase de `AppCompatActivity`.
- Permite al usuario añadir un recordatorio con los detalles: descripción, hora de inicio, hora de fin y el punto de recogida.
- Gestiona la interacción del usuario con los campos de entrada de datos y guarda los recordatorios.

### `CalendarActivity.kt`
**Clase CalendarActivity:**
- Muestra un calendario interactivo.
- Permite al usuario seleccionar una fecha para ver los recordatorios correspondientes.
- Incluye botones para añadir o mostrar recordatorios ya creados.

### `ShowRemindersActivity.kt`
**Clase ShowRemindersActivity:**
- Muestra una lista de todos los recordatorios guardados.
- Permite navegar a través de los recordatorios o volver a la pantalla anterior.

### `ReminderManager.kt`
**Clase ReminderManager:**
- Clase responsable de gestionar los recordatorios de la aplicación.
- Incluye métodos para guardar, obtener y filtrar recordatorios, facilitando su uso en las distintas pantallas.

### `PersonalWasteStatisticsScreen.kt`
**Función PersonalWasteStatisticsScreen:**
- Muestra estadísticas personalizadas de residuos.
- Permite al usuario seleccionar diferentes periodos de tiempo (semanal, mensual, anual) para ver las estadísticas correspondientes.

### `WeeklyStats.kt`, `MonthlyStats.kt`, `YearlyStats.kt`
**Funciones WeeklyStats, MonthlyStats, YearlyStats:**
- Estas funciones composables dibujan gráficos de barras mostrando estadísticas de residuos según el periodo seleccionado.
- Utilizan el componente `SimpleBarChart` para representar gráficamente los datos.

### `SimpleBarChart.kt`
**Función SimpleBarChart:**
- Define un gráfico de barras simple basado en los datos de residuos proporcionados por el usuario.

### `PuntosRecogida.kt`
**Clase PuntosRecogida:**
- Muestra en la interfaz de usuario los diferentes puntos de recogida.
- Los usuarios pueden seleccionar un punto de recogida para cada recordatorio.

### `BackButton.kt`
**Componente BackButton:**
- Componente reutilizable que permite la navegación a la pantalla anterior desde cualquier pantalla de Compose.

## Dependencias

El proyecto utiliza las siguientes dependencias:

- Jetpack Compose
- Material3
- Navigation
- Play Services Maps
- ConstraintLayout
- ViewBinding
- Filament
- JUnit

## Configuración del Proyecto

### `settings.gradle.kts`
- Configura los repositorios y el nombre del proyecto.

### `build.gradle.kts`
- Archivo de configuración a nivel de proyecto que define los detalles de compilación y repositorios globales.

### `app/build.gradle.kts`
- Archivo de configuración a nivel de módulo que incluye las dependencias de la aplicación, versiones mínimas de SDK, y configuraciones específicas de Android.

## Cómo Ejecutar

1. Clona el repositorio.
2. Abre el proyecto en Android Studio.
3. Sincroniza las dependencias de Gradle.
4. Ejecuta la aplicación en un dispositivo o emulador Android.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o un pull request para discutir cualquier cambio.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
