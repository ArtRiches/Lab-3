package Model;

public class Cone {
    public String hurl(Animal performer, Animal target) {
        return String.format("%s �����(�) ����� � %s", performer.getName(), target.getName());
    }

    @Override
    public String toString() {
        return "�����";
    }
}
