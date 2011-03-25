package es.ucm.fdi.lps.p4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.ucm.fdi.lps.p4.Game.Direction;
import es.ucm.fdi.lps.p4.Item;
import es.ucm.fdi.lps.p4.Obstacle;

public class ObstacleTest {

	// Obstacle constructor
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullIdObstacle() {
		new Obstacle((String) null, "MockName", "MockDescription", true,
				"MockErrorMsg", Direction.NORTH);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullNameObstacle() {
		new Obstacle("MockId", (String) null, "MockDescription", true,
				"MockErrorMsg", Direction.NORTH);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullDescriptionObstacle() {
		new Obstacle("MockId", "MockName", (String) null, true, "MockErrorMsg",
				Direction.NORTH);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullErrorMsgObstacle() {
		new Obstacle("MockId", "MockName", "MockDescription", true,
				(String) null, Direction.NORTH);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNullDirectionObstacle() {
		new Obstacle("MockId", "MockName", "MockDescription", true,
				"MockErrorMsg", (Direction) null);
	}

	@Test
	public void testObstacle() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		assertEquals("MockId", obs.getId());
		assertEquals("MockName", obs.getName());
		assertEquals("MockDescription", obs.getDescription());
		assertTrue(obs.getStatus());
		assertEquals("MockErrorMsg", obs.getErrorMsg());
		assertEquals(Direction.NORTH, obs.getDirection());
	}

	@Test
	public void testGetId() {
		Obstacle obs = new Obstacle("testID", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		assertEquals("testID", obs.getId());
	}

	@Test
	public void testGetName() {
		Obstacle obs = new Obstacle("MockId", "testName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		assertEquals("testName", obs.getName());
	}

	@Test
	public void testGetDescription() {
		Obstacle obs = new Obstacle("MockId", "MockName", "testDescription",
				true, "MockErrorMsg", Direction.NORTH);
		assertEquals("testDescription", obs.getDescription());
	}

	@Test
	public void testGetErrorMsg() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "testErrorMsg", Direction.NORTH);
		assertEquals("testErrorMsg", obs.getErrorMsg());
	}

	@Test
	public void testGetStatus() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		assertTrue(obs.getStatus());
	}

	@Test
	public void testGetDirection() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		assertEquals(Direction.NORTH, obs.getDirection());
	}

	@Test
	public void testGetBoundedItems() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		Item it1 = new Item("it1", "Item1", "Test Item 1", 0, 0);
		Item it2 = new Item("it2", "Item2", "Test Item 2", 0, 0);

		List<Item> tempList = new ArrayList<Item>();

		tempList.add(it1);
		tempList.add(it2);

		obs.addBoundedItem(it1);
		obs.addBoundedItem(it2);

		assertTrue(tempList.containsAll(obs.getBoundedItems()));
	}

	@Test
	public void testHasBoundedItems() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		
		assertFalse(obs.hasBoundedItems());
		
		Item it1 = new Item("it1", "Item1", "Test Item 1", 0, 0);
		obs.addBoundedItem(it1);
		
		assertTrue(obs.hasBoundedItems());
	}

	@Test
	public void testHasBoundedObstacles() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		
		
		assertFalse(obs.hasBoundedObstacles());
		
		Obstacle boundedObs = new Obstacle("boundedMockId", "boundedMockName", "boundedMockDescription",
				true, "boundedMockErrorMsg", Direction.SOUTH);
		obs.addBoundedObstacle(boundedObs);
		
		assertTrue(obs.hasBoundedObstacles());
	}

	@Test
	public void testGetBoundedObstacles() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		Obstacle boundedObs1 = new Obstacle("boundedMockId1", "boundedMockName1", "boundedMockDescription1",
				true, "boundedMockErrorMsg1", Direction.SOUTH);
		Obstacle boundedObs2 = new Obstacle("boundedMockId2", "boundedMockName2", "boundedMockDescription2",
				true, "boundedMockErrorMsg2", Direction.SOUTH);

		List<Obstacle> tempList = new ArrayList<Obstacle>();

		tempList.add(boundedObs1);
		tempList.add(boundedObs2);

		obs.addBoundedObstacle(boundedObs1);
		obs.addBoundedObstacle(boundedObs2);

		assertTrue(tempList.containsAll(obs.getBoundedObstacles()));
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testAddNullBoundedItem() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		obs.addBoundedItem((Item)null);
	}
	
	@Test
	public void testAddBoundedItem() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		Item it1 = new Item("it1", "Item1", "Test Item 1", 0, 0);
		assertTrue(obs.addBoundedItem(it1));
		assertTrue(obs.getBoundedItems().contains(it1));
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testRemoveNullBoundedItem() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		obs.removeBoundedItem((Item)null);
	}
	
	@Test
	public void testRemoveBoundedItem() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		Item it1 = new Item("it1", "Item1", "Test Item 1", 0, 0);
		Item it2 = new Item("it2", "Item2", "Test Item 2", 0, 0);
		obs.addBoundedItem(it1);
		obs.addBoundedItem(it2);
		
		obs.removeBoundedItem(it1);
		assertTrue(!obs.getBoundedItems().contains(it1));
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testAddNullBoundedObstacle() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		obs.addBoundedObstacle((Obstacle)null);
	}

	@Test
	public void testAddBoundedObstacle() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		Obstacle boundedObs1 = new Obstacle("boundedMockId1", "boundedMockName1", "boundedMockDescription1",
				true, "boundedMockErrorMsg1", Direction.SOUTH);
		
		assertTrue(obs.addBoundedObstacle(boundedObs1));
		assertTrue(obs.getBoundedObstacles().contains(boundedObs1));
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testRemoveNullBoundedObstacle() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		obs.removeBoundedObstacle((Obstacle)null);
	}
	@Test
	public void testRemoveBoundedObstacle() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		Obstacle boundedObs1 = new Obstacle("boundedMockId1", "boundedMockName1", "boundedMockDescription1",
				true, "boundedMockErrorMsg1", Direction.SOUTH);
		Obstacle boundedObs2 = new Obstacle("boundedMockId2", "boundedMockName2", "boundedMockDescription2",
				true, "boundedMockErrorMsg2", Direction.SOUTH);

		obs.addBoundedObstacle(boundedObs1);
		obs.addBoundedObstacle(boundedObs2);
		
		obs.removeBoundedObstacle(boundedObs1);
		assertTrue(!obs.getBoundedObstacles().contains(boundedObs1));
	}
	
	@Test
	public void testChangeStatusBoundedObstacles() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		Obstacle boundedObs1 = new Obstacle("boundedMockId1", "boundedMockName1", "boundedMockDescription1",
				false, "boundedMockErrorMsg1", Direction.SOUTH);
		obs.addBoundedObstacle(boundedObs1);
		obs.changeStatus();
		assertFalse(obs.getStatus());
		Obstacle tempObs = (Obstacle) obs.getBoundedObstacles().toArray()[0];
		assertTrue(tempObs.getStatus());
	}

	@Test
	public void testChangeStatus() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		obs.changeStatus();
		assertFalse(obs.getStatus());
	}

	@Test
	public void testToString() {
		Obstacle obs = new Obstacle("MockId", "MockName", "MockDescription",
				true, "MockErrorMsg", Direction.NORTH);
		assertEquals(obs.toString(), "Obstacle[MockName]");
	}

}
