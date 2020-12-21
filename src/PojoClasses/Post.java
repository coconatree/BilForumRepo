package PojoClasses;

import java.util.ArrayList;

public class Post
{
    private String id;

    private String views;
    private String votes;

    /***********************************************************************************/

    private String title;
    private String content;

    private String author;
    private String date;

    private String tags;

    private ArrayList<String> comments;
    private ArrayList<String> anwsers;

    /***********************************************************************************/

    public Post()
    {

    };

    /***********************************************************************************/

    public Post(String id, String views, String votes, String title, String content, String author, String date, String tags)
    {
        this.id = id;
        this.views = views;
        this.votes = votes;
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.tags = tags;
    }

    /***********************************************************************************/

    @Override
    public String toString()
    {
        return String.format("Id: %s - Views: %s - Votes: %s - Title: %s - Content: %s - Author: %s - Date: %s Tags: %s",

                this.id,
                this.views,
                this.votes,
                this.title,
                this.content,
                this.author,
                this.date,
                this.tags

                );
    }

    /***********************************************************************************/

    public String getId()
    {
        return id;
    }

    public String getViews()
    {
        return views;
    }

    public String getVotes()
    {
        return votes;
    }

    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getDate()
    {
        return date;
    }

    /***********************************************************************************/

    public void setId(String id)
    {
        this.id = id;
    }

    public void setViews(String views)
    {
        this.views = views;
    }

    public void setVotes(String votes)
    {
        this.votes = votes;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

}
