package Model;

import java.util.Objects;

public abstract class Animal implements AnimalActionExecutor {
    private final String name;
    private AnimalAction action;

    public Animal(String name) {
        this.name = name;
    }

    public void setAction(AnimalAction action) {
        this.action = action;
    }
    
    public void makeAction() {
        action.make();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Животное: %s", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(action, animal.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, action);
    }
}
