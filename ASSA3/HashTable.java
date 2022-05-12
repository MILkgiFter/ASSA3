package ASSA3;


public class HashTable<K , V> {
    private class HashNode<K , V>
    {
        private K key;
        private V value;
        private HashNode<K , V> next;
        private HashNode(K key,V value)
        {
            this.value=value;
            this.key=key;
        }

        @Override
        public String toString() {
            return "HashNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    private  HashNode<K , V> []chainArray;
    private int M;
    private int size;
    public HashTable() {
        this.M =11;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }
    public HashTable(int M) {
        this.M =M;
        this.chainArray = new HashNode[M];
        this.size = 0;
    }
    private int hash(K key)
    {
        return (key.hashCode()&0x7fffffff% M);
    }

    public void put(K key, V value){
        if(key == null || value == null){
            throw new IllegalArgumentException("Key or Value is null !!!");
        }
         chainArray[hash(key)]= new HashNode(key,value);
        size++;
    }

    public V get(K key){
        if(key == null){
            throw new IllegalArgumentException("Key is null !!!");
        }
        int Index = hash(key);
        HashNode head = chainArray[Index];
        while(head != null){
            if(head.key.equals(key)){
                return (V) head;
            }
            head = head.next;
        }

        return null;
    }

    public V remove(K key){
        if(key == null){
            throw new IllegalArgumentException("Key is null !!!");
        }

        int Index = hash(key);
        HashNode head = chainArray[Index];
        HashNode previous = null;

        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            previous = head;
            head = head.next;
        }
        if(head == null){
            return null;
        }
        size--;
        if(previous != null){
            previous.next = head.next;
        } else {
            chainArray[Index] = head.next;
        }

        return (V) head;
    }




}
