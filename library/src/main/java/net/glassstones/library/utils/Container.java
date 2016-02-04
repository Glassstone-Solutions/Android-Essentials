package net.glassstones.library.utils;

/**
 * Created by Xaver on 19/08/14.
 */
public interface Container<I, O> {
    public O get(I value);
}
