/**
 * GameMock.java  04/01/2010
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

import es.ucm.fdi.lps.p4.Game;
import es.ucm.fdi.lps.p4.Location;

/**
 * Mocks the Game class.
 * @author Federico Peinado
 */
public class GameMock extends Game {
    
    /**
     * Mocks the constructor (without arguments).
     */
    // Se asume que el constructor m�s sencillo de Game funciona
    public GameMock() {
	super("Mock Title", "Mock Author", "Mock Description", new LocationMock());
    }   
    
    /**
     * Mocks the constructor (with a location argument).
     */
    // Se asume que este otro constructor de Game funciona
    public GameMock(Location location) {
	super("Mock Title", "Mock Author", "Mock Description", location);
    }   
}