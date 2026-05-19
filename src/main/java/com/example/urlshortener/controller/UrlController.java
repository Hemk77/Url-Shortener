//package com.example.urlshortener.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UrlController {
//	@GetMapping("/")
//	public String home() {
//		return "URL Shortener is running";
//	}
//}

package com.example.urlshortener.controller;

import org.springframework.web.bind.annotation.*;
import com.example.urlshortener.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UrlController {
	private final UrlService urlService;
	
	public UrlController(UrlService urlService) {
		this.urlService = urlService;
	}
	
	@GetMapping("/")
	public String home() {
		return "URL Shortener is running";
	}
	
	@PostMapping("/shorten")
	public String shortenUrl(@RequestParam String url) {
		return "Short URL: " + urlService.generateShortUrl(url);
	}
	@GetMapping("/{id}")
	public void redirect(@PathVariable String id, HttpServletResponse response) throws java.io.IOException {

	    String originalUrl = urlService.getOriginalUrl(id);

	    if (originalUrl != null) {
	        response.sendRedirect(originalUrl);
	    } else {
	        response.sendError(404, "URL not found");
	    }
	}
}
