package com.movieList.serviceImpl;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Service("movieDetailsServiceImpl")
public class MovieDetailsServiceImpl{
    
	@Autowired
	RestTemplate restTemplate;
	
	
	public Map fetchMovieDetailsByStartDate() {
		String url = "https://api.themoviedb.org/3/movie/changes?page=1&start_date=\"2023-11-01\"&end_date=\"2023-11-14\"&api_key=8c25ce2247e771ad1f3e9dace0210f8d";
		System.out.println("Url is :" + url);
		HttpEntity<Void> httpEntity = new HttpEntity<Void>(getHeader());

		Map body = restTemplate.exchange(url.toString(), HttpMethod.GET, httpEntity,
				Map.class).getBody();
		
		return body;
	}


	private MultiValueMap<String, String> getHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
}
