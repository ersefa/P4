package es.ucm.fdi.lps.p4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.ucm.fdi.lps.p4.Game;
import es.ucm.fdi.lps.p4.Game.Direction;
import es.ucm.fdi.lps.p4.Item;
import es.ucm.fdi.lps.p4.Location;
import es.ucm.fdi.lps.p4.command.Command;
import es.ucm.fdi.lps.p4.command.DropCommand;
import es.ucm.fdi.lps.p4.command.GoCommand;
import es.ucm.fdi.lps.p4.command.TakeCommand;
import es.ucm.fdi.lps.p4.exception.InvalidGameDefinitionException;
import es.ucm.fdi.lps.p4.exception.ItemAlreadyInRepositoryException;
import es.ucm.fdi.lps.p4.exception.ItemNotInRepositoryException;
import es.ucm.fdi.lps.p4.exception.NoConnectedLocationException;
import es.ucm.fdi.lps.p4.test.mock.CommandMock;
import es.ucm.fdi.lps.p4.test.mock.GameMock;
import es.ucm.fdi.lps.p4.test.mock.InputStreamMock;
import es.ucm.fdi.lps.p4.test.mock.ItemMock;
import es.ucm.fdi.lps.p4.test.mock.LocationMock;

public class GameTest {
	@Before
	public void setUp() throws Exception {
	}

	// Game Constructor
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullGame() throws InvalidGameDefinitionException {
		new Game(null);
	}

	@Test(expected = es.ucm.fdi.lps.p4.exception.InvalidGameDefinitionException.class)
	public void testEngine() throws InvalidGameDefinitionException {
		new Game(new InputStreamMock());
	}

	@Test
	public void testGame1() {
		new Game("Title", "Author", "Description", new LocationMock());
	}

	// AddExecutedCommand
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testAddNullExecutedCommand() {
		Game testGame = new GameMock();
		testGame.addExecutedCommand(null);
	}

	@Test
	public void testAddExecutedCommand_mockCommand() {
		Game testGame = new GameMock();
		testGame.addExecutedCommand(new CommandMock());
		testGame.addExecutedCommand(new CommandMock());
		assertEquals(2, testGame.getNumberOfExecutedCommands());
	}

	// ClearEvents
	@Test
	public void testClearEvents() {
		Game testGame = new GameMock();
		testGame.clearEvents();
		assertFalse(testGame.hasEvents());
	}

	// ClearExecutedCommands
	@Test
	public void testClearExecutedCommands() {
		Game testGame = new GameMock();
		testGame.clearExecutedCommands();
		assertEquals(0, testGame.getNumberOfExecutedCommands());
	}

	// End
	@Test
	public void testEnd() {
		Game testGame = new GameMock();
		testGame.end();
		assertTrue(testGame.isEnded());
	}

	// GetItemsFromInventory
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testGetNullItemsFromInventory() {
		Game testGame = new GameMock();
		testGame.getItemsFromInventory(null);
	}

	@Test
	public void testGetItemsFromInventory() {
		Game testGame = new GameMock();
		Item temp = new ItemMock();
		assertEquals(0, testGame.getItemsFromInventory(temp.getName()).size());
	}

	// GetItemsFromLocation
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testGetNullItemsFromLocation() {
		Game testGame = new GameMock();
		testGame.getItemsFromLocation(null);
	}

	@Test
	public void testGetItemsFromLocation_mockName() {
		Game game = new GameMock();
		Item temp = new ItemMock();
		assertEquals(0, game.getItemsFromLocation(temp.getName()).size());
	}

	// GetNumberExecutedCommands
	@Test
	public void testGetNumberOfExecutedCommands() {
		Game testGame = new GameMock();
		assertEquals(0, testGame.getNumberOfExecutedCommands());
	}

	// HasConnectedLocation
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testHasNullConnectedLocation() {
		Game testGame = new GameMock();
		testGame.hasConnectedLocation(null);
	}

	@Test
	public void testHasConnectedLocation() {
		Game testGame = new GameMock();
		assertFalse(testGame.hasConnectedLocation(Direction.SOUTH));
	}

	// IsEnded
	@Test
	public void testIsEnded() {
		Game testGame = new GameMock();
		assertFalse(testGame.isEnded());
		testGame.end();
		assertTrue(testGame.isEnded());
	}

	// IsItemInInventory
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testIsNullItemInInventory() {
		Game testGame = new GameMock();
		testGame.isItemInInventory(null);
	}

	// IsItemInLocation
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testIsItemInLocation_nullItem() {
		Game testGame = new GameMock();
		testGame.isItemInLocation(null);
	}

	// MoveItemFromInventoryToLocation
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testMoveNullItemFromInventoryToLocation() {
		Game testGame = new GameMock();
		testGame.moveItemFromInventoryToLocation(null);
	}

	@Test(expected = ItemNotInRepositoryException.class)
	public void testMoveNotItemFromInventoryToLocation() {
		Game testGame = new GameMock();
		testGame.moveItemFromInventoryToLocation(new ItemMock());
	}


	@Test(expected = ItemAlreadyInRepositoryException.class)
	public void testMoveRepeatedItemFromInventoryToLocation() {

		Location location = new LocationMock();
		Item item = new ItemMock();
		location.addItem(item);
		Game testGame = new GameMock(location);

		testGame.moveItemFromLocationToInventory(item);
		location.addItem(item);

		testGame.moveItemFromInventoryToLocation(item);
	}

	//MoveItemFromLocationToInventory 
	//Misma metodología que el anterior

	//MovePlayer
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testMovePlayerNull() {
		Game testGame = new GameMock();
		testGame.movePlayer(null);
	}

	@Test(expected = NoConnectedLocationException.class)
	public void testMovePlayerNotConnected() {
		Game game = new GameMock();
		game.movePlayer(Direction.SOUTH);
	}

	// RemoveNewestExecutedCommand
	@Test
	public void testRemoveNewestExecutedCommand() {
		Game testGame = new GameMock();
		Command oldone = new CommandMock();
		Command newone = new CommandMock();
		testGame.addExecutedCommand(oldone);
		testGame.addExecutedCommand(newone);

		assertSame(newone,
				testGame.removeNewestExecutedCommand());
	}

	// RemoveOldestExecutedCommand
	@Test
	public void testRemoveOldestExecutedCommand() {
		Game testGame = new GameMock();
		Command oldone = new CommandMock();
		Command newone = new CommandMock();
		testGame.addExecutedCommand(oldone);
		testGame.addExecutedCommand(newone);

		assertSame(oldone,
				testGame.removeOldestExecutedCommand());
	}
		
	// CommandCount
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullCommandCount() {
		Game testGame = new GameMock();
		testGame.commandCount((Command)null);
	}
	
	@Test
	public void testCommandCount() {
		Game testGame = new GameMock();

		Command com1 = new GoCommand(testGame);
		Command com2 = new GoCommand(testGame);
		Command com3 = new DropCommand(testGame);
		
		testGame.commandCount(com1);
		testGame.commandCount(com2);
		testGame.commandCount(com3);
				
		assertEquals(testGame.getNumberOfExecutedCommands("GoCommand"),2);
	}
	
	// testGetTotalNumberOfExecutedCommands
	@Test
	public void testGetTotalNumberOfExecutedCommands() {
		Game testGame = new GameMock();
		
		Command com1 = new GoCommand(testGame);
		Command com2 = new GoCommand(testGame);
		Command com3 = new DropCommand(testGame);
		Command com4 = new TakeCommand(testGame);
		
		testGame.commandCount(com1);
		testGame.commandCount(com2);
		testGame.commandCount(com3);
		testGame.commandCount(com4);
		
		assertEquals(testGame.getTotalNumberOfExecutedCommands(),4);
	}
	
	// testGetNumberOfExecutedCommands
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullNumberOfExecutedCommands() {
		Game testGame = new GameMock();
		
		testGame.getNumberOfExecutedCommands((String)null);
	}

	@Test
	public void testNumberOfExecutedCommands() {
		Game testGame = new GameMock();
		
		Command com1 = new GoCommand(testGame);
		Command com2 = new GoCommand(testGame);
		Command com3 = new DropCommand(testGame);
		
		testGame.commandCount(com1);
		testGame.commandCount(com2);
		testGame.commandCount(com3);
		
		assertEquals(testGame.getNumberOfExecutedCommands("GoCommand"),2);
	}
	
	//testGetCommandPercentage
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullGetCommandPercentage() {
		Game testGame = new GameMock();
		testGame.getCommandPercentage((String)null);
	}
	
	@Test
	public void testGetCommandPercentage() {
		Game testGame = new GameMock();
		
		Command com1 = new GoCommand(testGame);
		Command com2 = new GoCommand(testGame);
		Command com3 = new DropCommand(testGame);
		Command com4 = new TakeCommand(testGame);
		
		testGame.commandCount(com1);
		testGame.commandCount(com2);
		testGame.commandCount(com3);
		testGame.commandCount(com4);
		
		assertEquals(testGame.getCommandPercentage("GoCommand"), 50);
	}
	
	//testGetCurrentLocation
	
}
