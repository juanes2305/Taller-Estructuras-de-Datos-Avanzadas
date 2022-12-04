package Ejercicio4;


class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // casos de aristas o borde
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        // Construye el gráfico con la lista de adyacencia
        ArrayList<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++)
            neighbors.add(new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        // Inicializar la primera capa de hojas
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);

        // Recorta las hojas hasta llegar a los centroides
        int remainingNodes = n;
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            // eliminar las hojas actuales junto con las aristas
            for (Integer leaf : leaves) {
                // el único vecino que queda para el nodo hoja
                Integer neighbor = neighbors.get(leaf).iterator().next();
                // eliminar la arista junto con el nodo hoja
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1)
                    newLeaves.add(neighbor);
            }

            // prepararse para la siguiente ronda
            leaves = newLeaves;
        }

        // Los nodos restantes son los centroides del grafo
        return leaves;
    }
}


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