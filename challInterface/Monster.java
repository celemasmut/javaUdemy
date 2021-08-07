package udemy.challInterface;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoinst;
    private int strenght;

    public Monster(String name, int hitPoinst, int strenght) {
        this.name = name;
        this.hitPoinst = hitPoinst;
        this.strenght = strenght;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoinst() {
        return hitPoinst;
    }

    public void setHitPoinst(int hitPoinst) {
        this.hitPoinst = hitPoinst;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<>();
        values.add(0,this.name);
        values.add(1,""+this.hitPoinst);
        values.add(2,""+ this.strenght);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
        if(savedValues != null && savedValues.size() > 0) {
            this.name = savedValues.get(0);
            this.hitPoinst = Integer.parseInt(savedValues.get(1));
            this.strenght = Integer.parseInt(savedValues.get(2));
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoinst=" + hitPoinst +
                ", strenght=" + strenght +
                '}';
    }
}
