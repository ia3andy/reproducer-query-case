package org.acme;


import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("1")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello1(@QueryParam("S") @DefaultValue("empty") String S) {
        return "Hello from RESTEasy Reactive " + S;
    }

    @GET
    @Path("2")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2(@QueryParam("s") @DefaultValue("empty")  String s) {
        return "Hello from RESTEasy Reactive " + s;
    }

    @GET
    @Path("3")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello2(@QueryParam("s") @DefaultValue("emptys")  String s, @QueryParam("S") @DefaultValue("emptyS")  String S) {
        return "Hello from RESTEasy Reactive " + s  + " " + S;
    }
}