package cpcn.xyt.interf;

import java.util.HashMap;
import java.util.Map;

import cpcn.xyt.domain.Person;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * xuting63      2017年6月21日       TODO
 * </pre>
 */
public class SearchNotify implements IDubboNotify {

    public Map<Integer, Person>    ret    = new HashMap<Integer, Person>();
    public Map<Integer, Throwable> errors = new HashMap<Integer, Throwable>();
    
    public void onreturn(Person msg, Integer id ) {
        System.out.println("onreturn:" + msg);
        System.out.println("onreturn:" + id);
        ret.put(id, msg);
    }
    
    public void onthrow(Throwable ex, Integer id) {
        errors.put(id, ex);
    }
}

