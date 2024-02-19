import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

abstract class MicroOfficeFactory {

    public abstract AbstractButton createButton();
    public abstract AbstractPanel createPanel();
    public abstract AbstractTextBox createTextBox();
}

class ConcreteWord90 extends MicroOfficeFactory {

    //Singleton Implementation
    private static int instanceCount = 0;
    private ConcreteWord90(){}
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

    @Override
    public AbstractButton createButton() {
        return new ButtonWord90();
    }

    @Override
    public AbstractPanel createPanel() {
        return new PanelWord90();
    }

    @Override
    public AbstractTextBox createTextBox() {
        return new TextBoxWord90();
    }

}

class ConcreteWord00 extends MicroOfficeFactory {
    
    //Singleton Implementation
    private static int instanceCount = 0;
    private ConcreteWord00(){}
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

    @Override
    public AbstractButton createButton() {
        return new ButtonWord00();
    }

    @Override
    public AbstractPanel createPanel() {
        return new PanelWord00();
    }

    @Override
    public AbstractTextBox createTextBox() {
        return new TextBoxWord00();
    }
}

class ConcreteWord10 extends MicroOfficeFactory {
    
    //Singleton Implementation
    private static int instanceCount = 0;
    private ConcreteWord10(){}
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

    @Override
    public AbstractButton createButton() {
        return new ButtonWord10();
    }

    @Override
    public AbstractPanel createPanel() {
        return new PanelWord10();
    }

    @Override
    public AbstractTextBox createTextBox() {
        return new TextBoxWord10();
    }
}

class ConcreteWord24 extends MicroOfficeFactory {
    
    //Singleton Implementation
    private static int instanceCount = 0;
    private ConcreteWord24(){}
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

    @Override
    public AbstractButton createButton() {
        return new ButtonWord24();
    }

    @Override
    public AbstractPanel createPanel() {
        return new PanelWord24();
    }

    @Override
    public AbstractTextBox createTextBox() {
        return new TextBoxWord24();
    }
}


//Abstract Components for the Words
abstract class AbstractButton {
    public abstract void display();
}

abstract class AbstractPanel {
    public abstract void display();
}

abstract class AbstractTextBox {
    public abstract void display();
}

//Concrete components implementation for each word

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

    public void run() {
        this.AbstractButton.display();
        this.AbstractPanel.display();
        this.AbstractTextBox.display();
    }
}

public class Main {

    // The path to the configuration file
    private static final String CONFIG_FILE_PATH = "config.txt"; 
    public static void main(String[] args) {

        try {
            // Read all lines from the configuration file
            List<String> generations = Files.readAllLines(Paths.get(CONFIG_FILE_PATH));

            // Perform the test run for each generation from the file
            for (String generation : generations) {
                MicroOfficeFactory factory = null;

                switch (generation) {
                    case "Word90":
                        factory = ConcreteWord90.getInstance();
                        break;
                    case "Word00":
                        factory = ConcreteWord00.getInstance(); // Singleton, will be the same instance on each call
                        break;
                    case "Word10":
                        factory = ConcreteWord10.getInstance(); // Singleton, will be the same instance on each call
                        break;
                    case "Word24":
                        factory = ConcreteWord24.getInstance(); // Singleton, will be the same instance on each call
                        break;
                    default:
                        System.err.println("Unknown generation: " + generation);
                        break;
                }

                if (factory != null) {
                    Client client = new Client(factory);
                    client.run();
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Error reading the configuration file: " + e.getMessage());
        }
    }
}