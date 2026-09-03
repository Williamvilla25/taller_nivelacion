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

----------------------------------------------------------------------
## PROGRAMACIÓN:

 ### 15. ¿Cuáles son los tipos de datos primitivos en Java?
En Java existen 8 tipos de datos primitivos categorizados según la naturaleza del valor que almacenan:

| Categoría | Tipo de Dato | Tamaño | Rango / Valor por defecto |
| :--- | :--- | :--- | :--- |
| **Enteros** | `byte` | 1 byte | -128 a 127 |
| | `short` | 2 bytes | -32,768 a 32,767 |
| | `int` | 4 bytes | -2,147,483,648 a 2,147,483,647 |
| | `long` | 8 bytes | -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807 |
| **Decimales** | `float` | 4 bytes | Números de precisión simple |
| | `double` | 8 bytes | Números de precisión doble |
| **Lógico** | `boolean` | 1 bit | `true` o `false` |
| **Carácter** | `char` | 2 bytes | Caracteres individuales en formato Unicode (`'a'`, `'1'`) |

  ### 16. ¿Cómo funcionan las estructuras de control de flujo como if, else, switch y bucles en Java?
  Las estructuras de control dictan la secuencia de ejecución del código:

* **Estructuras Condicionales:**
  * `if / else`: Evalúa una condición booleana. Si es verdadera (`true`), ejecuta un bloque de código; si es falsa (`false`), ejecuta opcionalmente el bloque `else`.
  * `switch`: Evalúa una variable y la compara contra múltiples casos (`case`). Permite seleccionar uno entre varios caminos de ejecución de forma más limpia que múltiples `if/else`.

* **Estructuras Cíclicas (Bucles):**
  * `for`: Ejecuta un bloque de código un número conocido de veces mediante una variable de control, condición e incremento.
  * `while`: Repite un bloque de código **mientras** una condición booleana se mantenga verdadera. La condición se evalúa antes de cada iteración.
  * `do-while`: Similar a `while`, pero garantiza que el bloque se ejecute **al menos una vez**, ya que la condición se evalúa al final del ciclo.

  ### 17. ¿Por qué es importante usar nombres significativos para variables y métodos?
  Usar nombres claros y descriptivos mejora radicalmente la mantenibilidad, legibilidad y calidad del software. Permite que el código sea autodocumentado, reduciendo errores lógicos y facilitando que tú u otros desarrolladores entiendan la intención del programa sin necesidad de agregar comentarios excesivos (por ejemplo, es mejor usar `calcularSalarioNeto()` que `calc()`).

  ### 18. ¿Qué es la Programación Orientada a Objetos (POO)?
  La Programación Orientada a Objetos es un paradigma de programación basado en el concepto de **objetos**, los cuales representan entidades del mundo real. Estos objetos combinan **atributos** (datos/estado) y **métodos** (comportamientos/acciones), interactuando entre sí para estructurar aplicaciones modulares y reutilizables.

  ### 19. ¿Cuáles son los cuatro pilares de la Programación Orientada a Objetos?
  1. **Encapsulamiento:** Oculta los datos internos de un objeto protegiéndolos del acceso no autorizado y exponiendo únicamente lo necesario mediante métodos públicos (getters/setters).
  2. **Abstracción:** Oculta la complejidad interna de los sistemas, mostrando solo las características esenciales para la interacción con el usuario o desarrollador.
  3. **Herencia:** Permite que una clase nueva (hija) derive y reutilice atributos y métodos de una clase existente (padre).
  4. **Polimorfismo:** Permite que objetos de diferentes clases respondan al mismo mensaje o llamado de método de formas distintas según su implementación.

  ### 20. ¿Qué es la herencia en POO y cómo se utiliza en Java?
  La herencia es un mecanismo fundamental de la Programación Orientada a Objetos que permite crear una nueva clase (clase hija o subclase) a partir de una clase existente (clase padre o superclase). Permite que la clase hija reutilice los atributos y métodos de la clase padre, promoviendo la reutilización de código y organizando las clases en una estructura jerárquica. En Java, se utiliza mediante la palabra clave **`extends`** inmediatamente después del nombre de la clase hija. Al heredar, la subclase adquiere automáticamente todos los miembros públicos y protegidos de la superclase.

  ### 21. ¿Qué son los modificadores de acceso y cuáles son los más comunes en Java?
  Los modificadores de acceso son palabras clave que definen la visibilidad, el nivel de alcance y el grado de restricción que tienen las clases, atributos, métodos y constructores dentro de un proyecto. Su objetivo principal es aplicar el principio de encapsulamiento, regulando qué partes del programa pueden consultar o modificar los miembros de una clase.

| Modificador | Nivel de Visibilidad |
| :--- | :--- |
| **`public`** | Accesible desde cualquier clase en cualquier paquete del proyecto sin ninguna restricción. |
| **`protected`** | Accesible por clases del mismo paquete y por subclases (clases hijas) en otros paquetes. |
| **`default`** *(sin palabra clave)* | Accesible únicamente por clases que se encuentran dentro del mismo paquete (*package-private*). |
| **`private`** | Accesible únicamente dentro de la propia clase donde fue declarado; completamente oculto para el exterior. |

 ### 22. ¿Qué es una variable de entorno y por qué son importantes para Java o la programación en general?
 Una variable de entorno es un valor dinámico guardado a nivel del sistema operativo que influye en el comportamiento de los procesos y aplicaciones en ejecución. En lugar de estar hardcodeada (escrita fijamente) dentro del código fuente, la aplicación consulta estas variables externas para adaptarse a su entorno.

* **Importancia en la programación en general:** 
  Permite separar la configuración del código fuente. Es fundamental para almacenar datos sensibles (claves API, credenciales de bases de datos) y configuraciones que cambian según el entorno de despliegue (desarrollo, pruebas, producción) sin modificar el código ni exponer contraseñas en repositorios como GitHub.

* **Importancia específica para Java:** 
  Son cruciales para el funcionamiento y compilación de proyectos. La variable **`JAVA_HOME`** le indica al sistema y a las herramientas de desarrollo (como Maven, Gradle o IDEs) la ruta exacta donde está instalado el Kit de Desarrollo de Java (JDK). A su vez, añadir Java a la variable **`PATH`** permite ejecutar los comandos del compilador (`javac`) y de la máquina virtual (`java`) desde cualquier terminal o consola del sistema sin importar el directorio actual.