package ASSA3;

public class BST <K extends Comparable<K> , V> {
private static class MyNode <K extends Comparable<K> , V>{
    K key;
    V value;
    MyNode <K,V>left,right;
    MyNode(K key ,V value)
    {
        this.key=key;
        this.value=value;

    }
    private MyNode<K,V> root;
    private int length;

    public void put(K key,V value)
    {
        MyNode<K,V> newNode =new MyNode<>(key, value);
        root=put(root, newNode);
    }
    private MyNode<K,V>put (MyNode<K,V>current ,MyNode<K,V>node) {
        if (current == null) {
            return node;
        }
        int cmp = node.key.compareTo(current.key);
        if (cmp>0)
            current.right=put(current.right, node);
        else if(cmp<0)
            current.left=put(current.left, node);
        else {

        }
        return current;
    }


}
}
