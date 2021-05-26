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
public interface IdaoActions<T,G> {
    void add(T t,G g);
    boolean edit(T t);
    Collection <T> findAllFactura();
    Collection <G> findAllDetalle();
}
