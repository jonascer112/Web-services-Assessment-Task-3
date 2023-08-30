/**

 The Customer class represents a customer in the computer shop.
 It contains information about the customer's id, first name, and last name.
 */
package eif.viko.jcereska.kompiuteriushop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Customer {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;

    /**
     * Constructs an empty Customer object.
     */
    public Customer(){}
    /**
     * Constructs a Customer object with the specified id, first name, and last name.
     *
     * @param id         the id of the customer
     * @param firstName  the first name of the customer
     * @param lastName   the last name of the customer
     */
    public Customer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * Constructs a Customer object with the specified first name and last name.
     *
     * @param firstName  the first name of the customer
     * @param lastName   the last name of the customer
     */
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    /**
     * Returns the id of the customer.
     *
     * @return the id of the customer
     */
    public Long getId() {
        return id;
    }
    /**
     * Sets the id of the customer.
     *
     * @param id  the id of the customer
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Returns the first name of the customer.
     *
     * @return the first name of the customer
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Sets the first name of the customer.
     *
     * @param firstName  the first name of the customer
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Returns the last name of the customer.
     *
     * @return the last name of the customer
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Sets the last name of the customer.
     *
     * @param lastName  the last name of the customer
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Checks if this Customer is equal to the specified object.
     *
     * @param o  the object to compare
     * @return true if the Customers are equal, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Customer)){
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(this.id, customer.id)
                && Objects.equals(this.firstName, customer.firstName)
                && Objects.equals(this.lastName, customer.lastName);
    }
    /**
     * Generates the hash code for this Customer.
     *
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.firstName, this.lastName);
    }
    /**
     * Returns the string representation of the Customer.
     *
     * @return the string representation of the Customer
     */
    @Override
    public String toString(){
        return String.format("\tName = %s\n\t\t" + "Last Name = %s\n\t\t",
                this.firstName,
                this.lastName);
    }
}
