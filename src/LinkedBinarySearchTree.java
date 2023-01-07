import java.util.Comparator;
import java.util.NoSuchElementException;

public class LinkedBinarySearchTree<K,V> implements  BinarySearchTree<K, V>{

    private final Node<K, V> root;
    private final Comparator<? super K> comparator;

    private static class Node<K, V> { //classe node
        private final K key;
        private final V value;
        private final Node<K, V> left; //link node esquerre
        private final Node<K, V> right; //link node dret
        private int size;

        private Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getLeft() {
            return left;
        }

        public Node<K, V> getRight() {
            return right;
        }

        public int getSize() {
            return size;
        }
    } //classe node
    public LinkedBinarySearchTree(Comparator<? super K> comparator) {
        root = new Node<K,V>(null,null,null,null);
        this.comparator = comparator;
    }
    private LinkedBinarySearchTree(Comparator<? super K> comparator, Node<K, V> root) {
        this.root = root;
        this.comparator = comparator;
    }
    @Override
    public boolean isEmpty() {
         return root == null; // si no hi ha arrel, l'arbre estaria buit
    }

    @Override
    public boolean containsKey(K key) {
       return contains(key, root);
    }

    public boolean contains(K key, Node<K,V> node) {
        boolean found = false;
        if (key == null) {
            throw new NullPointerException("clave nula");
        } else if (comparator.compare(key, node.key) == 0 )  {
            found = true;
        } else if (!found) {
            contains(key,node.left);
        } else {
            contains(key, node.right);
        }
        return found;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("clave nula");
        } else {
           return get(root, key);
        }
    }

    public V get(Node<K,V> node, K key) {
        V keyValue = null;
        if(node == null) {
            return null;
        }
        if (comparator.compare(key, node.key) == 0) {
            keyValue = node.value;
        } else if (comparator.compare(key, node.key) > 0) {
            get(node.left, key);
        } else {
            get(node.right, key);
        }
        if (keyValue == null) {
            throw new NoSuchElementException("Clave no encontrada");
        } else {
            return keyValue;
        }
    }

   @Override
    public BinarySearchTree<K, V> put(K key, V value) {
        LinkedBinarySearchTree<K,V> b = new LinkedBinarySearchTree<K, V>(comparator, root);
         b.put(root, key, value);
        return b;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }
        int cmp = comparator.compare(key, node.key);
        if (cmp < 0) {
            node = put(node.left, key, value);
        } else if (cmp > 0) {
            node = put(node.right, key, value);
        } else {
            node = value;
        }
        return node;
    }
    @Override
    public BinarySearchTree<K, V> remove(K key) {

    }
    void deleteKey(K key) { root = deleteRec(root, key); }

    /* A recursive function to
      delete an existing key in BST
     */
    Node deleteRec(Node root, K key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;

        /* Otherwise, recur down the tree */
        if (comparator.compare(key, root.key) == 1)
            root.left = deleteRec(root.left, key);
        else if (comparator.compare(key,root.key)==)
            root.right = deleteRec(root.right, key);

            // if key is same as root's
            // key, then This is the
            // node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root)
    {
        int minv = (int) root.key;
        while (root.left != null) {
            minv = (int) root.left.key;
            root = root.left;
        }
        return minv;
    }

    // This method mainly calls insertRec()
    void insert(int key) { root = insertRec(root, key); }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {
        /* If the tree is empty,
          return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (comparator.compare(key, root.key) < 0)
            root.left = insertRec(root.left, key);
        else if (comparator.compare(key, root.key)> 0)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() { inorderRec(root); }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

}

