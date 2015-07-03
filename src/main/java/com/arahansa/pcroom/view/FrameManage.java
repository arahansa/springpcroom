package com.arahansa.pcroom.view;

import java.awt.Component;
import java.awt.Rectangle;
import java.lang.reflect.Field;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import com.arahansa.pcroom.asset.Setting;
import com.arahansa.pcroom.util.FileManager;
import com.arahansa.pcroom.view.panel.ClockMessage;
import com.arahansa.pcroom.view.panel.ImgClock;
import com.arahansa.pcroom.view.panel.MyStarPanel;
import com.arahansa.pcroom.view.panel.PanImgload;

@SuppressWarnings("serial")
public class FrameManage extends JFrame {

	public JLayeredPane layeredPane = new JLayeredPane();
	// JPanels
	private PanImgload backGround = new PanImgload(FileManager.getFilename("images/mainHud_back.png"));
	private MyStarPanel myStarPanel = new MyStarPanel();
	private ImgClock imgClock = new ImgClock();
	private ClockMessage clockMessage = new ClockMessage();

	int posXpanSeat, posYpanSeat;
	PanSeat[] pan = new PanSeat[50];
	JPanel seat50 = new JPanel();

	public FrameManage() {
		// Configure this Frame
		setLayout(null);
		setVisible(true);
		setTitle("ManageView");
		setSize(Setting.bDimen);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(Setting.locationX, Setting.locationY);

		// 좌석 패널 시작 시작점 165 129

		//seat50.setLayout(null);
		//seat50.setOpaque(false);
		//seat50.setBounds(165, 109, 1368, 686);
		for (int seat = 0; seat < 50; seat++) {
			pan[seat] = new PanSeat(seat);
			if (seat % 10 == 0 && seat != 0) {
				posXpanSeat = 0;
				posYpanSeat += 140;
			}
			pan[seat].setBounds(posXpanSeat, posYpanSeat, 99, 99);
			posXpanSeat += 135;
			// seat50.add(pan[seat]);
		}
		new SeatThread().start();;
		add(setJLayered(backGround, myStarPanel, imgClock, clockMessage, seat50));
		add(layeredPane);
	}

	public static void main(String[] args) throws Exception {
		FrameManage manageView = new FrameManage();
		manageView.setRectangles(FrameManage.class, manageView, Setting.class, Setting.getInstance());
	}

	// Setting inner Methods
	private JComponent setJLayered(Component... components) {
		int i = 0;
		for (Component component : components)
			layeredPane.add(component, new Integer(i++));
		return layeredPane;
	}

	// Reflection Practice
	public void setRectangles(Class<?> clazz, Object instance, Class<?> targetClass, Object target) throws Exception {
		Object tempObject = null;
		for (Field field : clazz.getDeclaredFields()) {
			if ((tempObject = field.get(instance)) instanceof JComponent) {
				((JComponent) tempObject).setBounds((Rectangle) targetClass.getDeclaredField(field.getName()).get(target));
				((JComponent) tempObject).setOpaque(false);
				((JComponent) tempObject).setLayout(null);
			}
			if (tempObject instanceof Runnable)
				new Thread((Runnable) tempObject).start();
		}
	}

	
	
	// Thread For the pc room seat 
	class SeatThread extends Thread {
		@Override
		public void run() {
			Set<Integer> randomNumbers = new LinkedHashSet<Integer>();
			for (; randomNumbers.size() < 50;) {
				int x = (int) ((Math.random() * 50));
				randomNumbers.add(x);
			}
			int tmp = 0;
			try {
				for (Integer s : randomNumbers) {
					tmp++;
					if (tmp > 30)
						Thread.sleep(5*s);
					if (tmp == 50) {
						Thread.sleep(1000);
					}
					seat50.add(pan[s]);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
