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

    /**
     * Construieste tabla de joc.
     * @param linesN numarul de linii
     * @param lengthM numarul de coloane
     * @param fields lista de stringuri ce contine N stringuri de lungime M cu
     *               literele corespunzatoare locatiilor
     * @return returneaza o matrice n*m cu elemente de tipul TypeOfField
     */
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

    /**
     * Determina tipul locatiei.
     * @param map o matrice cu elemente de tipul TypeofField
     * @param x coordonata x
     * @param y coordonata y
     * @return tipul locatiei corespunzatoare coordonatelor(x,y)
     */
    public static TypeOfField getFieldType(final TypeOfField[][] map, final int x, final int y) {
        return map[x][y];
    }
}
