package com.captcha;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CaptchaController {

	private final CaptchaGenerator captchaGenerator;
	private final CaptchaGeneratorImg captchaGeneratorImg;

	public CaptchaController() {
		this.captchaGenerator = new CaptchaGenerator();
		this.captchaGeneratorImg = new CaptchaGeneratorImg();
	}

	@GetMapping("/captcha")
	public void getCaptcha(HttpServletResponse response) throws IOException {
		String captchaText = captchaGenerator.generateCaptchaText();

		BufferedImage captchaImage = captchaGeneratorImg.createCaptchaImage(captchaText);

		response.setContentType("image/png");
		ImageIO.write(captchaImage, "png", response.getOutputStream());
	}

	@GetMapping("/captcha/manual")
	public void generateCaptcha(@RequestParam("text") String text, HttpServletResponse response) throws IOException {
		String captchaText = new CaptchaGenerator().generateCaptchaText(text);

		BufferedImage captchaImage = captchaGeneratorImg.createCaptchaImage(captchaText);

		response.setContentType("image/png");
		ImageIO.write(captchaImage, "png", response.getOutputStream());

		System.out.println("CAPTCHA generated successfully with text: " + captchaText);
	}
}
