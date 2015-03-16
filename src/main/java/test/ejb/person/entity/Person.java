/**
 * Copyright 2015. ABN Software. All Rights reserved.<br>
 * <br>
 * Homepage .... http://www.ABNsoft.info<br>
 * <br>
 * Project ..... PersonEjb<br>
 * <br>
 * Author ...... AnNik<br>
 * E-Mail ...... ABN.DEV@mail.ru<br>
 * Created ..... 14 марта 2015 г.<br>
 * <br>
 */
package test.ejb.person.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author annik
 *
 */
//@Entity( name = "person" )
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "person_seq" )
//    @SequenceGenerator( name = "person_seq", sequenceName = "person_name" )
    private Long gid;

    private String firstname;

    private String lastname;

    private String middlename;

    private Date birthday;

    /**
     * Contructor.
     */
    public Person() {

    }

    /**
     * Getter.
     * 
     * @return the gid
     */
    public Long getGid() {

        return gid;
    }

    /**
     * Setter.
     * 
     * @param gid
     *            the gid to set
     */
    public void setGid( Long gid ) {

        this.gid = gid;
    }

    /**
     * Getter.
     * 
     * @return the firstname
     */
    public String getFirstname() {

        return firstname;
    }

    /**
     * Setter.
     * 
     * @param firstname
     *            the firstname to set
     */
    public void setFirstname( String firstname ) {

        this.firstname = firstname;
    }

    /**
     * Getter.
     * 
     * @return the lastname
     */
    public String getLastname() {

        return lastname;
    }

    /**
     * Setter.
     * 
     * @param lastname
     *            the lastname to set
     */
    public void setLastname( String lastname ) {

        this.lastname = lastname;
    }

    /**
     * Getter.
     * 
     * @return the middlename
     */
    public String getMiddlename() {

        return middlename;
    }

    /**
     * Setter.
     * 
     * @param middlename
     *            the middlename to set
     */
    public void setMiddlename( String middlename ) {

        this.middlename = middlename;
    }

    /**
     * Getter.
     * 
     * @return the birthday
     */
    public Date getBirthday() {

        return birthday;
    }

    /**
     * Setter.
     * 
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday( Date birthday ) {

        this.birthday = birthday;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return String.format( "Person [gid=%s, firstname=%s, lastname=%s, middlename=%s, birthday=%s]", gid,
                firstname, lastname, middlename, birthday );
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( gid == null ) ? 0 : gid.hashCode() );
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( getClass() != obj.getClass() ) return false;
        Person other = (Person) obj;
        if ( gid == null ) {
            if ( other.gid != null ) return false;
        } else if ( !gid.equals( other.gid ) ) return false;
        return true;
    }

}
