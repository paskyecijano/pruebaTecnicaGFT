# GFT-Inditex

## Getting Started

Estas instrucciones le proporcionarán una copia del proyecto en funcionamiento en su máquina local para su desarrollo y
prueba.
propósitos.

### Prerrequisitos

* Docker and Docker-Compose instalados en local

### Instalación

Clone el proyecto del repositorio de GitHub

```
git clone https://github.com/paskyecijano/pruebaTecnicaGFT.git
```

Ejecuta el siguiente comando

```
docker-compose up --build -d
```

Con esto ya tendremos el código del proyecto en un contenedor de docker en funcionamiento.

En este paso, se ha ejecutado el comando "clean install", que ejecuta todas los test del proyecto.
Es posible que vea algo como esto:

![test.png](test.png)

## Base de datos (h2)

| BRAND_ID | START_DATE          | END_DATE            | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURR |
|----------|---------------------|---------------------|------------|------------|----------|-------|------|
| 1        | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1          | 35455      | 0        | 35.50 | EUR  |
| 1        | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2          | 35455      | 1        | 25.45 | EUR  |
| 1        | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 | 3          | 35455      | 1        | 30.50 | EUR  |
| 1        | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4          | 35455      | 1        | 38.95 | EUR  |

Los datos de prueba se almacenan en un archivo llamado squema.sql, que se ejecuta durante el inicio del proyecto,
automatizando el llenado.
de la base de datos.

## Probar la aplicación

Para probar la aplicación, necesitamos hacer una petición GET con la siguiente URL:

```
http://localhost:8080/api/v1/getPrice?date=2020-06-20T16:00:00Z&productId=35455&brandId=1
```

## Arquitectura

Se ha optado por implementar una arquitectura hexagonal en el proyecto, adhiriéndose a los principios SOLID. para ayudar
a comprender la estructura del paquete, explicaré brevemente el contenido de cada capa.

Dentro de la capa de dominio, encontrará interfaces de repositorio y casos de uso, que posteriormente se implementan en
el
capa de aplicación. La capa de infraestructura gestiona las interacciones con la base de datos. La capa apirest
abarca los puntos finales del sistema dentro de su Controlador.

Empleo el patrón Singleton para la inyección de dependencias basada en constructores y el patrón Builder para la
creación de objetos.

Para definir la API, he empleado Open API 3.0, siguiendo el enfoque API First, que implica la utilización de un
Archivo OpenAPI YAML que contiene la especificación API.

El manejo de excepciones se logra a través de ControllerAdvice.

La base de datos en sí está en memoria (H2), y Hibernate se encarga de la creación automática de relaciones entre
tablas.

Además, aprovecho Lombok para optimizar el código y Mapstruct para un mapeo de datos eficiente en todas las capas.

