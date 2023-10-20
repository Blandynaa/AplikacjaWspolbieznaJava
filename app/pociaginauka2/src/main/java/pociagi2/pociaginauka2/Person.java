package pociagi2.pociaginauka2;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.*;

public class Person {

    private StringProperty propertyTextField = new SimpleStringProperty(this,"nameproperty","John");
    private IntegerProperty yearProperty = new SimpleIntegerProperty();

    public String getPropertyTextField() {
        return propertyTextField.get();
    }

    public StringProperty propertyTextFieldProperty() {
        return propertyTextField;
    }
    public static void bindings(){
        DoubleProperty a = new SimpleDoubleProperty(3.0);
        IntegerProperty b = new SimpleIntegerProperty(4);

        NumberBinding resultAdd = a.add(b);

        System.out.println("Działania Liczbowe"+ resultAdd.intValue());


    }
    public IntegerProperty getYearProperty() {
        return yearProperty;
    }
}
