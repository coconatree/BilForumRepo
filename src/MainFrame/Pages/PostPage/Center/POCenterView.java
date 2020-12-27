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
        System.out.println("-------------------------------------------------");

        for(String str : model.getComments())
        {
            System.out.println(str);
        }

        System.out.println("-------------------------------------------------");

        model.getP4().removeAll();
        model.getPanel5().removeAll();

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

        MigLayout layout3 = new MigLayout("inset 0 70 0 70", String.format("5[%d]5[%d]5[grow]5[%d]",
                model.getSc().getWIDTH_RATIO() * 7,
                model.getSc().getWIDTH_RATIO() * 7,
                model.getSc().getWIDTH_RATIO() * 7)
                , "[grow]"
        );

        model.getPanel3().setLayout(layout3);

        model.getPanel3().add(model.getVoteUpButton(), "grow");
        model.getPanel3().add(model.getVoteDownButton(), "grow");
        model.getPanel3().add(model.getFiller() , "grow");
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

        MigLayout layout5 = new MigLayout("inset 0 0 0 0", "[grow]", this.generateString(model.getAnwsers().size()));
        model.getPanel5().setLayout(layout5);

        for(String answer : model.getAnwsers())
        {
            if(answer.length() != 0)
            {
                model.getPanel5().add(model.getAnswerComponent(answer.split("_")[0], answer.split("_")[1]), "grow, wrap");
            }
        }

        MigLayout subLayout = new MigLayout("", "[grow]5[10]", "[50]");
        model.getPanel7().setLayout(subLayout);

        model.getPanel7().add(model.getAnswerArea(), "grow");
        model.getPanel7().add(model.getAnswerButton(), "center");

        MigLayout layout6 = new MigLayout("", "[grow]", "[grow]5[20]");
        model.getPanel6().setLayout(layout6);

        model.getPanel6().add(model.getPanel5(), "grow, wrap");
        model.getPanel6().add(model.getPanel7(), "grow");


        MigLayout layoutM = new MigLayout("inset 0 0 0 0", "[grow]", String.format("[%d]15[%d]15[%d]15[grow]15[%d]",
                model.getSc().getHEIGHT_RATIO() * 15,
                model.getSc().getHEIGHT_RATIO() * 70,
                model.getSc().getHEIGHT_RATIO() * 5,
                model.getSc().getHEIGHT_RATIO() * 15
        ));

        this.setLayout(layoutM);

        this.add(model.getPanel1(), "grow, wrap");
        this.add(model.getPanel2(), "grow, wrap");
        this.add(model.getPanel3(), "grow, wrap");
        this.add(model.getPanel4(), "grow, wrap");
        this.add(model.getPanel6(), "grow, wrap");
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
