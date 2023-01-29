package net.jinnjar.common;

/**
 * @author adnan
 * @since 2/24/2023
 */
public class Pair implements Comparable<Pair> {

    public Integer firstVal;
    public Integer secondVal;

    public Pair(Integer firstVal, Integer secondVal) {
        this.firstVal = firstVal;
        this.secondVal = secondVal;
    }

    @Override
    public int compareTo(Pair o) {
        return this.firstVal.compareTo(o.firstVal);
    }
}
