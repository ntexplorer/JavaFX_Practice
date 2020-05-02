package p17.properties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The type Person.
 *
 * @author Tian Z
 */
public class Person {
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName.get();
    }

    /**
     * First name property string property.
     *
     * @return the string property
     */
    public StringProperty firstNameProperty() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
