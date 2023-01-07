import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinarySearchTreeTest  {
    //plantilla de test amb assert
//stack<Integer> empty = new LinkedStack<>();
//assertThrows(NoSuchElementException.class, () -> { empty.top(); });
//NoSuchElementException.class -> excepció que esperem
    private Comparator<Integer> cmp;
    private LinkedBinarySearchTree<Integer, Integer> arb1;

    @BeforeEach
    public void LinkedbinarySearchTreeForTests () {
        this.arb1 = new LinkedBinarySearchTree<>(this.cmp);
    }

    @Test
    public void containsTestException () {

        Exception exception = assertThrows(NullPointerException.class, () ->
        {arb1.containsKey(null);});
        assertEquals("clave nula",exception.getMessage());
    }

    @Test
    public void getTestException () {
       Exception exception = assertThrows(NullPointerException.class, () ->
        {arb1.get(null);});
        assertEquals("clave nula",exception.getMessage());
    }

    @Test
    public void getTestException1 () {
        Exception exception = assertThrows(NoSuchElementException.class, () ->
        {arb1.get(4);});
        assertEquals("clave no encontrada",exception.getMessage());
    }

    @Test
    public void getTest () {
        arb1.put(4,40);
        assertEquals(40,arb1.get(4));
    }

    @Test
    public void putTestException () {
        Exception exception = assertThrows(NullPointerException.class, () ->
        {arb1.put(null,30);});
        assertEquals("clave nula",exception.getMessage());
    }

    @Test
    public void putTestException1 () {
        Exception exception = assertThrows(NullPointerException.class, () ->
        {arb1.put(3,null);});
        assertEquals("valor nulo",exception.getMessage());
    }

    @Test
    public void putTest(){
        arb1.put(4,40);
        arb1.put(2,20);
        arb1.put(9,90);
        assertTrue(arb1.containsKey(4) && arb1.containsKey(2) && arb1.containsKey(9));
    }

    @Test
    void removeTest(){
        arb1.put(4,40);
        arb1.put(3,30);
        arb1.remove(3);
        Exception exception = assertThrows(NoSuchElementException.class, () ->
        {arb1.get(3);});
        assertEquals("clave no encontrada",exception.getMessage());
    }

    @Test
    void removeTest1(){
        arb1.put(4,40);
        arb1.put(3,30);
        arb1.remove(3);
        arb1.remove(4);
        assertTrue(arb1 == null);
    }
}