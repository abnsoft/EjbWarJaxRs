package test.ejb.person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.ejb.person.entity.Person;

/**
 * Session Bean implementation class PersonProcessor
 */
@Stateful
@StatefulTimeout( unit = TimeUnit.MINUTES, value = 30 )
public class PersonBean {

    private List<Person> persons;

    private static final Logger LOG = LoggerFactory.getLogger( PersonBean.class );

    /**
     * Default constructor.
     */
    public PersonBean() {

    }

    /**
     * 
     */
    @PostConstruct
    public void init() {

        persons = new ArrayList<Person>();
        LOG.debug( "Person initialised." );
    }

    /**
     * @param person
     */
    public void storePerson( Person person ) {

        if ( person.getGid() == null ) {
            person.setGid( (long) this.persons.size() );
        }
        this.persons.add( person );

    }

    /**
     * @param personGid
     * @return
     */
    public Person loadPerson( int personGid ) {

        return this.persons.get( personGid );
    }

    /**
     * @return
     */
    public List<Person> listPersons() {

        return this.persons;
    }

}
