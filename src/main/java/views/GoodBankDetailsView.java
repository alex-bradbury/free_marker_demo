package views;

import io.dropwizard.views.View;
import models.BankDetails;

public class GoodBankDetailsView extends View {
    private final BankDetails bankDetails;

    public GoodBankDetailsView(BankDetails bankDetails) {
        super("goodBankDetails.ftl");
        this.bankDetails = bankDetails;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }
}
