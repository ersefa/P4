/**
 * CommandMock.java  04/01/2010
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

import es.ucm.fdi.lps.p4.command.Command;

/**
 * Mocks the Command class.
 * @author Federico Peinado
 */
public class CommandMock extends Command {
    
    /**
     * Mocks the constructor (without arguments).
     */
    // Se asume que el constructor m�s sencillo de Command funciona
    public CommandMock() {
	super(new GameMock());
    }   
    
    /**
     * Mocks the getHelp method. 
     * @return The help information.
     */  
    public String getHelp(){
	return "Mock Help";
    }
    
    /**
     * Mocks the parse method. 
     * @param line The text line.
     * @return {@code true} if the text line has been successfully parsed and the command successfully configured; {@code false} otherwise.
     */
    public boolean parse(String line){
	return true;
    }
    
    /**
     * Mocks the toString method.  
     */ 
    public String toString(){
	return "CommandMock";
    }
    
    /**
     * Mocks the equals method (for checking the success of a clonation).
     * It simply checks the results of the public methods getHelp and toString
     */ 
    // No compruebo getResult porque puede ser peligroso (no siempre lo hay)
    @Override
    public boolean equals(Object command){
	return (command instanceof Command &&
		this.getHelp().equals(((Command)command).getHelp()) &&  
		this.toString().equals(((Command)command).toString()));
    }

}