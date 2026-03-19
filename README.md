# 📚 Book Club

Aplicación web full stack para crear y gestionar clubs de lectura con IA. Los usuarios buscan un libro en tiempo real, eligen la duración del club y reciben un plan de lectura semanal automático. Cada semana, la IA genera preguntas de debate personalizadas para guiar la discusión del grupo.

## Demo

> _Próximamente_

---

## Funcionalidades

- **Búsqueda de libros en tiempo real** conectada a Google Books API (título, autor, portada, páginas, descripción)
- **Creación de clubs** con plan de lectura generado automáticamente según la duración elegida _(en desarrollo)_
- **Preguntas de debate con IA** por semana, generadas con la API de Anthropic (Claude) _(en desarrollo)_
- **Seguimiento de progreso** semanal con estadísticas de páginas leídas _(en desarrollo)_
- Autenticación de usuarios con JWT _(en desarrollo)_

---

## Stack tecnológico

**Backend**
- Java 21 + Spring Boot 3
- Spring Data JPA + Hibernate
- PostgreSQL
- Spring Security + JWT _(en desarrollo)_
- RestTemplate (consumo de APIs externas)

**Frontend**
- React 19 + Vite
- React Router
- Axios

**APIs externas**
- [Google Books API](https://developers.google.com/books) — búsqueda de libros en tiempo real
- [Anthropic API](https://www.anthropic.com) — generación de preguntas de debate con Claude _(en desarrollo)_

---

## Arquitectura

```
frontend (React + Vite)  →  backend (Spring Boot)  →  PostgreSQL
                                    ↓
                           Google Books API
                           Anthropic API (Claude)
```

---

## Estructura del proyecto

```
reading-club-app/
├── src/main/java/com/maria/reading_club_app/
│   ├── client/
│   │   └── GoogleBooksResponse.java
│   ├── config/
│   │   ├── AppConfig.java
│   │   └── CorsConfig.java
│   ├── controller/
│   │   └── BookController.java
│   ├── dto/
│   │   └── BookDTO.java
│   └── service/
│       └── BookSearchService.java
├── frontend/
│   └── src/
│       ├── components/
│       │   ├── BookSearch.jsx
│       │   └── BookSearch.css
│       ├── services/
│       │   └── bookService.js
│       ├── App.jsx
│       └── App.css
└── README.md
```

---

## Instalación y ejecución local

### Requisitos previos
- Java 21+
- Node.js 18+
- PostgreSQL _(necesario para futuras features)_

### Backend

1. Clona el repositorio
   ```bash
   git clone https://github.com/maria-llamazares/reading-club-app.git
   cd reading-club-app
   ```

2. Copia el archivo de configuración
   ```bash
   cp src/main/resources/application.properties.example src/main/resources/application.properties
   ```

3. Edita `application.properties`:
   ```properties
   google.books.api.key=TU_API_KEY
   ```

4. Arranca el servidor desde IntelliJ o con:
   ```bash
   .\mvnw.cmd spring-boot:run
   ```
   El backend queda en `http://localhost:8080`

### Frontend

```bash
cd frontend
npm install
npm run dev
```
El frontend queda en `http://localhost:5173`

---

## Endpoints disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/books/search?q={query}` | Buscar libros en Google Books |

### Próximos endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/clubs` | Crear un nuevo club |
| GET | `/api/clubs` | Listar clubs del usuario |
| GET | `/api/clubs/{id}` | Detalle de un club |
| PATCH | `/api/clubs/{id}/weeks/{n}/complete` | Marcar semana como leída |
| GET | `/api/clubs/{id}/weeks/{n}/questions` | Obtener preguntas de debate con IA |

---

## Variables de entorno necesarias

| Variable | Descripción |
|----------|-------------|
| `google.books.api.key` | API key de Google Cloud (Books API) |
| `spring.datasource.url` | URL de conexión a PostgreSQL _(próximamente)_ |
| `spring.datasource.username` | Usuario de la base de datos _(próximamente)_ |
| `spring.datasource.password` | Contraseña de la base de datos _(próximamente)_ |
| `anthropic.api.key` | API key de Anthropic _(próximamente)_ |

---

## Roadmap

- [x] Búsqueda de libros en tiempo real con Google Books API
- [x] UI cálida y literaria con React + Vite
- [x] Configuración CORS entre frontend y backend
- [ ] Base de datos PostgreSQL
- [ ] Creación de clubs con plan de lectura automático
- [ ] Seguimiento de progreso semanal
- [ ] Generación de preguntas con IA (Anthropic Claude)
- [ ] Autenticación con JWT
- [ ] Deploy en Railway (backend) + Vercel (frontend)
- [ ] CI/CD con GitHub Actions + SonarCloud

---

## Autor

**María** — [github.com/maria-llamazares](https://github.com/maria-llamazares)
