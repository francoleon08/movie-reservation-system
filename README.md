# Movie Reservation System

## Descripción del Proyecto

El **Movie Reservation System** es un sistema backend para la reservación de películas, desarrollado en Java utilizando Spring Boot y MySQL. Este sistema permite a los usuarios registrarse, iniciar sesión, explorar películas, reservar asientos para horarios específicos y gestionar sus reservaciones. Además, proporciona funcionalidades avanzadas como gestión detallada de películas y horarios, notificaciones, generación de reportes, entre otras.

**Nota:** Este proyecto se encuentra en desarrollo activo. Algunas características mencionadas en este documento pueden estar en proceso de implementación o sujetos a cambios.

## Características Principales

### Autenticación y Autorización de Usuarios

- **Registro y Inicio de Sesión:** Los usuarios pueden registrarse e iniciar sesión.
- **Roles de Usuario:**
  - **Administrador:** Gestiona películas, horarios, usuarios, y genera reportes.
  - **Usuario Regular:** Puede explorar películas, reservar asientos y gestionar sus reservaciones.
- **Verificación de Email:** Se implementa una verificación por correo electrónico durante el registro.
- **Restablecimiento de Contraseña:** Los usuarios pueden restablecer sus contraseñas mediante un correo electrónico de recuperación.
- **Logs de Auditoría:** Registro de actividades críticas como cambios de roles y eliminación de películas.

### Gestión de Películas

- **CRUD de Películas:** Los administradores pueden añadir, actualizar y eliminar películas.
- **Categorías:** Las películas se pueden categorizar por género.
- **Horarios de Proyección:** Los administradores pueden agregar y gestionar horarios para cada película.
- **Idiomas y Subtítulos:** Configuración de idioma y opciones de subtítulos para cada película.
- **Vigencia de Películas:** Gestión de fechas de inicio y fin de proyección para automatizar la cartelera.

### Gestión de Reservaciones

- **Exploración de Películas y Horarios:** Los usuarios pueden consultar películas y horarios disponibles para fechas específicas.
- **Reserva y Pago:** Integración con plataformas de pago para la reserva en línea.
- **Política de Cancelación:** Gestión de cancelaciones con políticas de reembolso específicas.
- **Notificaciones:** Envío de correos electrónicos para confirmar reservas y enviar recordatorios.

### Generación de Reportes y Dashboard

- **Reportes Detallados:** Generación de reportes sobre reservaciones, ingresos, películas más vistas, y tendencias.
- **Exportación de Datos:** Los reportes pueden ser exportados a formatos PDF, CSV, o Excel.

### Escalabilidad y Rendimiento

- **Caché:** Implementación de caché para optimizar el rendimiento en consultas frecuentes.

## Tecnologías Utilizadas

- **Lenguaje de Programación:** Java
- **Framework:** Spring Boot
- **Base de Datos:** MySQL
- **Seguridad:** Spring Security
- **Gestión de Dependencias:** Maven
- **Cache:** Redis

## Instalación y Configuración

### Requisitos Previos

- **Java 17** o superior
- **Maven 3.6** o superior
- **MySQL 8.0** o superior

### Pasos de Instalación

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/francoleon08/movie-reservation-system.git
   cd movie-reservation-system
   ```

2. **Configurar la Base de Datos:**
   - Crear una base de datos en MySQL:
     ```sql
     CREATE DATABASE movie_reservation_db;
     ```
   - Configurar las variables de entorno (archivo .env):
     ```yml     
     {URL_DATABASE}
     {USER_DATABASE}
     {PASSWORD_DATABASE}
     ```

3. **Construir el Proyecto:**
   ```bash
   mvn clean install
   ```

4. **Ejecutar la Aplicación:**
   ```bash
   mvn spring-boot:run
   ```

5. **Acceder a la API:**
   - El servidor se ejecutará en `http://localhost:8080`.


## Estructura del Proyecto

```bash
movie-reservation-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── moviereservation/
│   │   │           ├── controllers/      # Controladores REST
│   │   │           ├── models/           # Entidades JPA
│   │   │           ├── repositories/     # Repositorios Spring Data JPA
│   │   │           ├── services/         # Servicios de Negocio
│   │   │           └── security/         # Configuración de Seguridad
│   │   └── resources/
│   │       ├── application.properties    # Configuración de la aplicación
│   │       └── static/                   # Archivos estáticos (si se usan)
│   └── test/
│       └── java/com/moviereservation/    # Pruebas Unitarias e Integración
│
└── pom.xml                               # Archivo Maven para dependencias
```

## Contribuciones

¡Las contribuciones son bienvenidas! Para contribuir:

1. Realiza un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza los cambios necesarios y realiza commits (`git commit -m 'Añadir nueva funcionalidad'`).
4. Empuja los cambios a tu rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request en GitHub.

## Licencia

Todo el código y los archivos en este repositorio están licenciados bajo la Licencia Pública General de GNU (GNU GPL v3). Consulta el archivo `LICENSE` en la raíz del repositorio para obtener más detalles.
