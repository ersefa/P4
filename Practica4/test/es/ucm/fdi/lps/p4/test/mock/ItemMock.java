/**
 * ItemMock.java  04/01/2010
 * 
 * Laboratorio de Programaci�n de Sistemas (2010/2011)
 * Ingenier�a T�cnica en Inform�tica de Sistemas
 * Lecturers: Guillermo Jim�nez D�az
 *            Federico Peinado Gil
 *            Borja Manero Iglesias
 *
 * Facultad de Inform�tica
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
    // Se asume que el constructor m�s sencillo de Item funciona
    public ItemMock() {
	super("Mock Id", "Mock Name", "Mock Description", 0, 0);
    }    
}