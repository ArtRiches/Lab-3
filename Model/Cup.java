package Model;

import java.util.Objects;

public class Cup {
    private final Animal owner;
    private boolean full;

    public Cup(Animal owner) {
        this.owner = owner;
    }

    public String fill(Animal animal) {
        full = true;
        return String.format("%s ��������(�) ����� %s", animal.getName(), owner.getName());
    }
    
    public String use() {
        full = false;
        return String.format("%s �����(a) ���������� �����", owner.getName());
    }

    public boolean isFull() {
        return full;
    }

    @Override
    public String toString() {
        return String.format(
                "�����: �������� %s",
                owner.getName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cup cup = (Cup) o;
        return full == cup.full &&
                Objects.equals(owner, cup.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, full);
    }
}
