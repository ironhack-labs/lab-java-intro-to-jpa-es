![logo_ironhack_blue 7](https://user-images.githubusercontent.com/23629340/40541063-a07a0a8a-601a-11e8-91b5-2f13e4e6b441.png)

# LAB | Java Introducción a JPA

## Introducción

Acabamos de aprender cómo crear objetos de entidad y usar repositorios JPA para consultar datos, así que practiquemos un
poco más.

<br>

## Requisitos

1. Haz un fork de este repositorio.
2. Clona este repositorio.
3. Añade a tu instructor y a los calificadores de la clase como colaboradores de tu repositorio. Si no estás seguro de
   quiénes son los calificadores de tu clase, pregunta a tu instructor o consulta la presentación del primer día.
4. En el repositorio, crea un proyecto de Java y añade el código para las siguientes tareas.

## Entrega

Una vez que termines la tarea, envía un enlace URL a tu repositorio o tu solicitud de extracción en el campo de abajo.

<br>

## Instrucciones

Para este trabajo de la tarea, utiliza los datos de la base de datos de aerolíneas del laboratorio 3.02 y
la [Documentación de Spring JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation).

Crea tres clases principales y una clase enum: `FlightBooking`, `Customer` y `Flight`. La clase enum se
llamará `CustomerStatus`.

<br>  

### Clase enum `CustomerStatus`

Crea una clase enum llamada `CustomerStatus` con los siguientes valores:

- `Gold`
- `Silver`
- `None`

<br>  

### Clase `Customer`

Crea una clase llamada `Customer` con las siguientes variables:

- `customerId` (integer): un identificador único generado automáticamente, miembro privado
- `customerName` (string): miembro privado
- `customerStatus` (string): que representa un enum, miembro privado
- `totalCustomerMileage` (integer): miembro privado
- Agrega un constructor vacío a la clase `Customer` para que Hibernate cree nuevas instancias de la clase.
- Agrega un constructor parametrizado a la clase `Customer` que tome `customerName`, `customerStatus`
  y `totalCustomerMileage` como parámetros.
- Agrega métodos getter y setter públicos para cada variable en la clase `Customer`.

<br>  

### Clase `Flight`

Crea una clase llamada `Flight` con las siguientes variables:

- `flightId` (integer): un identificador único generado automáticamente, miembro privado
- `flightNumber` (string): un identificador único, miembro privado
- `aircraft` (string): miembro privado
- `totalAircraftSeats` (integer): miembro privado
- `flightMileage` (integer): miembro privado
- Agrega un constructor vacío a la clase `Flight` para que Hibernate pueda crear nuevas instancias de la clase.
- Agrega un constructor parametrizado a la clase `Flight` que tome `flightNumber`, `aircraft`, `totalAircraftSeats`
  y `flightMileage` como parámetros.
- Agrega métodos getter y setter públicos para cada variable en la clase `Flight`.

<br>  

### Clase `FlightBooking`

Crea una clase llamada `FlightBooking` con las siguientes variables:

- `bookingId` (integer): un identificador único generado automáticamente, miembro privado
- `customerId` (integer): miembro privado
- `flightId` (integer): miembro privado
- Agrega un constructor vacío a la clase `FlightBooking` para que Hibernate pueda crear nuevas instancias de la clase.
- Agrega un constructor parametrizado a la clase `FlightBooking` que tome `customerId` y `flightId` como parámetros.
- Agrega métodos getter y setter públicos para cada variable en la clase `FlightBooking`.
- Agrega restricciones de clave externa en la clase `FlightBooking` para hacer referencia a `customerId` y `flightId` en
  las tablas customers y flights respectivamente.

<br>  

## Tareas

1. Crea todos los repositorios y entidades necesarias para la tabla `Customer`.
2. Crea todos los repositorios y entidades necesarias para la tabla `Flight`.
3. Crea todos los repositorios y entidades necesarias para la tabla `FlightBooking`.
4. Escribe tests para verificar tu capacidad para crear nuevos clientes.
5. Escribe tests para verificar tu capacidad para crear nuevos vuelos.
6. Escribe tests para verificar tu capacidad para encontrar clientes por nombre.
7. Escribe tests para verificar tu capacidad para encontrar clientes por estatus.
8. Escribe tests para verificar tu capacidad para encontrar vuelos por número de vuelo.
9. Escribe tests para verificar tu capacidad para encontrar aviones con nombres que contengan "Boeing".
10. Escribe tests para verificar tu capacidad para encontrar vuelos con una distancia mayor a 500 millas.

<br>  

## FAQs (Preguntas frecuentes)

<br>

<details>  
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">Estoy atascado y no sé cómo resolver el problema o por dónde empezar. ¿Qué debo hacer?</summary>  

 <br> <!-- ✅ -->  

Si estás atascado en tu código y no sabes cómo resolver el problema o por dónde empezar, debes dar un paso atrás y
tratar de formular una pregunta clara y directa sobre el problema específico que enfrentas. El proceso que seguirás al
tratar de definir esta pregunta te ayudará a limitar el problema y a encontrar soluciones potenciales.

Por ejemplo, ¿estás enfrentando un problema porque no entiendes el concepto o estás recibiendo un mensaje de error que
no sabes cómo arreglar? Por lo general, es útil intentar formular el problema de la manera más clara posible, incluyendo
cualquier mensaje de error que estés recibiendo. Esto puede ayudarte a comunicar el problema a otras personas y,
potencialmente, a obtener ayuda de tus compañeros o recursos en línea.

Una vez que tengas una comprensión clara del problema, deberías poder comenzar a trabajar hacia la solución.

</details>  

<br>

<details>    
 <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cómo creo un proyecto de Spring boot?</summary>   

 <br> <!-- ✅ -->    

Spring boot es un framework para crear aplicaciones autónomas y de calidad de producción que son fáciles de lanzar y
ejecutar. La mejor manera de crear un proyecto de Spring boot es usar el sitio web Spring Initializer. El sitio web
proporciona una manera conveniente de generar una estructura básica de proyecto con todas las dependencias y
configuraciones necesarias.

- Paso 1: Ve a [start.spring.io](https://start.spring.io/)
- Paso 2: Elige el tipo de proyecto que desea crear, como Maven o Gradle.
- Paso 3: Selecciona la versión de Spring Boot que deseas utilizar.
- Paso 4: Elige las dependencias que necesitas para su proyecto. Algunas dependencias comunes incluyen web, jpa y
  data-jpa.
- Paso 5: Haz clic en el botón "Generar" para descargar los archivos del proyecto.

Como alternativa, puedes usar un Entorno de Desarrollo Integrado (IDE) como Eclipse o IntelliJ IDEA. Estos IDEs tienen
complementos para crear proyectos de Spring boot, lo que facilita la configuración del entorno y el inicio de la
codificación.

</details>   

<br>

<details>    
 <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Qué es JPA y cómo puedo usarlo en Java?</summary>

 <!-- ✅ -->    

JPA significa Interfaz de Persistencia Java, que es una especificación Java para acceder, persistir y gestionar datos
entre objetos Java y una base de datos relacional. JPA proporciona una interfaz estándar para acceder a bases de datos,
reduciendo la necesidad de código personalizado de acceso a datos y permitiendo una gestión eficiente de las conexiones
a la base de datos.

Para usar JPA en Java, necesitarás incluir las dependencias necesarias en tu proyecto, como la implementación JPA de
Hibernate y crear clases de entidades para representar tus datos. Estas clases de entidades serán anotadas con
anotaciones específicas de JPA, como `@Entity` y `@Id`, para indicar la asignación entre la clase Java y la tabla de la
base de datos.

Aquí hay un fragmento de código para mostrar cómo crear una clase de entidad JPA en Java:

  ```java

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String position;

    // Getters and Setters for the attributes
}
  ```  

</details>   

<br>

<details>    
 <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Cuál es el propósito de usar las anotaciones "@Entity", "@Table" y "@Column" en JPA (Java Persistence API)?</summary>   

<!-- ✅ -->    

Las anotaciones `@Entity`, `@Table` y `@Column` en JPA (Java Persistence API) se utilizan para mapear objetos Java a
tablas de bases de datos relacionales.

`@Entity` se utiliza para marcar una clase como una entidad persistente. Esto significa que las instancias de la clase
pueden almacenarse en una base de datos.

`@Table` se utiliza para definir el nombre de la tabla de base de datos a la que se asignará la entidad.

`@Column` se utiliza para definir las columnas en la tabla que corresponden a los atributos de la entidad.

Aquí hay un ejemplo de cómo usar estas anotaciones:

  ```java

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    //getters and setters
}
  ```

En este ejemplo, la clase `Employee` se marca como una entidad persistente usando la anotación `@Entity`. El nombre de
la tabla de base de datos se define usando la anotación `@Table` como "employee" (empleado). Los
atributos `id`, `firstName` y `lastName` se mapean a columnas en la tabla "employee" (empleado) usando la
anotación `@Column`.

</details>   

<br>

<details>    
 <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">¿Qué es "JpaRepository" y cómo puedo usarlo en Java?</summary>   

 <br> <!-- ✅ -->    

`JpaRepository` es una interfaz de Spring Data que extiende la interfaz `PagingAndSortingRepository`. Proporciona todas
las operaciones básicas **CRUD (Create, Read, Update, Delete)** (Crear, Leer, Actualizar, Eliminar) y métodos
adicionales para trabajar con **JPA (Java Persistence API)** para interactuar con la base de datos.

Para usar JpaRepository en su proyecto, siga los siguientes pasos:

Paso 1: Importa las bibliotecas necesarias

  ```java
  import org.springframework.data.jpa.repository.JpaRepository;
  ```

Paso 2: Crea una interfaz que extienda `JpaRepository`

  ```java
  public interface MyRepository extends JpaRepository<MyEntity, Long> {

}
  ```

**Nota**: En el código anterior, `MyEntity` es la clase de entidad con la que desea interactuar y Long es el tipo de la
clave primaria de `MyEntity`.

Paso 3: Inyecta la interfaz en la clase donde la desees usar.

  ```java

@Autowired
private MyRepository myRepository;
  ```

Paso 4: Ahora puedes usar los métodos proporcionados por `JpaRepository` para interactuar con la base de datos, por
ejemplo:

  ```java
  MyEntity myEntity = new MyEntity();
  myRepository.

save(myEntity);
  ```

Con los pasos anteriores, ahora puedes usar `JpaRepository` para interactuar con la base de datos en tu proyecto de
Java.

</details>   

<br>

<details>
  <summary style="font-size: 16px; cursor: pointer; outline: none; font-weight: bold;">No puedo enviar cambios a mi repositorio. ¿Qué debo hacer?</summary>

  <!-- ✅ -->

Si no puedes enviar cambios a tu repositorio, aquí hay algunos pasos que puedes seguir:

1. Verifica tu conexión a internet: Asegúrate de que tu conexión a internet sea estable y funcione.
2. Verifica la URL de tu repositorio: Asegúrate de estar usando la URL correcta de tu repositorio para enviar tus
   cambios.
3. Revisa tus credenciales de Git: Asegúrate de que tus credenciales de Git estén actualizadas y correctas. Puedes
   revisar tus credenciales usando el siguiente comando:

  ```bash
  git config --list
  ```

4. Actualiza tu repositorio local: Antes de enviar cambios, asegúrate de que tu repositorio local esté actualizado con
   el repositorio remoto. Puedes actualizar tu repositorio local usando el siguiente comando:

  ```bash
  git fetch origin
  ```

5. Revisa posibles conflictos: Si hay conflictos entre tu repositorio local y el repositorio remoto, resuélvelos antes
   de enviar cambios.
6. Envía cambios: Una vez que hayas resuelto los conflictos y actualizado tu repositorio local, puedes intentar enviar
   cambios nuevamente usando el siguiente comando:

  ```bash
  git push origin <branch_name>
  ```

</details>