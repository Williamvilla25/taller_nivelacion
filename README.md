# taller_nivelacion
----------------------------------------------------------------------
# Parte Teorica
### GIT:

### 1. ¿Que es un repositorio en Git y cómo se diferencia de un proyecto “normal”?
Un repositorio en Git es un directorio que contiene todos los archivos del proyecto junto con una carpeta oculta `.git`. A diferencia de un proyecto "normal", un repositorio rastrea y almacena todo el historial de cambios, versiones anteriores, ramas y autores a lo largo del tiempo.

### 2. ¿Cuales son las tres áreas principales de Git y que papel cumple cada una?
* **Working Directory (Directorio de trabajo):** Es el espacio local donde editas, creas y eliminas los archivos de tu proyecto activamente.
* **Staging Area / Index (Área de preparación):** Es un paso intermedio donde seleccionas de manera precisa qué cambios específicos van a formar parte del próximo commit.
* **Repository (Repositorio / .git):** Es la base de datos donde Git guarda permanentemente los cambios en forma de snapshots (commits) dentro del historial.

### 3. ¿Cómo representa Git los cambios internamente?
Git almacena la información mediante un sistema de objetos direccionables por contenido mediante hashes SHA-1/SHA-256:
* **Blob:** Almacena el contenido crudo de un archivo (sin su nombre ni permisos).
* **Tree:** Representa un directorio; mapea nombres de archivos y carpetas con sus respectivos *blobs* u otros *trees*.
* **Commit:** Un puntero a un *tree* superior que incluye metadatos (autor, fecha, mensaje) y el hash del commit padre.
* **Tag:** Un puntero permanente asignado a un commit específico, utilizado generalmente para marcar versiones (ej. `v1.0.0`).

### 4. ¿Cómo se crea un commit y qué información almacena un objeto commit?
Se crea preparando los cambios con `git add` y confirmándolos con `git commit -m "mensaje"`. 

### 5. ¿Cuál es la diferencia entre `git pull` y `git fetch`?

| Característica | `git fetch` | `git pull` |
| :--- | :--- | :--- |
| **Acción principal** | Solo descarga los cambios del repositorio remoto a la copia local. | Descarga los cambios y los combina inmediatamente con tu rama actual. |
| **Modificación de archivos** | **No** altera tu código ni tu directorio de trabajo. | **Sí** actualiza tu código local integrando los nuevos datos. |
| **Fórmula / Composición** | Solo obtiene datos (`fetch`). | Es la combinación de: `git fetch` + `git merge`. |
| **Seguridad / Control** | **Alta**: permite revisar los cambios antes de fusionarlos. | **Media**: puede generar conflictos de fusión (*merge conflicts*) de inmediato. |