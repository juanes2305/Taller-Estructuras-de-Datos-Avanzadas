---------------------------------------------------------------------------
TALLER DE ESTRUCTUAS DE DATOS AVANZADAS - MATERIA DE ANALISIS DE ALGORITMOS
---------------------------------------------------------------------------

PROJECT TITLE: TALLER DE ESTRUCTURA DE DATOS AVANZANDAS

PURPOSE OF PROJECT: MEJORAR EN EL DESARROLLO Y ANALISIS DE ESTRUCTURA DE DATOS MAS ESPECIFICAMENTE ARBOLES

VERSION or DATE: 2022

HOW TO START THIS PROJECT: 2022

AUTHORS:
1. ANGELA DANIELA CAMPEROS REYES -  1152076 
2. JUAN ESTEBAN HERNANDEZ ALVAREZ - 1152122
3. MARIA ALEXANDRA SIERRA PABON - 1152079

USER INSTRUCTIONS:
A continuación una lista de problemas relacionados con estructuras de datos avanzadas:

https://leetcode.com/problems/complete-binary-tree-inserter/
https://leetcode.com/problems/binary-tree-inorder-traversal/
https://leetcode.com/problems/validate-binary-search-tree/
https://leetcode.com/problems/minimum-height-trees/
https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
https://leetcode.com/problems/find-if-path-exists-in-graph/
https://leetcode.com/problems/relative-ranks/
https://codeforces.com/problemset/problem/681/C
https://atcoder.jp/contests/abc240/tasks/abc240_b?lang=en
https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1998
Para cada problema debe:

1) Resolverlo en la plataforma

2) Escribir un programa que genere dos ficheros TXT, un fichero con datos de entrada y otro con datos de salida. Estos datos deben servir para probar la misma solución anterior en otra plataforma. La prueba debe realizarla (según lo explicado en clase) usando redirección de I/O por comandos <  in.txt >out.txt

3) Explicar la solución con un ejemplo gráfico, con colores, paso a paso. Por ejemplo, si se requiere armar un árbol y luego recorrerlo, debe mostrarse un ejemplo completo de manera gráfica. Si se deben considerar varios escenarios o casos borde, deben incluirse en esta explicación.

4) Publicar todo lo anterior en git hub en un repositorio, usando el README para la documentación. Subir a UVIRTUAL un ZIP completo del repositorio.

5) Evaluar el trabajo de un compañero, según la rúbrica del taller.

El trabajo puede hacerlo en equipo, pero  la entrega debe ser individual.

Sobre estos mismos problemas se hará el examen final del curso.

**********************************************************************************************************************************************************
EJERCICIO NUMERO 1

/*
     *____________________ANALISIS DE EL ALGORITMO___________________________________________________________
     *Tome que todos ls nodos enumerados por niveles de izquiera 
    a derecha a esto lo llamaremos orden numerico de los nodos
    
    En cada insercion ose que queremos insertar en el nodo
    con numero mas bajo 
    
    Al sostener una deque la cual es la cola de los dos extremos
    de estos en un ondo nuemro podemos proceder a resolver el problema
    .Despues de insetar un nodo, ese nodo ahora tiene el numero mas algo y no tien hijos
    , por lo que va al final de la cola de los dos extremos. Para poder 
    tener el cnodo con el numero mas bajo damos un salto a e inicio de la deque
    
    Continuando primero se realiza una busqueda para poder llenar el deque con los nodos que tengan de 0 
    a 1 hijo en orden numerico, luego se inseta un nodo , el paadre es el primer elemento del deque
    y luego agregamos este nuedo nodo a nuestro dequey asi sucesivamente
    
    _____________________________________________________________________________________________________________
    
    ANALISIS DE COMPlEJIDAD
    O(N)
    */
    
    
*******************************************************************************************************************************************************************
    EJERCICIO NUMERO 2
    
    *
 __________________________________________________ANALISIS DE EL ALGORITMO___________________________________________________________________
 En este método, tenemos que utilizar una nueva estructura de datos-Threaded Binary Tree, y la estrategia es la siguiente:

Paso 1: Inicializar current como raíz

Paso 2: Mientras current no sea NULL,

Si current no tiene un hijo a la izquierda

    a. Añadir el valor de current

    b. Ir a la derecha, es decir, current = current.right

Si

    a. En el subárbol izquierdo de current, haga a current hijo derecho del nodo más a la derecha

    b. Ir a este hijo izquierdo, es decir, current = current.left
Por ejemplo


          1
        / \
       2 3
      / \ /
     4 5 6

En primer lugar, 1 es la raíz, por lo que inicializar 1 como actual, 1 tiene hijo izquierdo que es 2, el subárbol izquierdo de la corriente es

         2
        / \
       4 5
Así que en este subárbol, el nodo más a la derecha es 5, a continuación, hacer la corriente (1) como el hijo derecho de 5. Establece current = cuurent.left (current = 2). El árbol ahora se ve como

         2
        / \
       4 5
            \
             1
              \
               3
              /
             6
Para la corriente 2, que ha dejado al niño 4, podemos continuar con el mismo proceso que hicimos anteriormente

        4
         \
          2
           \
            5
             \
              1
               \
                3
               /
              6
luego agrega 4 porque no tiene hijo izquierdo, luego agrega 2, 5, 1, 3 uno por uno, para el nodo 3 que tiene hijo izquierdo 6, haz lo mismo que arriba. Finalmente, el taversal de orden es [4,2,5,1,6,3].

________________________________ANALISIS DE COMPLEJIDAD___________________________________________________________________________________________________________________________________________________________________

Complejidad de tiempo: O(n)O

Para demostrar que la complejidad temporal es O(n)O(n), el mayor problema radica en encontrar la complejidad temporal de encontrar los nodos predecesores de todos los nodos del árbol binario. Intuitivamente, 
la complejidad es O(n \log n)O(nlogn), porque encontrar el nodo predecesor de un único nodo está relacionado con la altura del árbol. Pero, de hecho, encontrar los nodos predecesores de todos los nodos sólo 
necesita un tiempo O(n)O(n). Dado que un árbol binario con nn nodos tiene n-1n-1 aristas, todo el procesamiento de cada arista se realiza hasta 2 veces, una es para localizar un nodo, y la otra es para 
encontrar el nodo predecesor. Así que la complejidad es O(n)O(n).

 */
 
 ********************************************************************************************************************************************************************
 EJERCICIO NUMERO 3
 
/*
 * ANALISIS DE EL ALGORITMO
 A primera vista, el problema es trivial. Recorramos el árbol y verifiquemos en cada paso si 
 node.right.val > node.valy node.left.val < node.val. Este enfoque incluso funcionaría para algunos árboles.
 
 // Definicion
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

GRAFICO

     (5)    No BTS por que 4 < 5
    /   \
   1     4
        /  \
       3     6
       
El problema es que este enfoque no funcionará para todos los casos. No solo el hijo derecho debe ser más 
grande que el nodo, sino todos los elementos en el subárbol derecho. Aquí hay un ejemplo :       
      
     (5)
    /   \
   /  ***********  En cada nodo las condiciones
   1  *   6     *  
      *  /  \   * noderight.val > node.val
      * 4     7 * node.left.val < node.val
      * *********      
                  son validos
                  
                  Pero no es BST por que no todos los elementos
                  elemntos en el subarbol  derecho del nodo 5
                  son mayores que 5 ( 4 < 5)
                  
Eso significa que uno debe mantener los límites superior e inferior para cada nodo al atravesar el árbol, 
y comparar el valor del nodo no con los valores de los niños sino con estos límites.


ANALISIS DE COMPLEJIDAD
Complejidad del tiempo:O ( N )en el peor de los casos, cuando el árbol es BST o el elemento 
"malo" es una hoja más a la derecha.

 */
 
 ********************************************************************************************************************************************************************
 EJERCICIO NUMERO 4
 
 /*
 *
 ________________________________________ ANALISIS DE ALGORITMOS________________________________________________________-
 El primer paso que describimos arriba es en realidad el problema de la profundidad máxima del árbol N-ario , que consiste 
 en encontrar la distancia máxima desde la raíz hasta los nodos hoja. Para ello, podemos aplicar los algoritmos de búsqueda 
 primero en profundidad ( DFS ) o búsqueda primero en amplitud ( BFS ).

Sin una prueba rígida, podemos ver que la solución directa anterior es correcta y funcionaría para la mayoría de los casos de prueba.

Sin embargo, esta solución no es eficiente, cuya complejidad temporal sería O(Norte)elevado2 Donde Norte el número de nodos en 
el árbol. Como se puede imaginar, resultará en una excepción de límite de tiempo excedido en el juez en línea.

En primer lugar, aclaremos algunos conceptos.

La distancia entre dos nodos es el número de aristas que conectan los dos nodos.

Tenga en cuenta que normalmente podría haber varias rutas para conectar los nodos en un gráfico. Sin embargo, en nuestro caso, dado 
que el gráfico de entrada puede formar un árbol desde cualquier nodo, como se especifica en el problema, solo podría haber una ruta 
entre dos nodos cualesquiera. Además, no habría ningún ciclo en el gráfico. Como resultado, no habría ambigüedad en la definición anterior de distancia .

La altura de un árbol se puede definir como la distancia máxima entre la raíz y todos los nudos de sus hojas.

Con las definiciones anteriores, podemos reformular el problema como encontrar los nodos que en general están cerca de todos los demás nodos,
 especialmente los nodos hoja.

Si vemos el gráfico como un área del círculo y los nodos de hoja como la periferia del círculo, entonces lo que estamos buscando son en realidad 
los centroides del círculo, es decir , los nodos que están cerca de todos los nodos periféricos (nodos de hoja) .

    (O)                   (1)
     |                   / | \
    (1)                 /  |  \
   /   \              (0) (2) (3)   
 (2)   (3)         

Por ejemplo, en el gráfico anterior, está claro que el nodo con el valor 1es el centroide del gráfico. Si elegimos el nodo 1como raíz para formar 
un árbol, obtendríamos un árbol con la altura mínima , en comparación con otros árboles que se forman con cualquier otro nodo.

Antes de continuar, aquí hacemos una afirmación que es esencial para el algoritmo.

Para el gráfico similar a un árbol, el número de centroides no es más de 2.

Si los nodos forman una cadena, es intuitivo ver que se cumple la declaración anterior, que se puede dividir en los siguientes dos casos:

Si el número de nodos es par, entonces habría dos centroides.
Si el número de nodos es impar, entonces solo habría un centroide.

(O)-(X)-(X)-(O)           (O)-(X)-(O)

Para el resto de los casos, podríamos probar por contradicción . Supongamos que tenemos 3 centroides en el gráfico, si eliminamos todos
 los nodos que no son centroides en el gráfico, entonces los 3 nodos centroides deben formar un triángulo , de la siguiente manera:
 
 
    (X)         (X)          
   /   \       /   \               
 (X)   (X)   (O)   (O)
Debido a que estos centroides son igualmente importantes entre sí, y también deberían estar igualmente cerca entre sí. Si falta alguno 
de los bordes del triángulo, los 3 centroides se reducirían a un solo centroide.

Sin embargo, la forma del triángulo forma un ciclo que se contradice con la condición de que no hay ciclo en nuestro gráfico de árbol. 
De manera similar, para cualquiera de los casos que tengan más de 2 centroides, estos deben formar un ciclo entre los centroides, lo cual se contradice con nuestra condición.

Por lo tanto, no puede haber más de 2 centroides en un gráfico similar a un árbol.

Dada la intuición anterior, el problema ahora se reduce a buscar todos los nodos del centroide en un gráfico similar a un árbol, que además no son más de dos.

La idea es que vayamos recortando los nodos hoja capa por capa, hasta llegar al núcleo del grafo, que son los nodos centroides.

Una vez que recortamos la primera capa de los nodos de hoja (nodos que tienen una sola conexión), algunos de los nodos que no son de hoja se convertirían en nodos de hoja.

El proceso de recorte continúa hasta que solo quedan dos nodos en el gráfico, que son los centroides que estamos buscando.

El algoritmo anterior se asemeja al algoritmo de clasificación topológica que genera el orden de los objetos en función de sus dependencias. Por ejemplo, en el escenario de programación de cursos, los cursos que tienen la menor dependencia aparecerían primero en el orden.

En nuestro caso, primero recortamos los nodos hoja, que están más alejados de los centroides. En cada paso, los nodos que recortamos están más cerca de los centroides que los nodos del paso anterior. Al final, el proceso de recorte termina en los nodos de los centroides .

Implementación

Dado el algoritmo anterior, podríamos implementarlo a través de la estrategia Breadth First Search (BFS), para recortar los nodos hoja capa por capa ( es decir , nivel por nivel).

Inicialmente, construiríamos un gráfico con la lista de adyacencia de la entrada.

Luego creamos una cola que se usaría para contener los nodos hoja.

Al principio, ponemos todos los nodos hoja actuales en la cola.

Luego ejecutamos un ciclo hasta que solo queden dos nodos en el gráfico.

En cada iteración, eliminamos los nodos hoja actuales de la cola. Al eliminar los nodos, también eliminamos los bordes que están vinculados a los nodos. Como consecuencia, algunos de los nodos que no son hoja se convertirían en nodos hoja. Y estos son los nodos que se eliminarían en la próxima iteración.

La iteración termina cuando no quedan más de dos nodos en el gráfico, que son los nodos centroides deseados.



Análisis de Complejidad

Dejar|V|sea ​​el número de nodos en el gráfico, entonces el número de aristas sería|V| - 1∣V∣−1como se especifica en el problema.

Complejidad del tiempo:El ( ∣ V ∣ )

Primero, se necesita∣V∣−1 iteraciones para que construyamos un gráfico, dadas las aristas.

Con el grafo construido, recuperamos los nodos hoja iniciales, lo que toma∣V∣pasos.

Durante el proceso de recorte de BFS, eliminaremos casi todos los nodos (∣V∣) y bordes (∣V∣−1) desde los bordes. Por lo tanto, nos llevaría alrededor|V| + |V| - 1∣operaciones para llegar a los centroides.

En resumen, la complejidad temporal total del algoritmo es El ( ∣ V ∣ ).
 */
 
 *********************************************************************************************************************************************************
EJERCICIO NUMERO 5

/*
 _____________________________________ANALISIS DE ALGORITMO_____________________________________________-
 
 Cómo resolver

Recorramos ambos árboles en paralelo y, una vez que se identifique el nodo de destino en el primer árbol, devolvamos el nodo correspondiente del segundo árbol.

Cómo atravesar el árbol: DFS vs BFS

Hay dos formas de atravesar el árbol: búsqueda primero en profundidad DFS y búsqueda primero en amplitud BFS . Aquí un pequeño resumen

//IMAGEN Arbol Binario Transversales Que se encuentras en el paquete

Ambos comienzan desde la raíz y bajan, ambos usan estructuras adicionales, ¿cuál es la diferencia? Así es como se ve a gran escala: BFS atraviesa nivel por nivel, y DFS primero va a las hojas.


//Imagen ComparativaBFSVSDFS
La descripción no nos da ninguna pista de qué recorrido es mejor usar aquí. Las soluciones de entrevista simple son recorridos en orden DFS.

En el Enfoque 1 y el Enfoque 2, vamos a analizar los DFS en orden recursivos y los recorridos DFS en orden iterativos. Ambos necesitan hasta O ( H )espacio para guardar la pila, dondeHHes la altura de un árbol.

En el Enfoque 3, proporcionamos una solución BFS. Normalmente, es una mala idea usar BFS durante la entrevista, a menos que el entrevistador lo presione agregando nuevos detalles en la descripción del problema.

_____________________________________ ANALISIS DE COMPLEJIDAD___________________________________________________________________________________________________________________


Complejidad del tiempo:O ( N ). Dado que uno tiene que visitar cada nodo, dondenortenortees un número de nodos.

 */
 
 **************************************************************************************************************************************************
EJERCICIO NUMERO 6

/*
 ________________________________________ANALISIS DE ALGORITMOS______________________________________________________________
 Algoritmo
1. Inicialice una cola vacía ( queue) para almacenar los nodos a visitar.
2. Use una matriz booleana seenpara marcar todos los nodos visitados y un mapa hash graphpara almacenar todos los bordes.
3. Agregue el nodo 0de inicio queuey márquelo como visitado .
4. Si queuetiene nodos, obtenga el primer nodo curr_nodede queue. Regrese truesi curr_nodees destination, de lo contrario, vaya al paso 5.
5. Agregue todos los nodos vecinos no visitadoscurr_node de to queuey márquelos como visitados , luego repita el paso 4.
6. Si vaciamos queuesin encontrar destination, volver false.

__________________________________________________ANALISIS DE COMPLEJIDAD__________________________________________________________
DejarnortenorteSea el número de nodos ymetrometroSea el número de aristas.

Complejidad del tiempo:O(n + m)

En una búsqueda BFS típica, la complejidad del tiempo es O( V+mi )dónde EN es el número de vértices y Y es el número de aristas. Existennortenortenodos ymetrometrobordes en este problema.
*  Construimos una lista adyacente de todos los mbordes en graphlos que toma O(m).
*  Cada nodo se agrega a la cola y se saca de la cola una vez, tomaEn O( n )para manejar todos los nodos.

La complejidad del tiempo esO(n + m).
 */
 
 ****************************************************************************************************************************************************
 EJERCICIO NUMERO 7
 
 /*
_____________________________________________ANALISIS DE EL ALGORITMO________________________________________
 Se le da una matriz scorede números enteros de tamaño n, donde score[i]es el puntaje del atleta en una competencia. Se garantiza que todas las puntuaciones son únicas .ith

Los atletas se colocan en función de sus puntajes, donde el atleta del lugar tiene el puntaje más alto, el atleta del lugar tiene el puntaje más alto, y así sucesivamente. La ubicación de cada atleta determina su rango:1st2nd2nd

El lugar donde se encuentra el rango del atleta .1st"Gold Medal"
El lugar donde se encuentra el rango del atleta .2nd"Silver Medal"
El lugar donde se encuentra el rango del atleta .3rd"Bronze Medal"
Para el puesto del atleta del puesto, su rango es su número de puesto (es decir, el puesto del atleta del puesto es ).4thnthxth"x"
Devuelve una matriz answerde tamaño ndonde answer[i]está el rango del atleta.ith

___________________________________________ANALISIS DE COMPLEJIDAD_____________________________________________________________
El analisis de complejidad del algoritmo es O(n2)

 */
 
 
 **************************************************************************************************************************************************
 EJERCICIO NUMERO 8
 
 /* _________________________________________ANALISIS DE EL ALGORITMO__________________________________________-
 * 
 *   En primer lugar, esta pregunta utiliza una cola de prioridad, que es la base para resolver esta pregunta.
  ¿Qué es una cola de prioridad?
   Archivo de encabezado de llamada:
  #include<queue>
  usando el espacio de nombres std; (la plantilla de la cola necesita definir el tipo de contenedor)
       uso detallado (parte): 
  Priority_queue<Type> k; ------ Defina una cola ordenada (el elemento superior es el más grande El uno)
  priority_queue<(el tipo de datos de los elementos en la cola), (el tipo del contenedor subyacente utilizado para almacenar y acceder a los elementos de la cola), (reglas de comparación) > k ------ ( forma estándar) define una cola ordenada
  Por ejemplo: cola_prioridad<int, vector<int>, mayor<int> > k; (nota: debe haber un espacio después de la regla de comparación)
define una cola ordenada, y la regla de clasificación es de grande a pequeño (el elemento superior es el más pequeño El que está en la parte superior del mayor) (el más pequeño en la parte superior de mayor, el más grande en la parte superior de menor)


  k.empty() ------ Verifique si es un ejemplo vacío, en caso afirmativo, devuelve 1, no devuelve 0
  k.push(i) ------ Desde Agregar elemento i después del elemento existente (el tamaño del equipo no está predeterminado)
  k.pop() - ----- Borrar el elemento superior (por supuesto, después de ordenar, lo mismo a continuación)
  k.top() ---- -- Mostrar el elemento superior
  k.size() ------ Mostrar el número de elementos existentes
 
Luego mira la solución específica de la pregunta:
  En primer lugar, hay insert, getmin, removemin, tres formas.
insert y removemin no se detallarán aquí;
Concéntrese en discutir la situación de getmin. Realmente llevó demasiado tiempo depurar en ese momento.
(1) Cuando la cola está vacía, inserte directamente + getmin;
(2) Cuando el valor mínimo actual de la cola es menor que el valor mínimo en getmin, es necesario eliminar continuamente el valor mínimo en la cola hasta que sea mayor o igual a
Valor mínimo en getmin
(3) Cuando el valor mínimo actual en la cola es mayor que getmin, inserte directamente;
(4) Cuando se elimina el valor mínimo en la cola, la cola está vacía y se inserta directamente;
-----------------------------------ANALISIS DE COMPLEJIDAD_____________________________________________________________________________
El algoritmo tiene una complejidad de O(N)

   */
*******************************************************************************************************************************************************

   
   
