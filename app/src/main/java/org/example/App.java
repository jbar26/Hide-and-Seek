package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class App {
  public static void main(String[] args)
  {
    FuzzyFinder finder = new FuzzyFinder();
    FuzzyListGenerator generator = new FuzzyListGenerator();

    ArrayList<Feeling> sortedFuzzies = generator.sortedRainbowFuzzies();
    ArrayList<Feeling> randomFuzzies = generator.randomizedRainbowFuzzies();

    int testOne = finder.linearSearch(sortedFuzzies);
    int testTwo = finder.binarySearch(sortedFuzzies);
    int testThree = finder.linearSearch(randomFuzzies);
    int testFour = finder.binarySearch(randomFuzzies);

    System.out.println("Test 1 Linear Search of the Sorted List: " + testOne);
    System.out.println("Test 2 Binary Search of the Sorted List: " + testTwo);
    System.out.println("The two indices above should be the same.");
    System.out.println("Test 3 Linear Search of the Randomized List: " + testThree);
    System.out.println("Test 4 Binary Search of the Randomized List: " + testFour);
    System.out.println("The two indices above should be the same, but since the list is not sorted, the binary search will not work.");

    // Add-ons:
    int testOnePrickly = finder.linearSearchPrickly(sortedFuzzies);
    int testTwoPrickly = finder.binarySearchPrickly(sortedFuzzies);
    int testThreePrickly = finder.linearSearchPrickly(randomFuzzies);
    int testFourPrickly = finder.binarySearchPrickly(randomFuzzies);
    System.out.println("\n\nLinear Search for Prickly of the Sorted List: " + testOnePrickly);
    System.out.println("Binary Search for Prickly of the Sorted List: " + testTwoPrickly);
    System.out.println("The two indices above should be the same.");
    System.out.println("Linear Search for Prickly of the Randomized List: " + testThreePrickly);
    System.out.println("Binary Search for Prickly of the Randomized List: " + testFourPrickly);
    System.out.println("Binary Search on a Randomized List still doesn't work");

  }
}
