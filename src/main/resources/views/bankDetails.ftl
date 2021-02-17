<#-- @ftlvariable name="" type="models.BankDetails" -->
<#import "macros.ftl" as macros>

<!DOCTYPE html>
<html lang="en">
<@macros.header title="Bank Details"/>
<@macros.body>
    <h1 class="govuk-heading-l">Bank or building society account details</h1>

    <form method="post" action="http://localhost:8095">
        <div class="govuk-form-group">
            <label class="govuk-label" for="name-on-the-account">
                Name on the account
            </label>
            <#if bankDetails.errors["name"]??>
            <#list bankDetails.errors["name"] as error>
                <div class="govuk-hint red">
                    ${error}
                </div>
            </#list>
            </#if>
            <input <#if bankDetails.nameOnAccount??> value="${bankDetails.nameOnAccount}" </#if> class="govuk-input" id="name-on-the-account" name="name-on-the-account" type="text" spellcheck="false">
        </div>

        <div class="govuk-form-group">
            <label class="govuk-label" for="sort-code">
                Sort code
            </label>
            <#if bankDetails.errors["sortCode"]??>
            <#list bankDetails.errors["sortCode"] as error>
                <div class="govuk-hint red">
                    ${error}
                </div>
            </#list>
            <#else>
                <div id="sort-code-hint" class="govuk-hint">
                    Must be 6 digits long
                </div>
            </#if>
            <input <#if bankDetails.sortCode != 0> value="${bankDetails.sortCode}" </#if> class="govuk-input govuk-input--width-5" id="sort-code" name="sort-code" type="text" spellcheck="false"
                   aria-describedby="sort-code-hint" pattern="[0-9]*" inputmode="numeric">
        </div>

        <div class="govuk-form-group">
            <label class="govuk-label" for="account-number">
                Account number
            </label>
                <div id="account-number-hint" class="govuk-hint">
                    Must be between 6 and 8 digits long
                </div>
            <input <#if bankDetails.accountNumber != 0> value="${bankDetails.accountNumber}" </#if> class="govuk-input govuk-input--width-10" id="account-number" name="account-number" type="text"
                   spellcheck="false" aria-describedby="account-number-hint" pattern="[0-9]*" inputmode="numeric">
        </div>

        <div class="govuk-form-group">
            <label class="govuk-label" for="roll-number">
                Building society roll number (if you have one)
            </label>
                <div id="roll-number-hint" class="govuk-hint">
                    You can find it on your card, statement or passbook
                </div>
            <input <#if bankDetails.buildingSocNumber != 0> value="${bankDetails.buildingSocNumber}" </#if> class="govuk-input govuk-input--width-10" id="roll-number" name="roll-number" type="text" spellcheck="false"
                   aria-describedby="roll-number-hint">
        </div>

        <button type="submit" class="govuk-button" data-module="govuk-button">
            Continue
        </button>
    </form>
</@macros.body>
<@macros.footer/>
</html>