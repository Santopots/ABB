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
    }
    public LinkedBinarySearchTree(Comparator<? super K> comparator) {
        root = null;
        this.comparator = comparator;
    }
    public LinkedBinarySearchTree(Comparator<? super K> comparator, Node<K, V> root) {
        this.root = root;
        this.comparator = comparator;

    }

    @Override
    public boolean isEmpty() {
         // si no hi ha arrel, l'arbre estaria buit
    }

    @Override
    public boolean containsKey(K key) {
       return contains(key, root);
    }
    public boolean contains(K key, Node node) {
        boolean found = false;
        if (key == null) {
            throw new NullPointerException();
        } else if (comparator.compare(key, node.key) == 0) {
            found = true;
        } else if (found == false) {
            contains(key,node.left);
        } else {
            contains(key, node.right);
        }
        return found;
    }
    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public BinarySearchTree<K, V> put(K key, V value) {
        return null;
    }

    @Override
    public BinarySearchTree<K, V> remove(K key) {
        return null;
    }
}
