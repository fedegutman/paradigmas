package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class QueueTest {

	private static String EmptyQueue = "Queue is empty";
	private static String SecondItem = "Second";
	private static String FirstItem = "First";
	private static String something = "Something";

	@Test
	public void test01QueueShouldBeEmptyWhenCreated() {
		assertTrue(new Queue().isEmpty());
	}

	@Test
	public void test02AddElementsToTheQueue() {
		assertFalse(queueWithSomething().isEmpty());
	}

	@Test
	public void test03AddedElementsIsAtHead() {
		assertEquals(something, queueWithSomething().head());
	}

	@Test
	public void test04TakeRemovesElementsFromTheQueue() {
		Queue queue = queueWithSomething();
		queue.take();

		assertTrue(queue.isEmpty());
	}

	@Test
	public void test05TakeReturnsLastAddedObject() {
		assertEquals(something, queueWithSomething().take());
	}

	@Test
	public void test06QueueBehavesFIFO() {
		Queue queue = queueWithFirstAndSecondItems();

		assertEquals(queue.take(), FirstItem);
		assertEquals(queue.take(), SecondItem);
		assertTrue(queue.isEmpty());
	}

	@Test
	public void test07HeadReturnsFirstAddedObject() {
		assertEquals(queueWithFirstAndSecondItems().head(), FirstItem);
	}

	@Test
	public void test08HeadDoesNotRemoveObjectFromQueue() {
		Queue queue = queueWithSomething();
		assertEquals(1, queue.size());
		queue.head();
		assertEquals(1, queue.size());
	}

	@Test
	public void test09SizeRepresentsObjectInTheQueue() {
		assertEquals(2, queueWithFirstAndSecondItems().size());
	}

	@Test
	public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
		Queue queue = new Queue();
        assertEquals(assertThrows(Error.class, () -> queue.take()).getMessage(), EmptyQueue);
	}

	@Test
	public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
		Queue queue = queueWithSomething();
		queue.take();
        assertEquals(assertThrows(Error.class, () -> queue.take()).getMessage(), EmptyQueue);
	}

	@Test
	public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
		Queue queue = new Queue();
        assertEquals(assertThrows(Error.class, () -> queue.head()).getMessage(), EmptyQueue);
	}

	private Queue queueWithSomething() {
		return new Queue().add(something);
	}

	private Queue queueWithFirstAndSecondItems() {
		Queue queue = new Queue().add(FirstItem).add(SecondItem);
		return queue;
	}

}