package PojoClasses;
import java.util.ArrayList;

/**
 * __Basic Forum Object Class ___
 * @author __Can Yılmaz___
 * @version __06.12.2020__
 */
public class Forum
{

    private String title ;
    private String creationDate ;
    private ArrayList<Post> postList ;
    private int postCount ;



    /*******************************************************************************************/

    public Forum(String title, ArrayList<Post> postList , String creationDate) {
        this.title = title;
        this.postList = postList;
        this.creationDate = creationDate;
        postCount = postList.size();
    }

    /*******************************************************************************************/

    public void addPost( Post post){
        postList.add( post );
    }

    public void removePost( Post post){
        postList.remove( post );
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public String getCreationDate() {
        return creationDate;
    }
}
