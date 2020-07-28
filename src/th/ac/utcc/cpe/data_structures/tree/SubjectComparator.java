package th.ac.utcc.cpe.data_structures.tree;

import java.util.Comparator;

/**
 *
 * @author Suparerk Manitpornsut
 */
public class SubjectComparator implements Comparator<Subject> {

    @Override
    public int compare(Subject s1, Subject s2) {
        return s1.getCode().compareTo(s2.getCode());
    }
    
}
