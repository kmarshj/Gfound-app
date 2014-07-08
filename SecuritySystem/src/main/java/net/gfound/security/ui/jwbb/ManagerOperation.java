package net.gfound.security.ui.jwbb;

import net.gfound.security.ui.jwbb.Constants.ManagerOperationType;
import net.gfound.security.ui.jwbb.Constants.ManagerPoliceType;

/**
 * Created by czhang on 14-7-8.
 */
public class ManagerOperation {

    private ManagerOperationType operationType;
    private String operationName;
    private ManagerPoliceType policeType;

    public ManagerOperation(ManagerOperationType operationType, ManagerPoliceType policeType, String operationName) {
        this.operationType = operationType;
        this.operationName = operationName;
        this.policeType = policeType;
    }

    public String getOperationName() {
        return operationName;
    }

    public ManagerOperationType getOperationType() {
        return operationType;
    }

    public ManagerPoliceType getPoliceType() {
        return policeType;
    }
}
