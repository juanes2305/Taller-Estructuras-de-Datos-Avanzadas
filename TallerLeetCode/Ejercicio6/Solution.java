package Ejercicio6;


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Almacenar todas las aristas en 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        // Almacena todos los nodos a visitar en la 'cola'.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true; 
            }

              // Para todos los vecinos del nodo actual, si no lo hemos visitado antes,            
            // lo añadimos a la 'cola' y lo marcamos como visitado.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return false;
    }
}

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
