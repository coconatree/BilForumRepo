package MainFrame.Pages.PostCreationPage;

public class PostCreationPageController
{
    IPostCreationPageView   postCreationPageView;
    IPostCreationPageModel postCreationPageModel;

    public PostCreationPageController(IPostCreationPageView postCreationPageView, IPostCreationPageModel postCreationPageModel)
    {
        this.postCreationPageView = postCreationPageView;
        this.postCreationPageModel = postCreationPageModel;
    }
}
