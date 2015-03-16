package test.ejb.person;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.ejb.person.entity.Person;

/**
 * Session Bean implementation class PersonProcessor
 */
//@Stateful
//@StatefulTimeout( unit = TimeUnit.MINUTES, value = 30 )
@Singleton
public class PersonBean {

    private Map<Long, Person> persons;

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

        persons = new HashMap<Long, Person>();
        LOG.debug( "Person initialised." );
    }

    /**
     * @param person
     */
    public void storePerson( Person person ) {

        if ( person.getGid() == null ) {
            person.setGid( (long) this.persons.size() );
        }
        persons.put( person.getGid(), person );
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
    public Map<Long, Person> listPersons() {

        return this.persons;
    }

}
