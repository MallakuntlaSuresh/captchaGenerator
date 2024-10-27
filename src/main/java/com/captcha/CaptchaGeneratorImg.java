package com.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CaptchaGeneratorImg {

	private static final int WIDTH = 160;
	private static final int HEIGHT = 60;
	private static final Font FONT = new Font("Arial", Font.BOLD, 40);

	public BufferedImage createCaptchaImage(String captchaText) {
		BufferedImage captchaImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = captchaImage.createGraphics();

		// Fill background with a color
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, WIDTH, HEIGHT);

		// Draw the CAPTCHA text with slight rotation
		g2d.setFont(FONT);
		Random random = new Random();
		for (int i = 0; i < captchaText.length(); i++) {
			int x = 20 + i * 25;
			int y = 40;
			int angle = random.nextInt(15) - 7; // Rotate text by -7 to +7 degrees
			g2d.rotate(Math.toRadians(angle), x, y);
			g2d.setColor(getRandomColor());
			g2d.drawString(String.valueOf(captchaText.charAt(i)), x, y);
			g2d.rotate(-Math.toRadians(angle), x, y);
		}

		// Add noise (random lines)
		addNoise(g2d);

		g2d.dispose();
		return captchaImage;
	}

	private Color getRandomColor() {
		Random random = new Random();
		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	private void addNoise(Graphics2D g2d) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(WIDTH);
			int y1 = random.nextInt(HEIGHT);
			int x2 = random.nextInt(WIDTH);
			int y2 = random.nextInt(HEIGHT);
			g2d.setColor(getRandomColor());
			g2d.drawLine(x1, y1, x2, y2);
		}
	}
}
