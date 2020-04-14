public class BillAccounts {
    private int AccountID;
    private String AccountNumber;
    private String Currency;
    private String Bank;
    private String PaymentDetails;
    private String IsActual;
    private String IsDefault;
    private String CreateDate;
    private String LastUpdateDate;
    private String IsCorrect;
    private String letterCode;

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getLetterCode() {
        return letterCode;
    }

    public void setLetterCode(String letterCode) {
        this.letterCode = letterCode;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int accountID) {
        AccountID = accountID;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getPaymentDetails() {
        return PaymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        PaymentDetails = paymentDetails;
    }

    public String getIsActual() {
        return IsActual;
    }

    public void setIsActual(String isActual) {
        IsActual = isActual;
    }

    public String getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(String isDefault) {
        IsDefault = isDefault;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
    }

    public String getLastUpdateDate() {
        return LastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        LastUpdateDate = lastUpdateDate;
    }

    public String getIsCorrect() {
        return IsCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        IsCorrect = isCorrect;
    }


}

//class Currency {
//    private int DigitalCode;
//    private String LetterCode;
////				<Name xmlns="">РОССИЙСКИЙ РУБЛЬ</Name>
////				<CountriesTerritoriesDesignation xmlns="">РОССИЯ</CountriesTerritoriesDesignation>
////				<StartDate xmlns="">2001-01-01</StartDate>
////				<EndDate xmlns="">2099-12-01</EndDate>
////				<CreatedAt xmlns="">2015-07-22T14:22:58Z</CreatedAt>
////				<UpdatedAt xmlns="">2016-02-14T15:01:09Z</UpdatedAt>
//}
