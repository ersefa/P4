/**
 * InputStreamMock.java  04/01/2010
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

import java.io.IOException;
import java.io.InputStream;

/**
 * Mocks the InputStream class.
 * @author Guillermo Jim�nez
 * @author Federico Peinado
 */
// Nos inspiramos en el NullInputStream de Guillermo Jim�nez
public class InputStreamMock extends InputStream {
    
    private int counter;
    private byte[] bytes;
    
    /**
     * Mocks a constructor without arguments.
     */ 
    public InputStreamMock() {
	super();
	bytes = new byte[0]; 
	counter = 0;
    }  
    
    /**
     * Mocks a constructor with a string as an argument.
     */ 
    public InputStreamMock(String string) {
	super();
	bytes = string.getBytes(); // Lo �nico malo de esta conversi�n es que se realiza con la codificaci�n de caracteres por defecto que tenga el sistema
	counter = 0;
    }  
    
    /**
     * Reads nothing.
     */
    @Override
    public int read() throws IOException {
	if (counter >= bytes.length)
	    return -1;
	int result = bytes[counter];
	counter++;
	return result; 
    }
}