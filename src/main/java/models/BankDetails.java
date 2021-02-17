package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankDetails {

    //@NotEmpty(message = "Name on Account must not be empty")
    @FormParam("name-on-the-account")
    private String nameOnAccount;

    //@Min(100000)
    //@Max(999999)
    @FormParam("sort-code")
    private int sortCode;

    @FormParam("account-number")
    private int accountNumber;

    @FormParam("roll-number")
    private int buildingSocNumber;

    //private List<String> nameOnAccountError;
    private final HashMap<String, List<String>> errors = new HashMap<>();

    public BankDetails() {
        //nameOnAccountError = new ArrayList<>();
    }

    public BankDetails(String nameOnAccount, int sortCode, int accountNumber, int buildingSocNumber) {
        this.nameOnAccount = nameOnAccount;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.buildingSocNumber = buildingSocNumber;
        //nameOnAccountError = new ArrayList<>();
    }

    @JsonProperty
    public String getNameOnAccount() {
        return nameOnAccount;
    }

    @JsonProperty
    public int getSortCode() {
        return sortCode;
    }

    @JsonProperty
    public int getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty
    public int getBuildingSocNumber() {
        return buildingSocNumber;
    }

    @JsonProperty
    public HashMap<String, List<String>> getErrors() {
        return errors;
    }

    public boolean checkDetails(){
        boolean result = true;

        //checks for name on account
        if(nameOnAccount.length() < 1){
            if(!errors.containsKey("name"))
                errors.put("name", new ArrayList<>());

            errors.get("name").add("Please enter a name");
            result = false;
        }
        if(nameOnAccount.length() < 2){
            if(!errors.containsKey("name"))
                errors.put("name", new ArrayList<>());

            errors.get("name").add("Please enter a name of length 2 or more");
        }

        //checks for sort code
        if(String.valueOf(sortCode).length() != 6){
            if(!errors.containsKey("sortCode"))
                errors.put("sortCode", new ArrayList<>());

            errors.get("sortCode").add("Sort Code must be 6 nums");
            result = false;
        }

        return result;
    }
}
