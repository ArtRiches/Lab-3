import Model.*;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Story {
    public static void main(String[] args) {
        AnimalParent kenga = (AnimalParent) create(new AnimalParent("Кенга"));
        AnimalChild ry = (AnimalChild) create(new AnimalChild("Ру", true));
        AnimalChild tigra = (AnimalChild) create(new AnimalChild("Тигра", false));
        AnimalChild[] children = {ry, tigra};
        System.out.println();
        Chair[] chairs = new Chair[3];
        for (int i = 0; i < chairs.length; i++) {
            chairs[i] = (Chair) create(new Chair());
        }
        System.out.println();
        Cup tigraCup = (Cup) create(new Cup(tigra));
        System.out.println(tigraCup.fill(kenga));
        System.out.println();
        for (AnimalChild child : children) {
            System.out.println(getFishOilText(child));
        }
        System.out.println();
        System.out.println(tigraCup.use());
        for (AnimalChild child : children) {
            if (child.equals(tigra)) {
                System.out.println(child.takeFishOil());
            }
        }
        System.out.println();
        for (AnimalChild child : children) {
            System.out.println(getFishOilText(child));
        }
        System.out.println();
        BiConsumer<Animal, Animal> push = (performer, target) ->
                System.out.printf(
                        "%s дружески толкнул(а) %s%n",
                        performer.getName(),
                        target.getName()
                );
        ry.setAction(() -> push.accept(ry, tigra));
        tigra.setAction(() -> push.accept(tigra, ry));
        makeActions(children);
        System.out.println();
        for (Chair chair : chairs) {
            System.out.println(chair);
        }
        System.out.println();
        ry.setAction(() -> System.out.println(chairs[0].makeDown(ry, ActionIntent.ESPECIALLY)));
        tigra.setAction(() -> {
            Random random = new Random();
            int chairCount = random.nextInt(2) + 2;
            for (int i = 1; i < chairCount; i++) {
                System.out.println(chairs[i].makeDown(tigra, ActionIntent.ACCIDENTALLY));
            }
        });
        makeActions(children);
        System.out.println();
        for (Chair chair : chairs) {
            System.out.println(chair);
        }
        System.out.println();
        kenga.setAction(() -> System.out.printf("%s сказал(а) пойти собрать шишек%n", kenga.getName()));
        kenga.makeAction();
        System.out.println();
        Consumer<Animal> goToTrees = (animal) -> System.out.printf("%s отправился(ась) к Шести соснам%n", animal.getName());
        ry.setAction(() -> goToTrees.accept(ry));
        tigra.setAction(() -> goToTrees.accept(tigra));
        makeActions(children);
        System.out.println();
        Cone[] cones = new Cone[2];
        for (int i = 0; i < 2; i++) {
            cones[i] = (Cone) create(new Cone());
        }
        System.out.println();
        ry.setAction(() -> System.out.println(cones[0].hurl(ry, tigra)));
        tigra.setAction(() -> System.out.println(cones[1].hurl(tigra, ry)));
        makeActions(children);
        System.out.println();
        Consumer<Animal> forgetAll = (animal) ->
                System.out.printf(
                        "%s забыл(а) зачем пришел(а) в лес и оставил(а) корзинку под деревом%n",
                        animal.getName()
                );
        for (AnimalChild child : children) {
            child.setAction(() -> forgetAll.accept(child));
        }
        makeActions(children);
        System.out.println();
        for (AnimalChild child : children) {
            System.out.println(getFedText(child));
        }
        System.out.println();
        Consumer<AnimalChild> goHome = (animal) -> {
            System.out.printf("%s отправился(ась) домой%n", animal.getName());
        };
        for (AnimalChild child : children) {
            child.setAction(() -> goHome.accept(child));
        }
        makeActions(children);
        for (AnimalChild child : children) {
            child.setAction(() -> System.out.println(child.eat()));
        }
        makeActions(children);
        System.out.println();
        for (AnimalChild child : children) {
            System.out.println(getFedText(child));
        }
    }
    
    public static String getFishOilText(AnimalChild animalChild) {
        return String.format(
                "%s %s",
                animalChild.getName(),
                animalChild.isTookFishOil() ? "уже принял(а) рыбий жир" : "еще не принял(а) рыбий жир"
        );
    }
    
    public static String getFedText(AnimalChild animalChild) {
        return String.format(
                "%s %s",
                animalChild.getName(), animalChild.isFed() ? "уже сытый" : "еще голдный"
        );
    }

    public static Object create(Object object) {
        System.out.printf("Создан обьект - %s%n", object.toString());
        return object;
    }

    public static void makeActions(Animal[] animals) {
        for (Animal animal : animals) {
            animal.makeAction();
        }
    }

}
