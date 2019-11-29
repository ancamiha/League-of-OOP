package main;

import heroes.Hero;
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
        System.out.println(heroes);
        for (int i = 0; i < gameInput.getRounds(); i++) {
            for (int j = 0; j < heroes.size(); j++) {
                Hero hero = heroes.get(j);
                hero.moveHero(gameInput.getrDescription().get(i).charAt(j));
                hero.setField(Map.getFieldType(map, hero.getPosX(), hero.getPosY()));
//                System.out.println(hero.getOvertimeRouds());
//                System.out.println(hero.getStillApply());
                if (hero.getStillApply()) {
                    //System.out.println("se intra");
                    hero.updateHp(hero.getDamage());
                    hero.updateOvertimeRounds();
                    if (hero.getOvertimeRouds() == 0) {
                        hero.updateStillApply();
                    }
                }
            }
            for (int j = 0; j < heroes.size(); j++) {
                for (int k = j + 1; k < heroes.size(); k++) {
                    if (heroes.get(j).getPosX() == heroes.get(k).getPosX()
                        && heroes.get(j).getPosY() == heroes.get(k).getPosY()
                        && heroes.get(j).notDead() && heroes.get(k).notDead()) {
                        (heroes.get(j)).accept(heroes.get(k));
                        (heroes.get(k)).accept(heroes.get(j));
                    }
                }
            }
            Hero.printR(heroes);
            System.out.println();
        }

        Hero.printR(heroes);
        Hero.printResult(heroes, args[1]);
    }
}

