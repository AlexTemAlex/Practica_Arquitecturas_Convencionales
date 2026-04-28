# 📦 Sistema de Inventario - Evolución de Código Espagueti a MVC

## 📌 Descripción

Este repositorio contiene la evolución de un sistema de inventario desarrollado en Java, pasando de una implementación inicial con **código espagueti** a una arquitectura basada en el patrón **Modelo Vista Controlador (MVC)** utilizando **Spring Boot** y **Thymeleaf**.

El objetivo del proyecto es demostrar la mejora en la organización, mantenibilidad y escalabilidad del software mediante buenas prácticas de desarrollo.

---

## 🏗 Estructura del Proyecto

El repositorio contiene dos proyectos principales:

```
/InventarioEspaguetiCLI   → Versión inicial (código espagueti en consola)
/inventarioMVC            → Versión refactorizada con Spring Boot MVC
```

---

## 🚀 Tecnologías utilizadas

* Java
* Spring Boot
* Spring Web
* Thymeleaf
* Maven

---

## 🧪 Cómo ejecutar el proyecto

### 🔹 1. Ejecutar versión CLI (Código Espagueti)

```bash
cd InventarioEspaguetiCLI
mvn clean compile
mvn exec:java -Dexec.mainClass="com.mycompany.inventarioespagueticli.InventarioEspaguetiCLI"
```

---

### 🔹 2. Ejecutar versión MVC (Spring Boot)

```bash
cd inventarioMVC
./mvnw spring-boot:run
```

Luego abrir en el navegador:

```
http://localhost:8080
```

---

## ⚙️ Funcionalidades

### 📌 Versión CLI

* Agregar productos
* Listar inventario
* Vender productos
* Eliminar productos
* Reportes básicos

### 📌 Versión MVC

* Visualización de productos en interfaz web
* Registro de productos
* Venta de productos
* Eliminación de productos

---

## 🔄 Evolución del sistema

| Característica | Código Espagueti  | MVC con Spring Boot  |
| -------------- | ----------------- | -------------------- |
| Arquitectura   | No definida       | MVC                  |
| Organización   | Todo en una clase | Separación por capas |
| Escalabilidad  | Baja              | Alta                 |
| Mantenibilidad | Difícil           | Fácil                |
| Interfaz       | Consola           | Web                  |

---

## 🧠 Conceptos aplicados

* Separación de responsabilidades
* Arquitectura en capas
* Patrón MVC
* Refactorización de código
* Manejo básico de errores
* Uso de frameworks modernos

---

## ⚠️ Limitaciones actuales

* Uso de índices en lugar de IDs
* Persistencia en memoria (sin base de datos)
* Manejo de errores básico
* No se utilizan DTOs

---

## 🔮 Mejoras futuras

* Integración con base de datos (MySQL/PostgreSQL)
* Uso de JPA/Hibernate
* Implementación de DTOs
* Manejo global de excepciones
* Arquitectura hexagonal o DDD

