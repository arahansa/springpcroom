package com.arahansa.pcroom.view.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.arahansa.pcroom.util.FileManager;

@SuppressWarnings("serial")
public class ImgClock extends JPanel implements Runnable {
	Image img[] = new Image[4];
	int i = 2;
	public ImgClock() {
		for (int i = 1; i <= 3; i++) 
			img[i] = Toolkit.getDefaultToolkit().createImage(FileManager.getFilename("images/cl"+i+".png"));
		img[0] = img[1];
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img[0], 0, 0, this);
	}
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(10000);
				i = (i==3) ? 1 : ++i;
				img[0] = img[i];	
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
