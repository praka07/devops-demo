/**
 * 
 */
package com.mithuntechnology.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Prakash
 *
 */
@RestController
public class DemoController {

	@GetMapping
	public String greetingsMsg() {
		return "welcome to muthun technologies";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)

	public ResponseEntity<byte[]> getImage(HttpServletResponse response) throws IOException {

		byte[] bytes = StreamUtils.copyToByteArray(new ClassPathResource("image/mithun.jpg").getInputStream());
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}
}
