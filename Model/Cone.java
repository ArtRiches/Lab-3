package Model;

public class Cone {
    public String hurl(Animal performer, Animal target) {
        return String.format("%s кинул(а) шишку в %s", performer.getName(), target.getName());
    }

    @Override
    public String toString() {
        return "Шишка";
    }
}
