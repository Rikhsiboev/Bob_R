package PrepInterview.LruCache;

public class LRUCache2TestApp {
    public static void main(String[] args) {
        LRUCash2 LRUCache = new LRUCash2(2);
        LRUCache.put(1,1);
        LRUCache.put(2,2);
        System.out.println(LRUCache.get(1));
        LRUCache.put(3,3);
        System.out.println(LRUCache.get(2));
        LRUCache.put(4,4);
        System.out.println(LRUCache.get(1));
        System.out.println(LRUCache.get(3));
        System.out.println(LRUCache.get(4));
    }
}
