/**
 * LocationMock.java  04/01/2010
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

import es.ucm.fdi.lps.p4.Location;

/**
 * Mocks the Location class.
 * @author Federico Peinado
 */
public class LocationMock extends Location {
    
    /**
     * Mocks the constructor (without arguments).
     */
    // Se asume que el constructor m�s sencillo de Location funciona
    public LocationMock() {
	super("Mock Id", "Mock Name", "Mock Description");
    }   
    
    /**
     * Mocks the constructor (with an int argument, for an exit location).
     */
    // Se asume que este otro constructor de Location funciona
    public LocationMock(int exitThreshold) {
	super("Mock Id", "Mock Name", "Mock Description", exitThreshold, "Mock Exit Message");
    }   
}