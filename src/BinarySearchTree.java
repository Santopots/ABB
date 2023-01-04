public interface BinarySearchTree<K,V>{
    //declara operacions que podem realitzar sobre arbres binaris de búsqueda
    boolean isEmpty();
    boolean containsKey(K ky);
    V get(K key);
    BinarySearchTree<K, V> put(K key, V value);
    BinarySearchTree<K, V> remove(K key);
}
