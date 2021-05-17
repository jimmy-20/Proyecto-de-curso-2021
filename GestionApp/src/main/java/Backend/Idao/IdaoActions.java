/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Idao;

import java.util.Collection;

/**
 *
 * @author FAMILIASOZAORTIZ
 * @param <T>
 */
public interface IdaoActions<T> {
    void add(T t);
    boolean delete(T t);
    boolean edit(T t);
    Collection <T> findAll();
}
