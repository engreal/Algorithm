package canopy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Canopy {
    private Random random;
    private double t1;
    private double t2;
    private Collection<Position> dataSet;
    private Map<Position, Collection<Position>> canopies;
    
    
    public Canopy(double t1, double t2) {
        random = new Random();
        dataSet = new HashSet<>();
        canopies = new HashMap<>();
        
        if (t1 > t2 && t2 > 0) {
            this.t1 = t1;
            this.t2 = t2;
        } else {
            this.t1 = random.nextDouble() * 618 + 60;
            this.t2 = random.nextDouble() * 100;
        }
    }
    
    public Canopy setThreshold(double t1, double t2){
        if (t1 > t2 && t2 > 0) {
            this.t1 = t1;
            this.t2 = t2;
        } else {
            this.t1 = random.nextDouble() * 618 + 60;
            this.t2 = random.nextDouble() * 100;
        }
        return this;
    }
    
    public Canopy setDataSet(Collection<Position> dataSet) {
        this.dataSet = dataSet;
        return this;
    }
    
    public Canopy clac() {
        List<Position> positionList = new LinkedList(dataSet);
        canopies.clear();
        while (positionList.size() > 0) {
            int center_index = random.nextInt(positionList.size());
            Position center = positionList.get(center_index);
            Collection<Position> center_set = new HashSet<>();
            Iterator<Position> it = positionList.iterator();
            while (it.hasNext()) {
                Position p = it.next();
                double d = calcDiatance(center, p);
                if (d < this.t1) {
                    center_set.add(p);
                }
                if (d < this.t2) {
                    it.remove();
                }
            }
            canopies.put(center, center_set);
        }
        return this;
    }
    
   public Map<Position, Collection<Position>> getResult() {
       return canopies;
   }
    
    static public double calcDiatance(Position p1, Position p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
    
}
