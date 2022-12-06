package entity;

import entity.loan.Loan;

import java.math.BigDecimal;
import java.util.Date;

public class Payment extends BaseEntity {

    private Student student;
    private BigDecimal amount;
    private Loan loan;
    private Date date;
    private boolean payed;

    @Override
    public void setId(Long id) {

    }

    @Override
    public Long getId() {
        return null;
    }
}
