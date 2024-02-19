import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/*
 * Abstract factory class for creating GUI components
 * specific to different versions of Word.
 */
abstract class MicroOfficeFactory {
    public abstract AbstractButton createButton();
    public abstract AbstractPanel createPanel();
    public abstract AbstractTextBox createTextBox();
}

/*
 * Factory class for Word90. Implements a limited Singleton
 * pattern that allows up to two instances.
 */
class ConcreteWord90 extends MicroOfficeFactory {
    private static int instanceCount = 0;

    // Private constructor to prevent instantion from outside this class
    private ConcreteWord90(){}

    // Static method to get an instance of this factory. Limits to two objects
    public static ConcreteWord90 getInstance() {
        if(instanceCount < 2) {
            instanceCount++;
            return new ConcreteWord90();
        }

        else {
            System.out.println("Warning! : Word90 has been generated twice");
            return null;
        }
    }

    // Factory method to create a Button for Word90
    @Override
    public AbstractButton createButton() {
        return new ButtonWord90();
    }

    // Factory method to create a Panel for Word90
    @Override
    public AbstractPanel createPanel() {
        return new PanelWord90();
    }

    // Factory method to create a TextBox for Word90
    @Override
    public AbstractTextBox createTextBox() {
        return new TextBoxWord90();
    }

}

/*
 * Factory class for Word00. Implements a limited Singleton
 * pattern that allows up to two instances.
 */
class ConcreteWord00 extends MicroOfficeFactory {
    private static int instanceCount = 0;

    // Private constructor to prevent instantion from outside this class
    private ConcreteWord00(){}

    // Static method to get an instance of this factory. Limits to two objects
    public static ConcreteWord00 getInstance() {
        if(instanceCount < 2) {
            instanceCount++;
            return new ConcreteWord00();
        }

        else {
            System.out.println("Warning! : Word00 has been generated twice");
            return null;
        }
    }

    // Factory method to create a Button for Word00
    @Override
    public AbstractButton createButton() {
        return new ButtonWord00();
    }

    // Factory method to create a Panel for Word00
    @Override
    public AbstractPanel createPanel() {
        return new PanelWord00();
    }

    // Factory method to create a TextBox for Word00
    @Override
    public AbstractTextBox createTextBox() {
        return new TextBoxWord00();
    }
}

/*
 * Factory class for Word10. Implements a limited Singleton
 * pattern that allows up to two instances.
 */
class ConcreteWord10 extends MicroOfficeFactory {
    private static int instanceCount = 0;

    // Private constructor to prevent instantion from outside this class
    private ConcreteWord10(){}

    // Static method to get an instance of this factory. Limits to two objects
    public static ConcreteWord10 getInstance() {
        if(instanceCount < 2) {
            instanceCount++;
            return new ConcreteWord10();
        }

        else {
            System.out.println("Warning! : Word10 has been generated twice");
            return null;
        }
    }

    // Factory method to create a Button for Word10
    @Override
    public AbstractButton createButton() {
        return new ButtonWord10();
    }

    // Factory method to create a Panel for Word10
    @Override
    public AbstractPanel createPanel() {
        return new PanelWord10();
    }

    // Factory method to create a TextBox for Word10
    @Override
    public AbstractTextBox createTextBox() {
        return new TextBoxWord10();
    }
}

/*
 * Factory class for Word24. Implements a limited Singleton
 * pattern that allows up to two instances.
 */
class ConcreteWord24 extends MicroOfficeFactory {
    private static int instanceCount = 0;

    // Private constructor to prevent instantion from outside this class
    private ConcreteWord24(){}

    // Static method to get an instance of this factory. Limits to two objects
    public static ConcreteWord24 getInstance() {
        if(instanceCount < 2) {
            instanceCount++;
            return new ConcreteWord24();
        }

        else {
            System.out.println("Warning! : Word24 has been generated twice");
            return null;
        }
    }

    // Factory method to create a Button for Word24
    @Override
    public AbstractButton createButton() {
        return new ButtonWord24();
    }

    // Factory method to create a Panel for Word24
    @Override
    public AbstractPanel createPanel() {
        return new PanelWord24();
    }

    // Factory method to create a TextBox for Word24
    @Override
    public AbstractTextBox createTextBox() {
        return new TextBoxWord24();
    }
}


//Abstract base classes for each GUI component for the Words
abstract class AbstractButton {
    public abstract void display();
}

abstract class AbstractPanel {
    public abstract void display();
}

abstract class AbstractTextBox {
    public abstract void display();
}

//Concrete class implementation for each GUI component for each word
//Button
class ButtonWord90 extends AbstractButton {
    @Override
    public void display() {
        System.out.println("Button Word90");
    }
}

class ButtonWord00 extends AbstractButton {
    @Override
    public void display() {
        System.out.println("Button Word00");
    }
}

class ButtonWord10 extends AbstractButton {
    @Override
    public void display() {
        System.out.println("Button Word10");
    }
}

class ButtonWord24 extends AbstractButton {
    @Override
    public void display() {
        System.out.println("Button Word24");
    }
}


//Panel
class PanelWord90 extends AbstractPanel {
    @Override
    public void display() {
        System.out.println("Panel Word90");
    }
}

class PanelWord00 extends AbstractPanel {
    @Override
    public void display() {
        System.out.println("Panel Word00");
    }
}

class PanelWord10 extends AbstractPanel {
    @Override
    public void display() {
        System.out.println("Panel Word10");
    }
}

class PanelWord24 extends AbstractPanel {
    @Override
    public void display() {
        System.out.println("Panel Word24");
    }
}

//TextBox
class TextBoxWord90 extends AbstractTextBox {
    @Override
    public void display() {
        System.out.println("TextBox Word90");
    }
}

class TextBoxWord00 extends AbstractTextBox {
    @Override
    public void display() {
        System.out.println("TextBox Word00");
    }
}

class TextBoxWord10 extends AbstractTextBox {
    @Override
    public void display() {
        System.out.println("TextBox Word10");
    }
}

class TextBoxWord24 extends AbstractTextBox {
    @Override
    public void display() {
        System.out.println("TextBox Word24");
    }
}

/*
 * Client class that uses the abstract factory to create
 * and display GUI components
 */
class Client {
    private AbstractButton AbstractButton;
    private AbstractPanel AbstractPanel;
    private AbstractTextBox AbstractTextBox;

    //Constructor
    public Client(MicroOfficeFactory factory) {
        AbstractButton = factory.createButton();
        AbstractPanel = factory.createPanel();
        AbstractTextBox = factory.createTextBox();
    }

    // Method to run the display function of the GUI components
    public void run() {
        this.AbstractButton.display();
        this.AbstractPanel.display();
        this.AbstractTextBox.display();
    }
}

// Main class that acts as the entry point of the application
public class Main {

    // The path to the configuration file
    private static final String CONFIG_FILE_PATH = "config.txt"; 
    public static void main(String[] args) {
        try {

            // Read all lines from the configuration file
            List<String> generations = Files.readAllLines(Paths.get(CONFIG_FILE_PATH));

            // Iterate through each generation specified and create GUI components
            for (String generation : generations) {
                
                // Reference for the factory to be used. Initialized to null
                MicroOfficeFactory factory = null;

                //Select the appropriate factory based on the generation name read from the file
                switch (generation) {
                    case "Word90":
                        factory = ConcreteWord90.getInstance();
                        break;
                    case "Word00":
                        factory = ConcreteWord00.getInstance(); 
                        break;
                    case "Word10":
                        factory = ConcreteWord10.getInstance(); 
                        break;
                    case "Word24":
                        factory = ConcreteWord24.getInstance(); 
                        break;
                    default:
                        System.err.println("Unknown generation: " + generation);
                        break;
                }

                //If factory was created successfully, use it to create client and run GUI test
                if (factory != null) {
                    Client client = new Client(factory);
                    client.run();
                }

                // Print empty line for better readability of output
                System.out.println();
            }

        } catch (IOException e) {

            // Handle any IO exceptions that may occur when reading the configuration file
            System.err.println("Error reading the configuration file: " + e.getMessage());
        }
    }
}