import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinarySearchTreeTest  {
    //plantilla de test amb assert
//stack<Integer> empty = new LinkedStack<>();
//assertThrows(NoSuchElementException.class, () -> { empty.top(); });
//NoSuchElementException.class -> excepció que esperem

    @Test
    public void containsTestException () {
        Comparator<Integer> cmp = Comparator.<Integer>naturalOrder();
        LinkedBinarySearchTree<Integer,Integer> arb1 = new LinkedBinarySearchTree<>(cmp);
        Exception exception = assertThrows(NullPointerException.class, () ->
        {arb1.containsKey(null);});
        assertEquals("clave nula",exception.getMessage());

    }
    /*@Test
    void putTest(){
        Comparator<Integer> cmp = Comparator.<Integer>naturalOrder();
        LinkedBinaryTree<Integer, Integer> arb1 = new LinkedBinaryTree<>(cmp);
        arb1 = arb1
                .put(4, 40)
                .put(2, 20)
                .put(9, 90);
    }

    @Test
    void removeTest(){
    }*/
}