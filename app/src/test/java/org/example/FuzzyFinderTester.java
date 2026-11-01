package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

class FuzzyFinderTester
{
  FuzzyFinder finder = new FuzzyFinder();
  Fuzzy f0 = new Fuzzy("gold");  //f0 is the gold fuzzy
  Fuzzy f1 = new Fuzzy("red");
  Fuzzy f2 = new Fuzzy("orange");
  Fuzzy f3 = new Fuzzy("yellow");
  Fuzzy f4 = new Fuzzy("green");
  Fuzzy f5 = new Fuzzy("blue");
  Fuzzy f6 = new Fuzzy("indigo");
  Fuzzy f7 = new Fuzzy("violet");
  Prickly p = new Prickly();

  @Test
  void testlinearSearch0FirstIndex()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, f1, f2, f3, f4, f5, f6, f7));
    assertEquals(0, finder.linearSearch(list));
  }
  @Test
  void testlinearSearch1()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f1, f0, f2, f3, f4, f5, f6, f7));
    assertEquals(1, finder.linearSearch(list));
  }
  @Test
  void testlinearSearch4()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f1, f4, f2, f3, f0, f5, f6, f7));
    assertEquals(4, finder.linearSearch(list));
  }
  @Test
  void testlinearSearch7LastIndex()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f1, f7, f2, f3, f4, f5, f6, f0));
    assertEquals(7, finder.linearSearch(list));
  }
  @Test
  void testlinearSearchNotFound()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f1, f7, f2, f3, f4, f5, f6));
    assertEquals(-1, finder.linearSearch(list));
  }
  @Test
  void testlinearSearchSorted()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f1, f7, f2, f3, f4, f5, f6, f0));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(1, finder.linearSearch(list));
  }


  // Test binarySearch
  @Test
  void testbinarySearchInMiddle()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f1, f7, f2, f3, f4, f5, f6, f0));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(1, finder.binarySearch(list));
  }
  @Test
  void testbinarySearchAtFirstIndex()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, f1, f7));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(0, finder.binarySearch(list));
  }
  @Test
  void testbinarySearchAtLastIndex()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, f5, f5));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(2, finder.binarySearch(list));
  }
  @Test
  void testbinarySearchNotFound()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f1, f2, f3, f4, f5, f6, f7));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(-1, finder.binarySearch(list));
  }


  // Test Add-Ons for LinearSearchPrickly
  @Test
  void testlinearSearchPrickly0FirstIndex()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(p, f0, f1, f2, f3, f4, f5, f6, f7));
    assertEquals(0, finder.linearSearchPrickly(list));
  }
  @Test
  void testlinearSearchPrickly1()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, p, f1, f2, f3, f4, f5, f6, f7));
    assertEquals(1, finder.linearSearchPrickly(list));
  }
  @Test
  void testlinearSearchPrickly2()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, f1, p, f2, f3, f4, f5, f6, f7));
    assertEquals(2, finder.linearSearchPrickly(list));
  }
  @Test
  void testlinearSearchPrickly5()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, f1, f2, f3, f4, p, f5, f6, f7));
    assertEquals(5, finder.linearSearchPrickly(list));
  }
  @Test
  void testlinearSearchPrickly8LastIndex()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, f1, f2, f3, f4, f5, f6, f7, p));
    assertEquals(8, finder.linearSearchPrickly(list));
  }
  @Test
  void testlinearSearchPricklyNotFound()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, f1, f2, f3, f4, f5, f6, f7));
    assertEquals(-1, finder.linearSearchPrickly(list));
  }
  @Test
  void testBinarySearchPricklyInMiddle()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f1, f7, f2, f3, f4, f5, f6, f0, p));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(5, finder.binarySearchPrickly(list));
  }
  @Test
  void testbinarySearchPricklyAtFirstIndex()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(p, f1, f7));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(0, finder.binarySearchPrickly(list));
  }
  @Test
  void testbinarySearchPricklyAtLastIndex()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(p, f0, f5, f5));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(3, finder.binarySearchPrickly(list));
  }
  @Test
  void testbinarySearchPricklyNotFound()
  {
    ArrayList<Feeling> list = new ArrayList<Feeling>(List.of(f0, f5, f5));
    list.sort((f1, f2) -> f1.description().compareTo(f2.description()));
    assertEquals(-1, finder.binarySearchPrickly(list));
  }
}
