package com.web.app.ts.resource;

import org.springframework.hateoas.ResourceSupport;

public class BlogEntryResource extends ResourceSupport{
	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
