 package Ejercicio3;


/**
 * Write a description of class Solution here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solution
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Solution
     */
    public Solution()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}

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
