import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinarySearchTreeTest {
    //plantilla de test amb assert
//stack<Integer> empty = new LinkedStack<>();
//assertThrows(NoSuchElementException.class, () -> { empty.top(); });
//NoSuchElementException.class -> excepció que esperem
    @Test
    void putTest(){
        Comparator<Integer> cmp = Comparator.<Integer>naturalComparator();
        LinkedBinaryTree<Integer, Integer> arb1 = new LinkedBinaryTree<>(cmp);
        arb1 = arb1
                .put(4, 40)
                .put(2, 20)
                .put(9, 90);
    }

    @Test
    void removeTest(){
    }
}