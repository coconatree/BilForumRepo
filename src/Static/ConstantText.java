package Static;

public class ConstantText
{
    private static final String FORUM_PAGE_LEFT_TEXT = "The action listeners figure out which button was clicked and call the appropriate controller method. The issue is that this controller method needs to update another view.";

    private static final String TOP_POSTS_TEXT = "TOP 10 POSTS";
    /*******************************************************************************/

    public static String getForumPageLeftText()
    {
        return FORUM_PAGE_LEFT_TEXT;
    }

    public static String getTopPostsText() {
        return TOP_POSTS_TEXT;
    }
}
