# Proy_Pre_Java_NSM

Este proyecto fue desarrollado por **Nicolás Méndez** como parte del programa **Talento Tech** en la cursada **Back_End_Java**.

## Descripción

El sistema permite la gestión de productos a través de un menú interactivo por consola. Está implementado en **Java 21**.

## Funcionalidades

- Crear producto
- Listar productos
- Modificar producto
- Eliminar producto
- Crear pedido *(en desarrollo)*
- Listar pedidos *(en desarrollo)*

## Tecnologías utilizadas

- **Lenguaje:** Java 21
- **IDE:** Visual Studio Code (recomendado)

## Estructura principal

- `Producto`: clase que representa un producto con `id`, `nombre` y `precio`.
- `Main`: clase principal con menú interactivo y funcionalidades CRUD.
- Validaciones de entrada para asegurar datos consistentes (ID únicos, precios válidos, etc.)

## Cómo ejecutar

1. Clonar el repositorio.
2. Abrir en un entorno compatible con Java 21.
3. Compilar y ejecutar la clase `Main`.

```bash
javac Main.java
java Main
