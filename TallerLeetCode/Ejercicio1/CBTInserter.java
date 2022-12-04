package Ejercicio1;

class CBTInserter {
    TreeNode root;
    Deque<TreeNode> deque;
    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null)
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();
        }
    }
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