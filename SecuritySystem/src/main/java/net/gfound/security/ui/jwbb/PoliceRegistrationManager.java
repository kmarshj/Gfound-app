package net.gfound.security.ui.jwbb;

import java.util.ArrayList;
import java.util.List;

import net.gfound.security.ui.jwbb.Constants.ManagerOperationType;
import net.gfound.security.ui.jwbb.Constants.ManagerPoliceType;

/**
 * Created by czhang on 14-7-7.
 */
public class PoliceRegistrationManager {

    private String name;
    private ManagerPoliceType policeType;
    private List<ManagerOperation> operationList;

    public PoliceRegistrationManager(ManagerPoliceType policeType, String name) {
        this.policeType = policeType;
        this.name = name;
        operationList = new ArrayList<ManagerOperation>();
        operationList.add(0,new ManagerOperation(ManagerOperationType.ADD, policeType, "添加"));
        operationList.add(1,new ManagerOperation(ManagerOperationType.QUERY, policeType, "查询"));
        operationList.add(2,new ManagerOperation(ManagerOperationType.MODIFY, policeType, "修改"));
    }

    public String getName() {
        return name;
    }

    public ManagerPoliceType getPoliceType() {
        return policeType;
    }

    public ManagerOperation getManagerOperation(int index){
        switch (index){
            case 0:
                return operationList.get(0);
            case 1:
                return operationList.get(1);
            case 2:
                return operationList.get(2);
            default:
                return null;
        }
    }

}
