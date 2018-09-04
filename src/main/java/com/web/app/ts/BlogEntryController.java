package com.web.app.ts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.app.ts.entites.BlogEntry;
import com.web.app.ts.resource.BlogEntryResource;
import com.web.app.ts.resource.asm.BlogEntryResourceAsm;
import com.web.app.ts.service.BlogEntryService;

@Controller
@RequestMapping(value="/rest/blog-entries")
public class BlogEntryController {
	
	private BlogEntryService service;
	
	public BlogEntryController(BlogEntryService service){
		this.service=service;
	}

	/*
	 * below is one way of defining the rest mapping
	 */
	/*
	 * @RequestMapping("/test") public ResponseEntity<Object> test(){
	 * 
	 * BlogEntry entry=new BlogEntry(); entry.setTitle("test Entry"); return new
	 * ResponseEntity<>(entry,HttpStatus.OK); }
	 */

	/*
	 * below is one way of defining the rest mapping
	 * 
	 * here below instead of returning the response entity we will use
	 * annotation inside the method and after the annotation we will use the
	 * blogentry object which we want as return
	 */
	@RequestMapping("/test")
	public @ResponseBody BlogEntry test() {

		BlogEntry entry = new BlogEntry();
		entry.setTitle("test Entry");
		return entry;
	}

	/*
	 * below is one way of defining the Post rest services
	 * 
	 * here below instead of returning the response entity we will use
	 * annotation inside the passing parameter we will use the
	 * 
	 * @request body annotation to receive the data posted through URL
	 */
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public @ResponseBody BlogEntry test1(@RequestBody BlogEntry enty) {

		return enty;
	}
	
	
	@RequestMapping(value="/{Id}",method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long Id){
		BlogEntry entry=service.find(Id);
		BlogEntryResource res=new BlogEntryResourceAsm().toResource(entry);
		return new ResponseEntity<BlogEntryResource>(res,HttpStatus.OK);
	}
	

}
