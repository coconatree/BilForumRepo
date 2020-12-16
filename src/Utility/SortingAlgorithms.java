package Utility;

import PojoClasses.Post;

import java.util.ArrayList;

public class SortingAlgorithms
{
    public static void sortPostListByVotes(ArrayList<Post> list)
    {
        int n = list.size();

        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (Integer.valueOf(list.get(j).getVotes()) > Integer.valueOf(list.get(j + 1).getVotes()))
                {
                    Post temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void sortPostListByViews(ArrayList<Post> list)
    {
        int n = list.size();

        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (Integer.valueOf(list.get(j).getViews()) > Integer.valueOf(list.get(j + 1).getViews()))
                {
                    Post temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

}
