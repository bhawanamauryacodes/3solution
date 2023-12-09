package com.movieList.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movieList.serviceImpl.MovieDetailsServiceImpl;

@RestController
@RequestMapping("/movies")
public class MovieDetailsController {
  
	@Autowired
	MovieDetailsServiceImpl movieDetailsServiceImpl;
	
	@GetMapping()
	public Map getMovieByStartDate()
	{
		Map postResponse = movieDetailsServiceImpl.fetchMovieDetailsByStartDate();		
		return postResponse;
	}
}
