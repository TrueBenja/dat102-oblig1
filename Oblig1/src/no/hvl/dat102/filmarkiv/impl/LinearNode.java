package no.hvl.dat102.filmarkiv.impl;

public class LinearNode<T> {
    public T data;
    public LinearNode<T> neste;

    public LinearNode(T data) {
        this.data = data;
    }
}
