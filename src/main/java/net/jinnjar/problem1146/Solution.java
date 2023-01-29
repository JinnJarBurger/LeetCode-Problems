package net.jinnjar.problem1146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author adnan
 * @since 6/17/2023
 */
class SnapshotArray {

    Map<Integer, Map<Integer, Integer>> snapShot;
    int snapId;

    public SnapshotArray(int length) {
        snapShot = new HashMap<>();
        snapId = 0;
    }

    public void set(int index, int val) {
        snapShot.computeIfAbsent(snapId, k -> new HashMap<>()).put(index, val);
    }

    public int snap() {
        snapShot.computeIfAbsent(snapId, k -> new HashMap<>());
        return snapId++;
    }

    public int get(int index, int snap_id) {
        if (snapShot.get(snap_id).containsKey(index)) {
            return snapShot.get(snap_id).get(index);
        }

        while (snap_id >= 0) {
            if (snapShot.get(snap_id).containsKey(index)) {
                return snapShot.get(snap_id).get(index);
            }

            snap_id--;
        }

        return 0;
    }
}
