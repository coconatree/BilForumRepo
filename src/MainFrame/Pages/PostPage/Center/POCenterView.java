package MainFrame.Pages.PostPage.Center;

import MainFrame.CustomComponents.CustomJPanel;
import MainFrame.Pages.ForumPage.Center.Post.PostModel;
import Static.Colors;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class POCenterView extends CustomJPanel implements IPOCenterView {

    @Override
    public void update(POCenterModel model)
    {
        this.init(model);
    }

    private void init(POCenterModel model)
    {
        MigLayout layout1Sub1 = new MigLayout("inset 0 0 0 0", "[grow]", "[grow]5[grow]");
        model.getP1().setLayout(layout1Sub1);

        model.getP1().add(model.getPointsLabel2(), "center, wrap");
        model.getP1().add(model.getPointsLabel1(), "center");

        model.getP1().setBorder(BorderFactory.createLineBorder(Colors.SECONDARY_COLOR));

        /****************************************************************************/

        MigLayout layout1Sub2 = new MigLayout("inset 0 0 0 0", "[grow]", "[grow]");
        model.getP2().setLayout(layout1Sub2);

        model.getP2().add(model.getTitleLabel2(), "center");

        /****************************************************************************/

        MigLayout layout1 = new MigLayout("inset 5 5 5 5", String.format("[150]15[%d]5[grow]5[%d]", model.getSc().getWIDTH_RATIO() * 5, model.getSc().getWIDTH_RATIO() * 5), "[grow]");
        model.getPanel1().setLayout(layout1);

        model.getPanel1().add(model.getP1(), "grow");
        model.getPanel1().add(model.getAuthor(), "grow");
        model.getPanel1().add(model.getP2(), "grow");
        model.getPanel1().add(model.getDate(), "grow");

        /****************************************************************************/

        MigLayout layout2 = new MigLayout("inset 50 70 20 10", "[grow]", "[grow]");
        model.getPanel2().setLayout(layout2);

        model.getPanel2().add(model.getContent(), "grow");

        model.getPanel2().setBorder(BorderFactory.createLineBorder(Colors.SECONDARY_COLOR));

        /****************************************************************************/

        MigLayout layout3 = new MigLayout("inset 0 70 0 70", String.format("5[%d]5[%d]5[grow]5[%d]5[%d]5",
                model.getSc().getWIDTH_RATIO() * 7,
                model.getSc().getWIDTH_RATIO() * 7,
                model.getSc().getWIDTH_RATIO() * 7,
                model.getSc().getWIDTH_RATIO() * 7)
                , "[grow]"
        );

        model.getPanel3().setLayout(layout3);

        model.getPanel3().add(model.getVoteUpButton(), "grow");
        model.getPanel3().add(model.getVoteDownButton(), "grow");
        model.getPanel3().add(model.getFiller() , "grow");
        model.getPanel3().add(model.getEditButton(), "grow");
        model.getPanel3().add(model.getDeleteButton(), "grow");

        /****************************************************************************/

        MigLayout layout4Sub1 = new MigLayout("inset 0 0 0 0", "[grow]5[70]", "[10]");
        model.getP3().setLayout(layout4Sub1);

        model.getP3().add(model.getCommentTf(), "grow");
        model.getP3().add(model.getPostComment(), "center");

        /****************************************************************************/

        MigLayout layout4Sub2 = new MigLayout("inset 0 0 0 20", "[grow]", this.generateString(model.getComments().size()));
        model.getP4().setLayout(layout4Sub2);

        for(String comment : model.getComments())
        {
            model.getP4().add(model.getLabelWithText(comment),"grow, wrap");
        }

        /****************************************************************************/

        MigLayout layout4 = new MigLayout("", "[grow]", "[grow]5[10]");
        model.getPanel4().setLayout(layout4);

        model.getPanel4().add(model.getP4(), "grow, wrap");
        model.getPanel4().add(model.getP3(), "grow");


        /****************************************************************************/

        /****************************************************************************/

        /****************************************************************************/

        MigLayout layout5 = new MigLayout();
        MigLayout layout6 = new MigLayout();

        MigLayout layoutM = new MigLayout("inset 0 0 0 0", "[grow]", String.format("[%d]5[%d][%d][grow]",
                model.getSc().getHEIGHT_RATIO() * 15,
                model.getSc().getHEIGHT_RATIO() * 70,
                model.getSc().getHEIGHT_RATIO() * 5
        ));

        this.setLayout(layoutM);

        this.add(model.getPanel1(), "grow, wrap");
        this.add(model.getPanel2(), "grow, wrap");
        this.add(model.getPanel3(), "grow, wrap");
        this.add(model.getPanel4(), "grow, wrap");

        /**
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

        MigLayout panel1CenterLayout = new MigLayout("debug"," [grow]", String.format("[grow]20[%s]",model.getSc().getHEIGHT_RATIO()*50));
        model.getPanel1Center().setLayout(panel1CenterLayout);
        model.getPanel1Center().add(model.getContentLabel(),"grow");
        model.getPanel1().add(model.getPanel1Center(),"wrap");

        MigLayout panel1BottomLayout = new MigLayout("debug"," [grow]", String.format("[grow]20[%s]",model.getSc().getHEIGHT_RATIO()*50));
        model.getPanel1Bottom().setLayout(panel1BottomLayout);
        model.getPanel1Bottom().add(new JLabel("COMMENTS AREA"),"grow");
        model.getPanel1().add(model.getPanel1Bottom());

        MigLayout panel4Layout = new MigLayout("inset 0 0 0 0", "[grow]", "[10]15[10]15[10]15[10]");
        model.getPanel4().setLayout(panel4Layout);
        model.getPanel4().add(model.getEditButton());
        model.getPanel4().add(model.getDeleteButton());
        model.getPanel4().add(model.getPostButton());


        MigLayout layout = new MigLayout("debug, inset 0 0 0 0","[grow]","[grow]5[grow]5[grow]5[10]");
        this.setLayout(layout);
        this.add(model.getPanel1(),"grow,wrap");
        this.add(model.getPanel2(),"grow,wrap");
        this.add(model.getPanel3(), "grow, wrap");
        this.add(model.getPanel4(),"grow");
        */
    }

    private String generateString(int size)
    {
        String ret = "";

        for(int i = 0; i < size; i++)
        {
            if(i == 0){ ret += "[grow]"; }
            else{ ret += "5[grow]"; }
        }
        return ret;
    }
}
