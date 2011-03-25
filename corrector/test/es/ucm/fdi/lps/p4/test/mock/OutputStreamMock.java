/**
 * OutputStreamMock.java  04/01/2010
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
import java.io.OutputStream;

/**
 * Mocks the OutputStream class.
 * @author Guillermo Jim�nez
 * @author Federico Peinado
 */
// Nos inspiramos en el NullOutputStream de Guillermo Jim�nez
public class OutputStreamMock extends OutputStream {
    
    /**
     * Writes nothing.
     */
    @Override
    public void write(int arg0) throws IOException {
    } 
}