package wallet.commonElements.responses.dataResponses;

import wallet.commonElements.entity.PaymentItem;
import wallet.commonElements.responses.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class PaymentsHistoryResponse extends BaseResponse {

    private boolean status;
    private List<PaymentItem> paymentsHistory = new ArrayList<>();

    public PaymentsHistoryResponse(){
        super(200, "success");
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<PaymentItem> getPaymentsHistory() {
        return paymentsHistory;
    }

    public void setPaymentsHistory(List<PaymentItem> paymentsHistory) {
        this.paymentsHistory = paymentsHistory;
    }
}
