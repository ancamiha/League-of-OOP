package main;

import heroes.Hero;
import heroes.HeroType;
import heroes.PrintResult;
import map.Map;
import map.TypeOfField;
import java.util.List;

public final class Main {
    private Main() {
        // just to trick checkstyle
    }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        TypeOfField[][] map = Map.makeMap(gameInput.getLinesN(), gameInput.getLengthM(),
                                          gameInput.getFields());

        List<Hero> heroes = gameInput.getHeroes();
        for (int i = 0; i < gameInput.getRounds(); i++) {
            //se seteaza tipul locatiei pentru fiecare jucator
            for (Hero hero : heroes) {
                hero.setField(Map.getFieldType(map, hero.getPosX(), hero.getPosY()));
            }
            /*se verifica fiecare jucator pentru a se vedea daca trebuie sa primeasca
            damage overtime*/
            for (int j = 0; j < heroes.size(); j++) {
                Hero hero = heroes.get(j);
                if (hero.getStillApply()) {
                    hero.updateHp(hero.getDamage());
                    hero.updateTime();
                    if (hero.getTime() == 0) {
                        hero.updateStillApply();
                    }
                }
                hero.moveHero(gameInput.getrDescription().get(i).charAt(j));
                hero.setField(Map.getFieldType(map, hero.getPosX(), hero.getPosY()));
            }
            //lupta
            for (int j = 0; j < heroes.size(); j++) {
                for (int k = j + 1; k < heroes.size(); k++) {
                    Hero hero1 = heroes.get(j);
                    Hero hero2 = heroes.get(k);
                    if (hero1.getPosX() == hero2.getPosX()
                        && hero1.getPosY() == hero2.getPosY()
                        && hero1.isNotDead() && hero2.isNotDead()) {
                        /*pentru aflarea valorii de damageReceived, jucatorul de tip Wizard
                        trebuie sa fie primul atacat*/
                        if ((hero2.getType()).equals(HeroType.Wizard)) {
                            (hero2).accept(hero1);
                            (hero1).accept(hero2);
                        } else {
                            (hero1).accept(hero2);
                            (hero2).accept(hero1);
                        }

                        if (!hero2.isNotDead()) {
                            hero1.increaseXP(hero2);
                        }
                        if (!hero1.isNotDead()) {
                            hero2.increaseXP(hero1);
                        }
                    }
                }
            }
            PrintResult.printR(heroes);
            System.out.println();
        }
        PrintResult.printR(heroes);
        PrintResult.print(heroes, args[1]);
    }
}

