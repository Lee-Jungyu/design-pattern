package proxy_pattern1;

import java.net.URL;
import java.awt.*;
import javax.swing.*;

public class ImageProxy implements Icon {
	ImageIcon imageIcon;
	URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;
	
	public ImageProxy(URL url) {imageURL = url;}
	@Override
	public int getIconWidth() {
		// TODO �ڵ� ������ �޼ҵ� ����
		if(imageIcon != null) {
			return imageIcon.getIconWidth();
		} else {
			return 800;
		}
	}

	@Override
	public int getIconHeight() {
		// TODO �ڵ� ������ �޼ҵ� ����
		if(imageIcon != null) {
			return imageIcon.getIconHeight();
		} else {
			return 600;
		}
	}

	public void paintIcon(final Component c, Graphics g, int x, int y) {
		// TODO �ڵ� ������ �޼ҵ� ����
		if(imageIcon != null) {
			imageIcon.paintIcon(c, g, x, y);
		} else {
			g.drawString("Loading CD cover, please wait...", x + 300, y + 190);
			if(!retrieving) {
				retrieving = true;
				retrievalThread = new Thread(new Runnable() {
					public void run() {
						try {
							imageIcon = new ImageIcon(imageURL, "CD Cover");
							c.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}
	
}
