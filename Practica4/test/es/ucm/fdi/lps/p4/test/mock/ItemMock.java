/**
 * ItemMock.java  04/01/2010
 * 
 * Laboratorio de Programación de Sistemas (2010/2011)
 * Ingeniería Técnica en Informática de Sistemas
 * Lecturers: Guillermo Jiménez Díaz
 *            Federico Peinado Gil
 *            Borja Manero Iglesias
 *
 * Facultad de Informática
 * Universidad Complutense de Madrid
 */
package es.ucm.fdi.lps.p4.test.mock;

import es.ucm.fdi.lps.p4.Item;

/**
 * Mocks the Item class.
 * @author Federico Peinado
 */
public class ItemMock extends Item {
    
    /**
     * Mocks the constructor (without arguments).
     */
    // Se asume que el constructor más sencillo de Item funciona
    public ItemMock() {
	super("Mock Id", "Mock Name", "Mock Description", 0, 0);
    }    
}