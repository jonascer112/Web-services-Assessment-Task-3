/**

 The Computer class represents a computer in the computer shop.
 It contains information about the computer's id, name, parts, years, and price.
 */
package eif.viko.jcereska.kompiuteriushop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Computer {
    private @Id @GeneratedValue Long id;
    private String computerName;
    private String parts;
    private String years;
    private Double price;
    /**
     * Constructs an empty Computer object.
     */
    public Computer() {};
    /**
     * Constructs a Computer object with the specified id, name, parts, years, and price.
     *
     * @param id            the id of the computer
     * @param computerName  the name of the computer
     * @param parts         the parts of the computer
     * @param years         the years of the computer
     * @param price         the price of the computer
     */
    public Computer(Long id, String computerName, String parts, String years, Double price) {
        this.id = id;
        this.computerName = computerName;
        this.parts = parts;
        this.years = years;
        this.price = price;
    }
    /**
     * Constructs a Computer object with the specified name, parts, years, and price.
     *
     * @param computerName  the name of the computer
     * @param parts         the parts of the computer
     * @param years         the years of the computer
     * @param price         the price of the computer
     */

    public Computer(String computerName, String parts, String years, Double price) {
        this.computerName = computerName;
        this.parts = parts;
        this.years = years;
        this.price = price;
    }
    /**
     * Returns the id of the computer.
     *
     * @return the id of the computer
     */
    public Long getId() {
        return id;
    }
    /**
     * Sets the id of the computer.
     *
     * @param id  the id of the computer
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Returns the name of the computer.
     *
     * @return the name of the computer
     */
    public String getComputerName() {
        return computerName;
    }
    /**
     * Sets the name of the computer.
     *
     * @param computerName  the name of the computer
     */
    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }
    /**
     * Returns the parts of the computer.
     *
     * @return the parts of the computer
     */
    public String getParts() {
        return parts;
    }
    /**
     * Sets the parts of the computer.
     *
     * @param parts  the parts of the computer
     */
    public void setParts(String parts) {
        this.parts = parts;
    }
    /**
     * Returns the years of the computer.
     *
     * @return the years of the computer
     */
    public String getYears() {
        return years;
    }
    /**
     * Sets the years of the computer.
     *
     * @param years  the years of the computer
     */
    public void setYears(String years) {
        this.years = years;
    }
    /**
     * Returns the price of the computer.
     *
     * @return the price of the computer
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Sets the price of the computer.
     *
     * @param price  the price of the computer
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    /**
     * Checks if this Computer is equal to the specified object.
     *
     * @param o  the object to compare
     * @return true if the Computers are equal, false otherwise
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if (!(o instanceof Computer)){
            return false;
        }
        Computer computer = (Computer) o;
        return Objects.equals(this.id, computer.id)
                && Objects.equals(this.parts, computer.parts)
                && Objects.equals(this.computerName, computer.computerName)
                && Objects.equals(this.price, computer.price)
                && Objects.equals(this.years, computer.years);
    }
    /**
     * Generates the hash code for this Computer.
     *
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.parts, this.computerName, this.price, this.years);
    }

    @Override
    public String toString() {
        return String.format("\tTrip:\n\t\t\t\t" + "Computer name = %s\n\t\t\t\t" + "parts = %s\n\t\t\t\t" +
                        "years = %s\n\t\t\t\t" + "price = %s\n\t\t\t\t",
                this.computerName,
                this.parts,
                this.years,
                this.price);
    }

}
