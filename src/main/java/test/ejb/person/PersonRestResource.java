package test.ejb.person;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.ejb.person.entity.Person;

/**
 * Session Bean implementation class PersonRestBean
 */
@Path( "/personService" )
@Stateful
@StatefulTimeout( unit = TimeUnit.MINUTES, value = 30 )
@SessionScoped
public class PersonRestResource {

    public static final String URL = "/rs/personService";

    private static final Logger LOG = LoggerFactory.getLogger( PersonRestResource.class );

    @Context
    private HttpHeaders headers;

    @EJB
    private PersonBean personBean;

    /**
     * Default constructor.
     */
    public PersonRestResource() {

    }

    @GET
    @Produces( {MediaType.TEXT_PLAIN} )
    public Response root( @Context UriInfo uriInfo ) {

        System.out.println( "URI INFO = " + uriInfo.getRequestUri() );
        String uri = uriInfo.getRequestUri().toString();
        uri = ( uri.matches( ".*/$" ) ? uri.substring( 0, uri.length() - 1 ) : uri );

        return Response.status( Response.Status.SEE_OTHER ).header( HttpHeaders.LOCATION, uri + "/status" )
                .build();
    }

    @GET
    @Path( "/status" )
    @Produces( {MediaType.TEXT_PLAIN} )
    public String listPerson() {

        return "/personService ~ worked";
    }

    @GET
    @Path( "/load/{id}" )
    @Produces( {MediaType.APPLICATION_JSON} )
    public Person loadPerson( @PathParam( value = "id" ) int gid ) {

        return personBean.loadPerson( gid );
    }

    @GET
    @Path( "/list" )
    @Produces( {MediaType.APPLICATION_JSON} )
    public List<Person> listPersons() {

        return personBean.listPersons();
    }

    @POST
    @Path( "/add" )
    @Consumes( {MediaType.APPLICATION_JSON} )
    @Produces( {MediaType.TEXT_PLAIN} )
    public String addPerson( Person person ) {

        LOG.debug( "Person : {}", person.toString() );
        personBean.storePerson( person );

        LOG.debug( "Persons[{}] : {}", personBean.listPersons().size(), personBean.listPersons() );

        return person.toString();
    }

}
