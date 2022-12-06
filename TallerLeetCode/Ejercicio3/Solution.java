 package Ejercicio3;


 * Definition for a binary tree node.
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
 

public class Solution
{
    public boolean validate(TreeNode root, Integer low, Integer high) {
        // Los árboles vacíos son BST válidos.
        if (root == null) {
            return true;
        }
        // El valor del nodo actual debe estar entre bajo y alto.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // El valor del nodo actual debe estar entre bajo y alto.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

}

/*
class Solution {

    private Deque<TreeNode> stack = new LinkedList();
    private Deque<Integer> upperLimits = new LinkedList();
    private Deque<Integer> lowerLimits = new LinkedList();

    public void update(TreeNode root, Integer low, Integer high) {
        stack.add(root);
        lowerLimits.add(low);
        upperLimits.add(high);
    }

    public boolean isValidBST(TreeNode root) {
        Integer low = null, high = null, val;
        update(root, low, high);

        while (!stack.isEmpty()) {
            root = stack.poll();
            low = lowerLimits.poll();
            high = upperLimits.poll();

            if (root == null) continue;
            val = root.val;
            if (low != null && val <= low) {
                return false;
            }
            if (high != null && val >= high) {
                return false;
            }
            update(root.right, val, high);
            update(root.left, low, val);
        }
        return true;
    }
}
*/

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
