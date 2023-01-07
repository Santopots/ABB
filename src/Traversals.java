import java.util.ArrayList;
import java.util.LinkedList;
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
    private static class Context<E> {
        List<E> result;
        BinaryTree<E> tree;
        EntryPoint entryPoint;

        public Context(List<E> result, BinaryTree<E> tree) {
            this.result = result;
            this.tree = tree;
            this.entryPoint = EntryPoint.CALL;
        }
    }

    private enum EntryPoint {
        CALL, RESUME1, RESUME2
    }
    public static <E> List <E> inorderIterative(List<E> result, BinaryTree<E> tree) {
        var stack = new LinkedList<Context>();
        stack.addFirst(new Context<E>(result, tree));

        while (!stack.isEmpty()) {
            var context = stack.getFirst();

            switch (context.entryPoint) {
                case CALL -> {
                    if (!tree.isEmpty()) {
                        result.add(tree.root());
                        stack.removeFirst();
                    } else {
                        context.entryPoint = EntryPoint.RESUME1;
                        stack.addFirst(new Context<>(result, tree));
                    }
                }
                case RESUME1 -> {
                    context.entryPoint = EntryPoint.RESUME2;
                    stack.addFirst(new Context<>(context.result, (context.tree).left()));
                }
                case RESUME2 -> {
                    stack.removeFirst();
                    stack.addFirst(new Context<>(context.result, (context.tree).right()));
                }
            }
        }
        return result;
    }
}
