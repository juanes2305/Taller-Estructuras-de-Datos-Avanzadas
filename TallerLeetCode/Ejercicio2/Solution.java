package Ejercicio2;

* public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

     
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // pasar al siguiente nodo de la derecha
            } else { // tiene un subárbol izquierdo
                pre = curr.left;
                while (pre.right != null) { // encuentra el más a la derecha
                    pre = pre.right;
                }
                pre.right = curr; // poner cur después del nodo pre
                TreeNode temp = curr; // almacenar el nodo cur
                curr = curr.left; // mover cur a la parte superior del nuevo árbol
                temp.left = null; //la izquierda de cur original es nula, para evitar bucles infinitos
            }
        }
        return res;
    }
}

/*
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
