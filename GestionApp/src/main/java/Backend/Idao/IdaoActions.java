/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Idao;

import java.util.Collection;

/**
 *Interface que declara los métodos a usar en las conexciones de los registros
 * @author FAMILIASOZAORTIZ
 * @param <T> Detalle de factura
 * @param <G> Detalle de Compra o Venta
 */
public interface IdaoActions<T,G> {
    void add(T t,G g);
    boolean edit(T t);
    Collection <T> findAllFactura();
    Collection <G> findAllDetalle();
}
