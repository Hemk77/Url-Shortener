//package com.example.urlshortener.service;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UrlService {
//	public String generateShortUrl(String originalUrl) {
//		//generating short url using hash
//		return Integer.toHexString(originalUrl.hashCode());
//	}
//}


package com.example.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.repository.UrlRepository;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public String generateShortUrl(String originalUrl) {

        // generate short ID
        String shortId = Integer.toHexString(originalUrl.hashCode());

        // create Url object
        Url url = new Url();
        url.setId(shortId);
        url.setOriginalUrl(originalUrl);

        // save to MongoDB
        urlRepository.save(url);

        return shortId;
    }
    public String getOriginalUrl(String shortId) {
        return urlRepository.findById(shortId)
                .map(url -> url.getOriginalUrl())
                .orElse(null);
    }
}
