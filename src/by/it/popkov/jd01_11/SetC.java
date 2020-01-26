package by.it.popkov.jd01_11;


import java.util.*;

class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;
    private boolean nullCheck = false;
    private Map<T, Object> map = new HashMap<>();
    private final static Object OBJECT = new Object();

    private int check(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) continue;
            if (elements[i].equals(o)) return i;
        }
        return -1; ///False
    }

    @Override
    public boolean add(T t) {
        if (map.put(t, OBJECT) == null) return true;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        boolean b = map.containsKey(o);
        map.remove(o);
        return b;

    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return false;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!map.containsKey(o)) return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean r = false;
        for (Object o : c) {
            if (map.containsKey(o)) {
                remove(o);
                r = true;
            }
        }
        return r;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String comma = "";
        for (int i = 0; i < size; i++) {
            sb.append(comma).append(elements[i]);
            comma = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    ///----------------------------------Fictive------------------------

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
