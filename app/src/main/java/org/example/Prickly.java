package org.example;

public class Prickly implements Feeling
{

    public String description()
    {
        return "pokey!";
        // Note: I made this "pokey" instead of "Pokey" so I could also write a binary search algorithm
        // and sort by description. If I left it "Pokey" it would always sort to the first element.
    }
}
