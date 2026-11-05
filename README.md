# Sistema de Gestión de Calificaciones

Aplicación desarrollada en Java con Spring Boot para administrar alumnos, materias y sus respectivas calificaciones mediante una API REST. Utiliza MySQL como sistema de gestión de base de datos.

## Tecnologías utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL 8.0**
- **Maven**
- **Swagger / OpenAPI** (si está configurado en el proyecto)

## Base de datos

El proyecto utiliza una base de datos llamada `calificaciones_db`, que contiene las siguientes tablas:

| Tabla | Descripción |
|---|---|
| `alumnos` | Almacena la información de los alumnos. |
| `materias` | Almacena las materias disponibles. |
| `calificaciones` | Registra las calificaciones de los alumnos en cada materia. |

### Relaciones

- Un alumno puede tener varias calificaciones.
- Una materia puede estar asociada a varias calificaciones.
- Cada calificación puede estar relacionada con un alumno y una materia.

### Importar la base de datos

En el repositorio se incluye el archivo `calificaciones_db.sql`, que permite crear e inicializar la base de datos.

**Con MySQL Workbench:**

1. Abre MySQL Workbench y conéctate a tu servidor.
2. Selecciona **File → Open SQL Script**.
3. Abre el archivo `calificaciones_db.sql`.
4. Ejecuta el script con el botón del rayo.
5. Comprueba que se haya creado la base de datos `calificaciones_db`.

> **Importante:** El script contiene los registros incluidos en el respaldo compartido: 61 alumnos, 28 materias y 74 calificaciones. Al ejecutarlo, las tablas existentes con esos nombres se eliminan y se vuelven a crear.

## Configuración del proyecto

Configura la conexión a MySQL en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/calificaciones_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

Sustituye `TU_USUARIO` y `TU_CONTRASEÑA` por las credenciales de tu servidor MySQL.

## Instalación y ejecución

1. Clona el repositorio:

```bash
git clone https://github.com/EnriBr14/Sistema-de-gesti-n-de-calificaciones.git
```

2. Entra al directorio del proyecto:

```bash
cd Sistema-de-gesti-n-de-calificaciones
```

3. Importa la base de datos `calificaciones_db` en MySQL.
4. Configura las credenciales de conexión.
5. Ejecuta la aplicación con Maven:

```bash
mvn spring-boot:run
```

También puedes abrir el proyecto desde un IDE compatible con Maven, como IntelliJ IDEA, Eclipse o Spring Tool Suite.

## Funcionalidades principales

- Administración de alumnos.
- Administración de materias.
- Registro y consulta de calificaciones.
- Actualización de información.
- Eliminación de registros.
- Consulta de información mediante endpoints REST.

## Estructura general

La organización puede variar según los paquetes existentes en el proyecto. De forma general, se contemplan las siguientes capas:

- **Modelo:** representa las entidades del sistema.
- **Repositorio:** permite interactuar con la base de datos.
- **Controlador:** expone los endpoints de la API REST.
- **Configuración:** contiene los parámetros de conexión y configuración de Spring Boot.

## Autor

**EnriBr14**

Repositorio: [Sistema de Gestión de Calificaciones](https://github.com/EnriBr14/Sistema-de-gesti-n-de-calificaciones)
