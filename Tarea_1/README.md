# 🍽️ Restaurante API Collection

Colección de peticiones HTTP para la API **Restaurante**, construida con **Apidog**. Permite gestionar Platos a través de un servidor local.

---

## 🚀 Base URL

```
http://localhost:8080/api/platos
```

> Asegúrate de tener el servidor corriendo localmente antes de ejecutar las peticiones.

---

## 📋 Endpoints

### 1. 🟢 Create Plato

| Campo  | Valor                              |
|--------|------------------------------------|
| Método | `POST`                             |
| URL    | `http://localhost:8080/api/platos` |
| Body   | JSON                               |

**Cuerpo de la petición:**

```json
{
  "nombre": "Pizza Italiana",
  "descripcion": "Pizza con ingredientes frescos",
  "precio": 12.99,
  "disponible": true
}
```

**Descripción:** Crea un nuevo Plato en el sistema enviando sus datos en el cuerpo de la petición.

---

### 2. 📋 Get All Platos

| Campo  | Valor                              |
|--------|------------------------------------|
| Método | `GET`                              |
| URL    | `http://localhost:8080/api/platos` |
| Body   | N/A                                |

**Descripción:** Obtiene la lista completa de todos los Platos registrados en el sistema.

---

### 3. 🔍 Get Plato

| Campo  | Valor                                   |
|--------|-----------------------------------------|
| Método | `GET`                                   |
| URL    | `http://localhost:8080/api/platos/{id}` |
| Body   | N/A                                     |

**Descripción:** Obtiene la información de un Plato específico por su ID. El ejemplo usa el ID `1`.

---

### 4. ✏️ Update Plato

| Campo  | Valor                                   |
|--------|-----------------------------------------|
| Método | `PUT`                                   |
| URL    | `http://localhost:8080/api/platos/{id}` |
| Body   | JSON                                    |

**Cuerpo de la petición:**

```json
{
  "nombre": "Pizza Italiana Actualizada",
  "descripcion": "Pizza con extra queso",
  "precio": 14.99,
  "disponible": true
}
```

**Descripción:** Actualiza los datos de un Plato existente. Se debe incluir el `id` del Plato a modificar junto con los nuevos valores.

---

### 5. 🗑️ Delete Plato

| Campo  | Valor                                   |
|--------|-----------------------------------------|
| Método | `DELETE`                                |
| URL    | `http://localhost:8080/api/platos/{id}` |
| Body   | N/A                                     |

**Descripción:** Elimina un Plato del sistema por su ID. El ejemplo usa el ID `1`.

---

## ⚙️ Configuración

| Parámetro        | Valor   |
|------------------|---------|
| Encode URL       | ✅ Sí   |
| Timeout          | 0 ms    |
| Follow Redirects | ✅ Sí   |
| Max Redirects    | 5       |
| Auth             | Inherit |

---

## 🔧 Requisitos

- **Apidog** (cliente de API)
- Servidor de la API Restaurante corriendo en `localhost:8080`
- PostgreSQL corriendo en `localhost:5432`

---

## 📁 Estructura del proyecto

```
Tarea_1/
├── src/
│   └── main/java/com/example/tarea_1/
│       ├── controller/
│       │   └── PlatoController.java      # Maneja las peticiones HTTP
│       ├── service/
│       │   ├── PlatoService.java         # Interfaz del servicio
│       │   └── Impl/
│       │       └── PlatoServiceImpl.java # Lógica de negocio
│       ├── repository/
│       │   └── PlatoRepository.java      # Acceso a la base de datos
│       ├── domain/entity/
│       │   └── Plato.java                # Entidad JPA
│       └── dto/
│           ├── PlatoRequestDTO.java      # DTO de entrada
│           └── PlatoResponseDTO.java     # DTO de salida
└── README.md                             # Documentación
```

---

## 📄 Licencia

Este proyecto es de uso libre para fines educativos y de prueba.