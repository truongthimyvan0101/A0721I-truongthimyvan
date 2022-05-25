package com.codegym.borrow_book_app.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ReturnCodeWrapper {
    @NotNull
    @Size(min = 5, max = 5, message = "Code must have 5 digits")
    private String returnCode;

    public ReturnCodeWrapper() {
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }
}
