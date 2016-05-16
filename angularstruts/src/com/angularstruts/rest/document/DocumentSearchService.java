package com.angularstruts.rest.document;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.lucene.document.Document;
import org.lucene.alalysis.CustomAnalyzer;
import org.lucene.exception.SearcherException;
import org.lucene.manager.SearcherManager;
import org.lucene.searcher.Searcher;

import com.angularstruts.document.bo.impl.DocumentBoImpl;

@Path("/")
public class DocumentSearchService {
	
	private static final String DIR = "/home/soprano/Bureau/index";

	@GET
	@Path("/get/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public DocumentBoImpl getStudentInJSON(@PathParam("param") Long id) {
		return new DocumentBoImpl(id,(""+id).hashCode()+"");
	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(DocumentBoImpl st) {

		String result = "Student saved : " + st;
		return Response.status(201).entity(result).build();
		
	}
	
	@GET
	@Path("/search/{query}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,Object> getDocuments(@PathParam("query") String query) {
		Map<String,Object> result = new HashMap<>();
		try {
			Searcher searcher = SearcherManager.getSearcher(DIR, new CustomAnalyzer(),
					new String[] { "title", "content" });
			if(query.startsWith("-")){
				query = "* AND "+query;
			}
			Map<String,Object> infos = searcher.search(query);
			result.put("totalHits", infos.get(Searcher.TOTAL_HITS));
			Set<Map<String,String>> docs = new HashSet<>();
			for(Document doc : (List<Document>)infos.get(Searcher.RESULTS)){
				Map<String,String> map = new HashMap<>();
				map.put("title",doc.get("title"));
				map.put("content",doc.get("content"));
				docs.add(map);
			}
			result.put("docs",docs);
			result.put("duration", infos.get("duration"));
			return result ;
		} catch (IOException | SearcherException e) {
			e.printStackTrace();
			return new HashMap<>();
		}
	}
	
	@PUT
	@Path("/index")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response indexDocument(com.angularstruts.document.Document document){
		System.out.println("Send value : "+document.getTitle());
		return Response.status(201).entity(document).build();
	}
	
	
}
