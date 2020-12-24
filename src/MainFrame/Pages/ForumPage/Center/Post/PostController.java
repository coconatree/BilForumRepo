package MainFrame.Pages.ForumPage.Center.Post;

import MainFrame.MainFrameModel;

public class PostController
{
    private PostView PV;
    private PostModel PM;

    private MainFrameModel ref;

    public PostController(PostView view, PostModel model, MainFrameModel ref)
    {
        this.PV = view;
        this.PM = model;

        this.ref = ref;

    }
}
