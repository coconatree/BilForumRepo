package PojoClasses;
import APIConnection.APIConnection;

import java.util.ArrayList;

/**
 * __Basic Forum Object Class ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */

public class Forum
{
    private String id;
    private String name;

    private ArrayList<Post> postList;

    public Forum()
    {

    }

    public Forum(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    /**************************************************************************/

    public void setupPostList()
    {
        try
        {
            this.postList =  APIConnection.getAllPostOfAForum(this.id);
        }
        catch (Exception exception)
        {
            this.postList = new ArrayList<Post>();

            this.postList.add(new Post("ERRORPOST", "12", "12", "ERRORPOST", "ERRORPOST", "ERRORPOST", "ERRORPOST", "ERRORPOST"));

            exception.printStackTrace();
        }
    }

    public String getId() { return this.id; }

    public String getName()
    {
        return this.name;
    }

    public ArrayList<Post> getPostList()
    {
        this.setupPostList();
        return this.postList;
    }
}
