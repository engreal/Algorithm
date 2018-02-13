package canopy;
import java.util.Random;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
        
public class DataSet {
    public static Collection<Position> makeData(int size, long seed) {
        Set<Position> dataSet = new HashSet<>(size);
        Random random = new Random(seed);
        while (dataSet.size() < size) {
            int x = random.nextInt() % 1000;
            int y = random.nextInt() % 1000;
            dataSet.add(new Position(x, y));
        }
        return dataSet;
    }
    
    
    public static Collection<Position> makeData(int size) {
        Set<Position> dataSet = new HashSet<>(size);
        Random random = new Random();
        while (dataSet.size() < size) {
            int x = random.nextInt() % 1000;
            int y = random.nextInt() % 1000;
            dataSet.add(new Position(x, y));
        }
        return dataSet;
    }
}
