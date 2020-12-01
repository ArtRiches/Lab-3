package Model;

import java.util.Objects;

public class AnimalChild extends Animal {
    private boolean fed;
    private boolean tookFishOil;

    public AnimalChild(String name, boolean tookFishOil) {
        super(name);
        this.tookFishOil = tookFishOil;
    }

    public boolean isFed() {
        return fed;
    }

    public String eat() {
        this.fed = true;
        return String.format("%s поел(а) и теперь не голодный(ая)", getName());
    }

    public boolean isTookFishOil() {
        return tookFishOil;
    }

    public String takeFishOil() {
        this.tookFishOil = true;
        return String.format("%s принял(а) рыбий жир", getName());
    }

    @Override
    public String toString() {
        return String.format(
                "Животное Ребенок: %s, %s, %s",
                getName(),
                tookFishOil ? "принял(a) рыбий жир" : "не принял рыбий жир",
                fed ? "сытый(ая)" : "голодный(ая)"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AnimalChild that = (AnimalChild) o;
        return fed == that.fed &&
                tookFishOil == that.tookFishOil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fed, tookFishOil);
    }
}
