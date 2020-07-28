package th.ac.utcc.cpe.data_structures.tree;

import java.util.Comparator;

/**
 *
 * @author Suparerk Manitpornsut
 */
public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
    
}
