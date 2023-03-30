import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

class BinTree<T> implements Iterable<T> {
    BinTree<T> left;
    BinTree<T> right;
    T val;

    public Iterator<T> iterator() {
        return new TreeIterator(this);
    }

    private class TreeIterator implements Iterator<T> {
        private Stack<BinTree<T>> s = new Stack<BinTree<T>>();

        TreeIterator(BinTree<T> n) {
            if (n.val != null) s.push(n);
        }

        public boolean hasNext() {
            return !s.empty();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            BinTree<T> n = s.pop();
            if (n.right != null) s.push(n.right);
            if (n.left != null) s.push(n.left);
            return n.val;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

public class test {
    public static void main(String[] args) {
        BinTree<Integer> tree = new BinTree<Integer>();
        tree.val = 1;
        tree.left = new BinTree<Integer>();
        tree.left.val = 2;
        tree.right = new BinTree<Integer>();
        tree.right.val = 3;

        for (Integer i : tree) {
            System.out.println(i);
        }
    }
}