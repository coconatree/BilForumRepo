package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class POCenterView extends CustomJPanel implements IPOCenterView {

    @Override
    public void update(POCenterModel model)
    {
        this.init(model);
    }

    private void init(POCenterModel model) {

        MigLayout panel1Layout = new MigLayout("debug"," [grow]", String.format("[grow]20[%s]",model.getSc().getHEIGHT_RATIO()*5));
        model.getPanel1().setLayout(panel1Layout);

        MigLayout panel1Toplayout = new MigLayout("inset 0 0 0 0", "[grow]", "[10]15[10]15[10]15[10]");
        model.getPanel1Top().setLayout(panel1Toplayout);

        model.getPanel1Top().add(model.getPointsLabel(),"grow");
        model.getPanel1Top().add(model.getVoteUpButton(), "grow");
        model.getPanel1Top().add(model.getVoteDownButton(), "grow");
        model.getPanel1Top().add(model.getTitleLabel(), "grow");
        model.getPanel1Top().add(model.getDateLabel(), "grow");
        model.getPanel1().add(model.getPanel1Top(),"wrap");
        /****************************************************************/
        MigLayout panel1CenterLayout = new MigLayout("debug"," [grow]", String.format("[grow]20[%s]",model.getSc().getHEIGHT_RATIO()*50));
        model.getPanel1Center().setLayout(panel1CenterLayout);
        model.getPanel1Center().add(model.getContentLabel(),"grow");
        model.getPanel1().add(model.getPanel1Center(),"wrap");
        /****************************************************************/
        MigLayout panel1BottomLayout = new MigLayout("debug"," [grow]", String.format("[grow]20[%s]",model.getSc().getHEIGHT_RATIO()*50));
        model.getPanel1Bottom().setLayout(panel1BottomLayout);
        model.getPanel1Bottom().add(new JLabel("COMMENTS AREA"),"grow");
        model.getPanel1().add(model.getPanel1Bottom());
        /****************************************************************/
        /****************************************************************/
        /****************************************************************/
        MigLayout panel4Layout = new MigLayout("inset 0 0 0 0", "[grow]", "[10]15[10]15[10]15[10]");
        model.getPanel4().setLayout(panel4Layout);
        model.getPanel4().add(model.getEditButton());
        model.getPanel4().add(model.getDeleteButton());
        model.getPanel4().add(model.getPostButton());
        /*****************************************************************/

        MigLayout layout = new MigLayout("debug, inset 0 0 0 0","[grow]","[grow]5[grow]5[grow]5[10]");
        this.setLayout(layout);
        this.add(model.getPanel1(),"grow,wrap");
        this.add(model.getPanel2(),"grow,wrap");
        this.add(model.getPanel3(), "grow, wrap");
        this.add(model.getPanel4(),"grow");

    }
}
