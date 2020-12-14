package Static;

public class ConstantText
{
    private static final String FORUM_PAGE_LEFT_TEXT = "The action listeners figure out which button was clicked and call the appropriate controller method. The issue is that this controller method needs to update another view.";

    private static final String TOP_POSTS_TEXT = "TOP 10 POSTS";

    private static final String POST_CREATION_PAGE_SYNTAX = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren Letraset yapraklarının yayınlanması ile ve yakın zamanda Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü yayıncılık yazılımları ile popüler olmuştur.";

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
}
