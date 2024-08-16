# Alojamientos
Página web para el registro y visuallización de alojamientos turísticos.

La aplicación utiliza el framework Spring MVC. Se hace uso de un controller el cual es el encargado de responder las peticiones del front end.
Los endpoints necesarios para el funcionamiento de la página fueron testeados con Postman y son los siguientes:  
- `/buscar` *Trae un alojamiento a partir de un input que se le pase en el front*   
- `/registrar` Recibe una entidad alojamiento (un objeto) y la agrega a la base de datos mediante un servicio.    
- `/modificar/{idAlojamiento}` Trae una entidad alojamiento del repositorio y lo carga en el Model para poder ser usado por un formulario en el front end.  
- `/eliminar/{idAlojamiento}` Elimina una entidad del repositorio.

El diseño del front end se realizo con el framework Boostrap y la visualización de los datos del backend con el motor de plantillas Thymeleaf.

Se hizo uso de las dependencias **Spring Web**, **Spring Data JPA**, **Lombok**, **Thymeleaf**, **MySQL Driver**.

Tecnologías usadas: 
> Spring Boot, Hibernate, MySQL, Thymeleaf, Bootstrap.

# Demo
[Link al proyecto en deploy](https://alojamientos.onrender.com/) 
Nota: Debido a que se encuentra en un hosting gratuito, puede demorar **un minuto** en cargar la primera vez

![](https://github.com/soySantiagoBruno/media-repo/blob/main/alojamientos%20uso.gif)
