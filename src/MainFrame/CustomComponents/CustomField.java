package MainFrame.CustomComponents;

import MainFrame.MainFrameModel;
import MainFrame.Navbar.NavbarModel;
import MainFrame.Pages.ProfilePage.Center.PPCenterModel;
import MainFrame.Pages.ProfilePage.ProfilePageModel;
import PojoClasses.User;
import Static.Colors;
import Static.Fonts;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomField extends JComponent
{
    private JPanel panelL;
    private JPanel panelR;

    private JLabel nameLabel;

    private JTextField tf;

    private String name;
    private String data;

    private JButton btn1;
    private JButton btn2;

    private JPanel buttonPanel;

    private final String KEY;

    private PPCenterModel ref;
    private NavbarModel ref2;

    public CustomField(String name, String data, String key, PPCenterModel ref, NavbarModel ref2)
    {
        this.KEY = key;

        this.ref = ref;
        this.ref2 = ref2;

        this.name = name;
        this.data = data;

        this.nameLabel = new CustomJLabel();
        this.nameLabel.setText(this.name);


        this.tf = new CustomJTextField(5);
        this.tf.setText(this.data);
        this.tf.setFont(Fonts.NORMAL_FONT);
        this.tf.setEnabled(false);

        this.btn1 = new CustomJButton();
        this.btn1.setText("Change");
        this.btn1.setEnabled(true);
        this.btn1.setFont(Fonts.TITLE_FONT);
        this.btn1.addActionListener(new UpdateClickListener());

        this.btn2 = new CustomJButton();
        this.btn2.setText("Update");
        this.btn2.setEnabled(false);
        this.btn2.setFont(Fonts.TITLE_FONT);
        this.btn2.addActionListener(new UpdateClickListener());

        this.buttonPanel = new CustomJPanel();

        MigLayout layoutTemp = new MigLayout("inset 0 0 0 0", "[grow][grow]", "[grow]");

        this.buttonPanel.setLayout(layoutTemp);
        this.buttonPanel.add(this.btn1, "grow");
        this.buttonPanel.add(this.btn2, "grow");

        this.panelL = new CustomJPanel();
        this.panelR = new CustomJPanel();

        MigLayout layout = new MigLayout("inset 0 0 0 5", "[100][grow][100]", "[grow]");

        this.setLayout(layout);

        this.add(this.nameLabel, "center, grow");
        this.add(this.tf, "grow");
        this.add(this.buttonPanel, "grow");

        this.setBorder(BorderFactory.createLineBorder(Colors.SECONDARY_COLOR));
    }

    class UpdateClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    if(btn1 == e.getSource())
                    {
                        System.out.println("Change");

                        tf.setEnabled(true);

                        btn1.setEnabled(false);
                        btn2.setEnabled(true);
                    }
                    else if(btn2 == e.getSource())
                    {
                        User user = ref.getUser();

                        user.switchByKey(KEY, tf.getText());

                        ref2.getProfLabel().setText(user.getUsername());

                        ref.update();
                        ref2.update();

                        tf.setEnabled(false);

                        btn1.setEnabled(true);
                        btn2.setEnabled(false);
                    }
                    else{ return; }
                }
            });
        }
    }
}
