package com.web.app.ts.resource.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.web.app.ts.BlogEntryController;
import com.web.app.ts.entites.BlogEntry;
import com.web.app.ts.resource.BlogEntryResource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource>{
public BlogEntryResourceAsm(){
	super(BlogEntryController.class, BlogEntryResource.class);
}

@Override
public BlogEntryResource toResource(BlogEntry blogEntry) {
	BlogEntryResource res=new BlogEntryResource();
	res.setTitle(blogEntry.getTitle());
	//ControllerLinkBuilder link=linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getId()));
	Link lintk=linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
	res.add(lintk.withSelfRel());
	return res;
}

}
