/**
 * This interface is used for mapping objects from type F to type T.
 *
 * @param <F> the source type
 * @param <T> the target type
 */
package com.example.csvrestapi.mapper;

public interface Mapper<F, T> {

    /**
     * Converts an object of type F to type T.
     *
     * @param from the source object of type F
     * @return the converted object of type T
     */
    T map(F from);

}
