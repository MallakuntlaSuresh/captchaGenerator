package com.captcha;

import java.util.Random;

public class CaptchaGenerator {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	private static final int CAPTCHA_LENGTH = 6;

	public String generateCaptchaText() {
		StringBuilder builder = new StringBuilder(CAPTCHA_LENGTH);
		Random random = new Random();
		for (int i = 0; i < CAPTCHA_LENGTH; i++) {
			int nextInt = random.nextInt(CHARACTERS.length());
			builder.append(CHARACTERS.charAt(nextInt));
		}
		System.out.println("Generated Captcha::  " + builder);
		return builder.toString();
	}

	public String generateCaptchaText(String text) {
		StringBuilder builder = new StringBuilder(CAPTCHA_LENGTH);
		Random random = new Random();
		for (int i = 0; i < CAPTCHA_LENGTH; i++) {
			int nextInt = random.nextInt(text.length());
			builder.append(text.charAt(nextInt));
		}
		System.out.println("Generated Captcha::  " + builder);
		return builder.toString();
	}
}
