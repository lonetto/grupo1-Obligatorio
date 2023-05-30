package uy.edu.um.prog2.adt.tads.Hash;

import org.junit.Assert;
import org.junit.Test;
import uy.edu.um.prog2.adt.tads.Hash.MyClosedHashImpl;

public class TestHash {
    private MyClosedHashImpl<String, Integer> hashTable = new MyClosedHashImpl<>();
    @Test
    public void testPutAndGet() {
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);

        Assert.assertEquals(Integer.valueOf(1), hashTable.get("key1"));
        Assert.assertEquals(Integer.valueOf(2), hashTable.get("key2"));
        Assert.assertNull(hashTable.get("key3"));

        hashTable.put("key3", 3);
        Assert.assertEquals(Integer.valueOf(3), hashTable.get("key3"));
    }
    @Test
    public void testPutAndDelete() {
        hashTable.put("key1", 1);
        hashTable.put("key2", 2);
        hashTable.put("key3", 3);
        hashTable.delete("key1");

        Assert.assertNull(hashTable.get("key1"));
        Assert.assertEquals(Integer.valueOf(3), hashTable.get("key3"));
        Assert.assertEquals(Integer.valueOf(2), hashTable.get("key2"));

        hashTable.delete("key3");
        Assert.assertNull(hashTable.get("key3"));
    }
    @Test
    public void testSize() {
        Assert.assertEquals(0, hashTable.size());

        hashTable.put("key1", 1);
        hashTable.put("key2", 2);

        Assert.assertEquals(2, hashTable.size());

        hashTable.delete("key1");

        Assert.assertEquals(1, hashTable.size());
    }
    @Test
    public void testIsEmpty() {
        Assert.assertTrue(hashTable.isEmpty());

        hashTable.put("key1", 1);

        Assert.assertFalse(hashTable.isEmpty());

        hashTable.delete("key1");

        Assert.assertTrue(hashTable.isEmpty());
    }
}
