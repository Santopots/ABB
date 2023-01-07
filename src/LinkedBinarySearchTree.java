import java.util.Comparator;

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
    }
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
        return get(root, key);
    }
    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = comparator.compare(key,node.key);
        if (cmp < 0 ) { //aqui amb el compare
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

   @Override
    public BinarySearchTree<K, V> put(K key, V value) {
        root = put(root, key, value);
        return this;
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
            node = (Node<K, V>) value;
        }
        return node;
    }
    @Override
    public BinarySearchTree<K, V> remove(K key) {

        return null;
    }
}
