package com.twitter.hashtag.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(TwitterController.TWITTER_BASE_URI)
public class TwitterController {

	public static final String TWITTER_BASE_URI="svc/v1/tweets";
	
	@Autowired
	private Twitter twitter;
	
	TwitterTemplate twittertemplate;
	
	
	@RequestMapping(value="{hashTag}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getTweets(@PathVariable final String hashTag){
		return twitter.searchOperations().search(hashTag, 25).getTweets();
		
	//public List<Tweet> 
		 
	} 
}
