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
    private  HashNode<K , V>[] chainArray;
    private int M=11;
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

    public void put(Integer key, String value){
        if(key == null || value == null){
            throw new IllegalArgumentException("Key or Value is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = chainArray[bucketIndex];
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = chainArray[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        chainArray[bucketIndex] = node;
    }

    private int getBucketIndex(Integer key){
        return key % M;
    }

    public String get(Integer key){
        if(key == null){
            throw new IllegalArgumentException("Key is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = chainArray[bucketIndex];
        while(head != null){
            if(head.key.equals(key)){
                return head.toString();
            }
            head = head.next;
        }

        return null;
    }

    public String remove(Integer key){
        if(key == null){
            throw new IllegalArgumentException("Key is null !!!");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = chainArray[bucketIndex];
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
            chainArray[bucketIndex] = head.next;
        }

        return head.toString();
    }



}
