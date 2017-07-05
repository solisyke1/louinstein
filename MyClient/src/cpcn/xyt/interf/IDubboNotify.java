package cpcn.xyt.interf;

import cpcn.xyt.domain.Person;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * xuting63      2017年6月21日       TODO
 * </pre>
 */
public interface IDubboNotify {
    public void onreturn(Person msg, Integer id);
    public void onthrow(Throwable ex, Integer id);
}

