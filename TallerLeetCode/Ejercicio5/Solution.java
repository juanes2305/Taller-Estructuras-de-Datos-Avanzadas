package Ejercicio5;


class Solution {
    TreeNode ans, target;
    
    public void inorder(TreeNode o, TreeNode c) {
        if (o != null) {
            inorder(o.left, c.left);
            if (o == target) {
                ans = c;    
            }
            inorder(o.right, c.right);    
        }
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        inorder(original, cloned);
        return ans;
    }
}


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


Complejidad del tiempo:\mathcal{O}(N)O ( N ). Dado que uno tiene que visitar cada nodo, dondenortenortees un número de nodos.

 */