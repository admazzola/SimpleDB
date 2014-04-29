package launcher;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
    private Image image;
    private boolean tile;

    ImagePanel(Image image) {
        this.image = image;
        this.tile = false;
        final JCheckBox checkBox = new JCheckBox();
        checkBox.setAction(new AbstractAction("Tile") {
            public void actionPerformed(ActionEvent e) {
                tile = checkBox.isSelected();
                repaint();
            }
        });
        add(checkBox, BorderLayout.SOUTH);
    };

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (tile) {
            int iw = image.getWidth(this);
            int ih = image.getHeight(this);
            if (iw > 0 && ih > 0) {
                for (int x = 0; x < getWidth(); x += iw) {
                    for (int y = 0; y < getHeight(); y += ih) {
                        g.drawImage(image, x, y, iw, ih, this);
                    }
                }
            }
        } else {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
