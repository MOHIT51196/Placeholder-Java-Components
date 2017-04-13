package org.codeshare.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JTextArea;


/**
 * @author MOHIT MALHOTRA
 * @since 10-3-2017
 */


@SuppressWarnings("serial")
public class JPlaceHolderTextArea extends JTextArea {

	private String ph;

	public JPlaceHolderTextArea(String ph) {
		this.ph = ph;
	}
	
	public JPlaceHolderTextArea() {
		this.ph = null;
	}

	/**
	 * Gets text, returns placeholder if nothing specified
	 */
	@Override
	public String getText() {
		String text = super.getText();

		if (text.trim().length() == 0 && ph != null) {
			text = ph;
		}

		return text;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (super.getText().length() > 0 || ph == null) {
			return;
		}
		
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(super.getDisabledTextColor());
		g2.drawString(ph, getInsets().left, g.getFontMetrics().getMaxAscent() + getInsets().top);
	}
}

