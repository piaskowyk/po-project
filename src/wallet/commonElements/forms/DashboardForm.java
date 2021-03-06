package wallet.commonElements.forms;

import java.util.Date;

public class DashboardForm {

    private boolean standardMode;
    private Date dateStart;
    private Date dateEnd;

    public boolean isStandardMode() {
        return standardMode;
    }

    public void setStandardMode(boolean standardMode) {
        this.standardMode = standardMode;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}
