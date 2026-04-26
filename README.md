# GestionEmpleados

Aplicacion de consola en Java para gestionar empleados (alta, listado, busqueda, modificacion y eliminacion) usando una estructura tipo MVC.

## Tecnologias

- Java
- Maven

## Estructura del proyecto

```text
src/main/java/
  controlador/
    ControladorEmpleados.java
  modelo/
    Empleado.java
    Programador.java
    Diseñador.java
    Salario.java
  util/
    EntradaDatos.java
    EmpleadoException.java
  vista/
    VistaConsola.java
```

## Arquitectura (resumen)

- `vista`: Interaccion con el usuario por consola.
- `controlador`: Gestion de la lista de empleados y operaciones CRUD.
- `modelo`: Entidades de dominio (empleados y salario).
- `util`: Funciones auxiliares (lectura validada y excepciones de negocio).

## Funcionalidades

Desde el menu principal se puede:

1. Dar de alta un empleado.
2. Listar empleados.
3. Buscar empleado por DNI.
4. Modificar datos de empleado.
5. Eliminar empleado por DNI.

## Reglas de validacion actuales

En `EntradaDatos`:

- `leerString(...)`: no permite texto vacio.
- `leerDouble(mensaje, minimo, maximo)`: obliga a introducir un decimal dentro de rango.
- `leerEntero(mensaje, minimo, maximo)`: obliga a introducir un entero dentro de rango.

En `VistaConsola` se estan usando, por ejemplo:

- Salario base: `1200` a `4000`.
- Complementos: `0` a `2000`.
- Opcion de menu: `0` a `5`.
- Tipo de empleado: `1` a `2`.

## Compilar y ejecutar

### 1) Compilar

```bash
mvn clean compile
```

### 2) Ejecutar

```bash
java -cp target/classes vista.VistaConsola
```

## Clases principales

### `VistaConsola`

- Punto de entrada (`main`).
- Muestra el menu.
- Solicita datos y delega la logica al controlador.

### `ControladorEmpleados`

- Mantiene una lista en memoria de empleados.
- Permite alta, busqueda, listado y eliminacion.

## Documentacion detallada por capa

### Vista: `vista/VistaConsola.java`

Responsabilidad:

- Actua como interfaz de usuario por consola.
- Presenta el menu principal y coordina el flujo de acciones.
- Pide datos al usuario mediante `EntradaDatos` y llama al controlador.

Metodos relevantes:

- `main(String[] args)`: crea la vista y arranca la aplicacion.
- `mostrarMenu()`: bucle principal del menu hasta elegir salir.
- `menuAlta()`: recoge datos y crea `Programador` o `Diseñador`.
- `listar()`: muestra todos los empleados registrados.
- `buscar()`: localiza un empleado por DNI.
- `modificar()`: actualiza nombre, salario y dato especifico del tipo.
- `eliminar()`: elimina un empleado por DNI.

### Controlador: `controlador/ControladorEmpleados.java`

Responsabilidad:

- Centraliza la logica de gestion de empleados en memoria.
- Evita duplicados por DNI en el alta.
- Proporciona operaciones de consulta y borrado.

Estructura y metodos:

- `ArrayList<Empleado> listaEmpleados`: almacenamiento temporal de empleados.
- `obtenerEmpleadoPorDni(String dni)`: devuelve el empleado o `null`.
- `alatEmpleado(Empleado m)`: inserta si el DNI no existe y devuelve `true/false`.
- `listaEmpleados()`: expone la coleccion para listado.
- `eliminarEmpleado(String dni)`: intenta eliminar por DNI y devuelve `true/false`.

### Util: `util/EntradaDatos.java` y `util/EmpleadoException.java`

`EntradaDatos` (validacion de entrada):

- `leerString(String mensaje)`: obliga a introducir texto no vacio.
- `leerDouble(String mensaje, double minimo, double maximo)`: valida decimal en rango.
- `leerEntero(String mensaje, int minimo, int maximo)`: valida entero en rango.

`EmpleadoException` (excepcion de negocio):

- Clase de excepcion personalizada para reglas del dominio de empleados.
- Permite lanzar mensajes claros cuando una operacion de negocio no es valida.
- Actualmente esta disponible en el proyecto para integrarla en el controlador cuando se requiera manejo por excepciones.

### `Empleado` / `Programador` / `Diseñador`

- `Empleado` es la clase base con `dni`, `nombre` y `salario`.
- `Programador` agrega `lenguajePrincipal`.
- `Diseñador` agrega `herramientaDisenio`.

### `Salario`

- Guarda `salarioBase` y `complementos`.
- Calcula salario total con `calcularSalarioTotal()`.

## Notas

- La informacion se guarda solo en memoria durante la ejecucion.
- No hay persistencia en base de datos o archivo.
- `EmpleadoException` esta preparada para manejar reglas de negocio con excepciones cuando se requiera en la logica del controlador.
