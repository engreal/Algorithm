package canopy;

import java.util.Collection;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Collection<Position> dataSet = DataSet.makeData(10000, 0);
        Position zero = new Position(0, 0);
        Canopy model = new Canopy(800, 600);
        Map<Position, Collection<Position>> canopies; 
        canopies = model.setDataSet(dataSet).clac().getResult();
        
        System.out.println(canopies.size());
        for (Position key : canopies.keySet()) {
            System.out.print(key);
//            System.out.print(" : ");
//            for (Position p : canopies.get(key)) {
//                System.out.print(p);
//                System.err.print(',');
//            }
            System.out.println("");
        }
    }
    
}
