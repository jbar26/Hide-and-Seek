package org.example;

import java.util.ArrayList;
public class FuzzyFinder
{
    public int linearSearch(ArrayList<Feeling> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            Feeling temp = list.get(i);
            if(temp.description().equals("gold"))
            {
                    return i;
            }
        }
        return -1;
    }

    // Add-on: New search function that finds the index of the cold prickly instead of warm fuzzy
    public int linearSearchPrickly(ArrayList<Feeling> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            Feeling temp = list.get(i);
            if(temp.description().equals("pokey!"))
            {
                return i;
            }
        }
        return -1;
    }


    public int binarySearch(ArrayList<Feeling> list)
    {
        return binarySearchHelper(list, 0, list.size()-1, "gold");
    }
    // Add-on: New search function that finds the index of the cold prickly instead of warm fuzzy
    // Uses same recursive helper method as the gold Fuzzy
    public int binarySearchPrickly(ArrayList<Feeling> list)
    {
        return binarySearchHelper(list, 0, list.size() - 1, "pokey!");
    }
    private int binarySearchHelper(ArrayList<Feeling> list, int low, int high, String target)
    {
        if (low > high)
        {
            return -1;
        }
        else
        {
            int mid = (low + high)/2;
            Feeling temp = list.get(mid);
            if(temp.description().equals(target))
            {
                return mid;
            }
            else if (temp.description().compareTo(target) < 0)
            {
                return binarySearchHelper(list, mid + 1, high, target);
            }
            else
            {
                return binarySearchHelper(list, low, mid - 1, target);
            }
        }
    }

}
