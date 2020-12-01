package Model;

public class AnimalParent extends Animal {
    public AnimalParent(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return String.format(
                "Животное Родитель: %s",
                getName()
        );
    }
}
