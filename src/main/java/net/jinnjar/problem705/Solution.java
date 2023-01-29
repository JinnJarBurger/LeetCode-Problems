package net.jinnjar.problem705;

/**
 * @author adnan
 * @since 5/30/2023
 */
class MyHashSet {

    // TODO: will revisit this later
    int[] space;

    public MyHashSet() {
        space = new int[10_000_000];
    }

    public void add(int key) {
        space[key] = 1;
    }

    public void remove(int key) {
        space[key] = 0;
    }

    public boolean contains(int key) {
        return space[key] == 1;
    }
}
