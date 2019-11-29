package map;

import java.util.List;

/**
 * Singleton class.
 */
public final class Map {
    private static Map instance;
    private Map() {

    }
    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    public static TypeOfField[][] makeMap(final int linesN, final int lengthM,
                                          final List<String> fields) {
        TypeOfField[][] map  = new TypeOfField[linesN][lengthM];
        for (int i = 0; i < linesN; i++) {
            for (int j = 0; j < lengthM; j++) {
               switch (fields.get(j).charAt(i)) {
                   case 'L':
                       map[i][j] = TypeOfField.Land;
                       break;
                   case 'V':
                       map[i][j] = TypeOfField.Volcanic;
                       break;
                   case 'D':
                       map[i][j] = TypeOfField.Desert;
                       break;
                   case 'W':
                       map[i][j] = TypeOfField.Woods;
                       break;
                   default:
                       System.out.println("invalid type of land");
               }
            }
        }
        return map;
    }

    public static TypeOfField getFieldType(final TypeOfField[][] map, final int x, final int y) {
        return map[x][y];
    }
}
