package com.revature.garbage;

/*
 * Java is a memory-managed language.
 * This means that the JVM will automatically clean up resources as they
 * leave scope (or otherwise become inaccessible).  As such, it is important
 * that we let things leave scope when we are done with them.
 * 
 * Garbage Collection is a process that is started at the JVM level occasionally
 * when it detects that it needs to recover memory. We cannot manually
 * start the garbage collection. We can, however, request that garbage collection
 * run, by calling `System.gc();`. There is no guarantee that this will actually
 * trigger garbage collection, but generally it does. It's highly discouraged to
 * attempt to manage the memory yourself by telling the JVM when to run garbage
 * collection. 
 *
 */
public class GarbageCollection {
	public static void main(String[] args) {
		for(int i = 0; i < 10_000_000; i++) {
			new Garbage();
			if (i % 10_000 == 0) {
				System.out.printf("Created: %d, Cleaned: %d%n",
						Garbage.created, Garbage.cleanedUp);
			}
		}
	}
	
}

class Garbage {
	static long created = 0;
	static long cleanedUp = 0;
	static String[] messages = { "Ahh!", "Oh no!", "Eek!" };
	double myDouble = Math.random();

	{
		created++;
	}
	
	/*
	 * A method that 'should' be called right before an object is garbage
	 * collected.
	 */
	@Override
	public void finalize() {
		cleanedUp++;
	}
}