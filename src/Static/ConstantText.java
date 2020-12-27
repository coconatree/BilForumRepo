package Static;

public class ConstantText
{
    private static final String FORUM_PAGE_LEFT_TEXT = "Please be kind to other users end do not use any words which may offend others.\n";

    private static final String TOP_POSTS_TEXT = "TOP 10 POSTS";

    private static final String POST_CREATION_PAGE_SYNTAX = "Syntax Language Mini Manuel \n Hello <COMMAND> There <COMMAND> !!! \n Commands: \n" +
            "<Color> - </Color> where colors ara Blue - Red - Green. \n <Font**> - </Font**> from 15 to 40. " +
            "\n <Bold> - </Bold> \n <Italic> - </Italic> \n <CodeBlock> - </CodeBlock> creates a code block. \n </endl> ends the line. \n <Bold_Font**> - <Bold_Font**> from 15 t0 40. \n " +
            "<Italic_Font**> - </Italic_Font**> from 15 to 40. \n <Color_Font**> - </Color_Font**> from 15 to 40 and colors are Blue - Red - Green.";

    private static final String POST_CREATION_PAGE_TAGS = "Here is where you enter the tags relevant to your post.";

    /*******************************************************************************/

    public static String getForumPageLeftText()
    {
        return FORUM_PAGE_LEFT_TEXT;
    }

    public static String getTopPostsText() {
        return TOP_POSTS_TEXT;
    }

    public static String getPostCreationPageSyntax()
    {
        return POST_CREATION_PAGE_SYNTAX;
    }

    public static String getPostCreationPageTags(){ return POST_CREATION_PAGE_TAGS; }
}
