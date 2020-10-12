package site.newvalue.domain;

import java.io.Serializable;
import java.util.List;

public class QueryVo2 implements Serializable {
    private List<Integer> ids;
    public List<Integer> getIds() {
        return ids;
    }
    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}