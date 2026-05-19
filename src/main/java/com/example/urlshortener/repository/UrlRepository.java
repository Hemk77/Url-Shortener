package com.example.urlshortener.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.urlshortener.model.Url;

public interface UrlRepository extends MongoRepository<Url, String> {
}