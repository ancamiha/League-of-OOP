package main;

import map.Map;

public final class Main {
    private Main() {
        // just to trick checkstyle
    }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        Map.makeMap(gameInput.getLinesN(), gameInput.getLengthM(), gameInput.getFields());
        System.out.println(gameInput.getHeroes());
    }
}

