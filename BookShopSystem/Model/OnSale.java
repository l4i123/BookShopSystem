package Model;

import java.time.LocalDateTime;

public class OnSale {
    private int idOnSale;
    private String code;
    private String codeName;
    private double discountPercentage;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;

    public OnSale(int idOnSale, String code, String codeName, double discountPercentage,
                  LocalDateTime validFrom, LocalDateTime validUntil) {
        this.idOnSale = idOnSale;
        this.code = code;
        this.codeName = codeName;
        this.discountPercentage = discountPercentage;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
    }

    public int getIdOnSale() {
         return idOnSale; 
        }
    public String getCode() {
         return code; 
        }
    public String getCodeName() { 
        return codeName; 
    }
    public double getDiscountPercentage() {
         return discountPercentage; 
        }
    public LocalDateTime getValidFrom() {
         return validFrom; 
        }
    public LocalDateTime getValidUntil() { 
        return validUntil; 
    }
    

    public void setCode(String code) { 
        this.code = code;
     }
    public void setCodeName(String codeName) { 
        this.codeName = codeName; 
    }
    public void setDiscountPercentage(double discountPercentage) {
         this.discountPercentage = discountPercentage; 
    }
    public void setValidFrom(LocalDateTime validFrom) {
         this.validFrom = validFrom; 
    }
    public void setValidUntil(LocalDateTime validUntil) { 
        this.validUntil = validUntil; 
    }
}
