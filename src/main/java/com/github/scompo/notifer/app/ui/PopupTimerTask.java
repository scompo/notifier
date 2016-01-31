package com.github.scompo.notifer.app.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.github.scompo.notifer.api.events.Event;
import com.github.scompo.notifer.api.events.producers.EventProducer;

public class PopupTimerTask extends NotifierTimerTask {

	public PopupTimerTask(EventProducer eventSource, Event event) {
		
		super(eventSource, event);
	}

	@Override
	public void run() {

		JFrame jFrame = new JFrame(getFrameTitle());
		
		JPanel jPanel = new JPanel(new GridLayout(4, 1, 5, 5));
		
		jPanel.add(new JLabel("Task: " + getEvent().getName()));
		jPanel.add(new JLabel("From event source: " + getEventSoruce().getName()));
		jPanel.add(new JLabel("Planned for: " + getEvent().getStart()));
		jPanel.add(new JLabel("FINISHED!!!"));
		
		jFrame.getContentPane().add(jPanel);
		
		jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setAlwaysOnTop(true);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	public String getFrameTitle() {

		return getEvent().getName() + " - " + getEventSoruce().getName();
	}

}
