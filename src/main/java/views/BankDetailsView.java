package views;

import io.dropwizard.views.View;
import models.BankDetails;

public class BankDetailsView extends View {
    private final BankDetails bankDetails;

    public BankDetailsView(BankDetails bankDetails) {
        super("bankDetails.ftl");
        this.bankDetails = bankDetails;
    }

    public BankDetails getBankDetails() {
        return bankDetails;
    }
}
