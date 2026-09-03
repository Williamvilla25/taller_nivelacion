# taller_nivelacion
----------------------------------------------------------------------
# Parte Teorica
## GIT:

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

### 6. ¿Qué es un branch (rama) en Git y cómo Git gestiona los punteros a commits?
Una rama es simplemente un puntero móvil ligero que apunta a un commit en particular. Git gestiona un puntero especial llamado **HEAD**, el cual indica la rama activa actual, cuando realizas un nuevo commit, el puntero de la rama activa se mueve automáticamente hacia adelante apuntando al nuevo commit.

### 7. ¿Cómo se realiza un merge y qué conflictos pueden surgir? ¿Cómo se resuelven?
Un merge se realiza ejecutando `git merge <nombre-de-rama>` para integrar los cambios de otra rama en la actual. 

* **Conflictos:** Surgen cuando la misma línea de un archivo fue modificada de formas distintas en ambas ramas.
* **Resolución:** Git detiene la fusión y marca las líneas con conflicto (`<<<<<<<`, `=======`, `>>>>>>>`). Debes abrir el archivo, decidir manualmente qué código conservar, guardar el archivo, prepararlo con `git add` y finalizar el proceso ejecutando `git commit`.

### 8. ¿Cómo funciona el área de staging (git add) y qué pasa si omito este paso?
El área de staging es un borrador intermedio donde preparas explícitamente qué cambios deseas incluir en el próximo commit, al ejecutar `git add`, copias el estado actual de los archivos seleccionados hacia este espacio. Si omites este paso e intentas hacer un commit directamente (sin el flag `-a`), Git no incluirá los nuevos archivos o modificaciones en el historial, dejando el commit vacío o sin registrar los últimos cambios realizados.

### 9. ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos?
Es un archivo de texto plano ubicado en la raíz del proyecto que especifica reglas sobre qué archivos o carpetas debe ignorar Git por completo, los elementos listados en él (como variables de entorno, dependencias de `.node_modules` o archivos `.class` compilados) nunca aparecerán como no rastreados (*untracked*) ni se incluirán accidentalmente en los commits.

### 10. ¿Cuál es la diferencia entre un “commit amend” (--amend) y un nuevo commit?
* **Commit Amend (`git commit --amend`):** Modifica el commit más reciente reemplazándolo por uno nuevo con los cambios actuales del staging y/o un mensaje actualizado, mantiene el historial limpio sin crear un commit adicional.
* **Nuevo Commit:** Crea un punto de control independiente con un nuevo hash SHA que se suma secuencialmente encima de la cadena de commits existente.

### 11. ¿Cómo se utiliza git stash y en qué escenarios es útil?
`git stash` guarda temporalmente las modificaciones locales no confirmadas (*dirty working directory*) en una pila interna de almacenamiento y limpia el directorio de trabajo para dejarlo en el estado del último commit.
* **Escenario útil:** Cuando estás a mitad de una tarea y necesitas cambiar urgentemente de rama o descargar cambios nuevos sin perder el trabajo que aún no está listo para un commit. Para recuperar los cambios guardados se utiliza `git stash pop`.

### 12. ¿Qué mecanismos ofrece Git para deshacer cambios?
* **`git checkout`:** Permite descartar cambios no guardados en archivos del *Working Directory* o cambiar de rama.
* **`git reset`:** Mueve el puntero de la rama activa hacia un commit anterior. Puede ser `--soft` (mantiene los cambios en staging), `--mixed` (mantiene los cambios en el directorio de trabajo) o `--hard` (elimina permanentemente todos los cambios posteriores).
* **`git revert`:** Crea un **nuevo commit** que aplica exactamente los cambios opuestos a un commit previo. Es la forma más segura de deshacer cambios en ramas compartidas o remotas sin alterar el historial existente.

### 13. ¿Cómo funciona la configuración de remotos (origin, upstream) y qué comandos uso para gestión de forks?
Los remotos son punteros con aliases que apuntan a repositorios alojados en la nube o servidores externos:
* **`origin`:** Alias por defecto para tu propio repositorio (tu copia o tu fork).
* **`upstream`:** Alias convencional que apunta al repositorio original del cual hiciste el *fork*.

**Comandos para gestión de forks:**
* `git remote add upstream <URL>`: Vincula tu copia local con el repositorio fuente original.
* `git fetch upstream`: Descarga los últimos cambios del repositorio fuente.
* `git merge upstream/main`: Sincroniza tu rama local con la rama principal del repositorio original.

### 14. ¿Cómo puedo inspeccionar el historial de commits?
* **`git log`:** Muestra la lista cronológica de todos los commits realizados en la rama actual (autores, fechas, hashes y mensajes).
* **`git diff`:** Muestra las diferencias línea por línea entre los archivos en tu *Working Directory*, el área de *Staging* o entre dos commits/ramas diferentes.
* **`git show <commit_hash>`:** Detalla toda la información y los cambios específicos introducidos en un commit en particular.

-----------------------------------------------------------------------

## Programacion
