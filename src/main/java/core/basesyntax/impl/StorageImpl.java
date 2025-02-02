package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ELEMENTS_MAX_AMOUNT = 10;
    private int size;
    private K[] keys;
    private V[] values;

    public StorageImpl() {
        keys = (K[]) new Object[ELEMENTS_MAX_AMOUNT];
        values = (V[]) new Object[ELEMENTS_MAX_AMOUNT];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                values[i] = value;
                return;
            }
        }
        values[size] = value;
        keys[size] = key;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key || (key != null && key.equals(keys[i]))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
