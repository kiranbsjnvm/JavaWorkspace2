package com.myapp.RESTService_Messanger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/demo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class DemoResource {

	@GET
	@Path("annotation")
	//http://localhost:8010/RESTService_Messanger/webapi/demo/annotation;param=ddd  [for matrix param]
	public String getParamsUsingAnnotation(@MatrixParam("param") String matrixParam,
										   @HeaderParam("sessionId") String id,
											@CookieParam("name") String name){
		return "Matrix Param : "+matrixParam+"; Header ID: "+id;
	}
	
	@GET
	@Path("context")
	public String getParamsByContext(@Context UriInfo uriInfo,@Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		String queryParams = uriInfo.getQueryParameters().toString();
		
		String cockies = headers.getCookies().toString();
		return "Path : "+path+" ; Coocki : "+cockies;
	}
	
}
