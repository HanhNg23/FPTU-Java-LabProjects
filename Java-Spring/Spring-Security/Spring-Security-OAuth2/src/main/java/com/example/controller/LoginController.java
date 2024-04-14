package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Controller
public class LoginController {
	
	//private static String authorizationRequestBaseUri = "oauth2/authorization";
	private static String authorizationRequestBaseUri = "oauth2/authorize-client";

	 Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
	 
	 @Autowired
	 private ClientRegistrationRepository clientRegistrationRepository;
	 
	 //This method has to send a map of the clients available and their authorization endpoints to the view, which we'll obtain from the ClientRegistrationRepository
	 @GetMapping("/oauth_login")
	    public String getLoginPage(Model model) {
		 Iterable<ClientRegistration> clientRegistrations = null;
		    ResolvableType type = ResolvableType.forInstance(clientRegistrationRepository)
		      .as(Iterable.class);
		    if (type != ResolvableType.NONE && 
		      ClientRegistration.class.isAssignableFrom(type.resolveGenerics()[0])) {
		        clientRegistrations = (Iterable<ClientRegistration>) clientRegistrationRepository;
		    }

		    clientRegistrations.forEach(registration -> 
		      oauth2AuthenticationUrls.put(registration.getClientName(), 
		      authorizationRequestBaseUri + "/" + registration.getRegistrationId())
		    		);

		    
		    oauth2AuthenticationUrls.forEach((clientname,url) 
		    		-> System.out.println("Clientname: " + clientname + " Url: " + url));
		    
		    model.addAttribute("urls", oauth2AuthenticationUrls);
		    

	        return "oauth_login";
	    }
	 
	 
	 
	@Autowired
	private OAuth2AuthorizedClientService auth2AuthorizedClientService; 
	
	@GetMapping("/login_success")
	public String loginSuccesssfull(OAuth2AuthenticationToken authenticationToken, Model model) {
		//retrieve the current client base on loading the registration id and name field which are retrieved from the token
			OAuth2AuthorizedClient client = auth2AuthorizedClientService.loadAuthorizedClient(
											authenticationToken.getAuthorizedClientRegistrationId(),
											authenticationToken.getName()
											);
			
		//grab the user info endpoint, this user endpoint surely return to the json data of current client by using access token
			String userInfoUrl = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();
			
			if(!userInfoUrl.isEmpty()) {
				RestTemplate restTemplate = new RestTemplate();
				//send request for access api to Authorazation Server by sending it the access token
				HttpHeaders headers = new HttpHeaders();
				headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
				HttpEntity<String> entity = new HttpEntity<>("", headers); //write this header to the request
				ResponseEntity<Map> response = restTemplate.exchange(userInfoUrl, HttpMethod.GET, entity, Map.class);
				Map userAttributes = response.getBody();
				model.addAttribute("name", userAttributes.get("name"));
					
			}
			
			return "login_success";
	}
	
	
	
}
