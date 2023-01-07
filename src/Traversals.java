import java.util.ArrayList;
import java.util.List;

public class Traversals {

    public static <E> List<E> inorder(BinaryTree<E> tree) {
        List<E> result = new ArrayList<>();
        inorderRec(result,tree);
        return result;
    }

    private static <E> void inorderRec(List<E> result, BinaryTree<E> tree) {
        if(!tree.isEmpty()) {
            inorderRec(result,tree.left());
            result.add(tree.root());
            inorderRec(result, tree.right());
        }
    }
    public record Pair<F,S> (F first, S second) {}
}
