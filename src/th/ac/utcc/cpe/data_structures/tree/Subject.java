package th.ac.utcc.cpe.data_structures.tree;

/**
 *
 * @author Suparerk Manitpornsut
 */
public class Subject implements Comparable<Subject> {
    private String code;
    private String name;
    private float  units;
    
    public Subject(String code, String name, float units) {
        this.code = code;
        this.name = name;
        this.units = units;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnits() {
        return units;
    }

    public void setUnits(float units) {
        this.units = units;
    }
    
    @Override
    public String toString() {
        return code + " " + name + " " + units;
    }

    @Override
    public int compareTo(Subject s) {
        return this.code.compareTo(s.getCode());
    }
    
    
}
