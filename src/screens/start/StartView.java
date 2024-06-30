package screens.start;

import guicomponents.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartView extends ColorPanel {

    private final RoundButton startGameButton;
    private final RoundButton quitButton;

    public StartView() {
        super(new BorderLayout());

        ColorPanel centerPanel = new ColorPanel(new GridBagLayout());
        GridBagConstraints gbc = VerticalGridBagLayout.getGridBagConstraints();

        centerPanel.add(ApplicationLogo.getApplicationNameLabel(), gbc);
        gbc.gridy++;

        gbc.insets = new Insets(5, 5, 5, 30);
        centerPanel.add(new JLabel(ApplicationLogo.getImageIcon("appIcon.png")), gbc);
        gbc.gridy++;
        gbc.insets = new Insets(5, 5, 5, 5);

        this.startGameButton = new RoundButton("Start game" + Icons.RIGHTWARDS_ARROW);
        centerPanel.add(this.startGameButton, gbc);
        gbc.gridy++;

        this.quitButton = new RoundButton(Icons.LEFTWARDS_ARROW + " Quit");
        centerPanel.add(this.quitButton, gbc);

        this.add(centerPanel, BorderLayout.CENTER);

        this.add(new Footer(), BorderLayout.SOUTH);
    }

    public void addStartGameButtonListener(ActionListener e) {
        this.startGameButton.addActionListener(e);
    }

    public void addQuitButtonListener(ActionListener e) {
        this.quitButton.addActionListener(e);
    }

}
