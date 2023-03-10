package com.deke.testredisdbjpa.utils.messages;

public class ExceptionMessages {
    private ExceptionMessages() {}

    public static final String NULL_INPUT = "You Should Give Me At Least One Key " ;
    public static final String NON_MATCHED_ANY_ENTITY = "There is no matching data based on the number entered ";
    public static final String NON_MATCHED_BY_ID = "There is no matching data based on the id entered ";

    public static final String HTTP_REQUEST_WRONG_METHOD = "HTTP request method is not supported " ;
    public static final String NOT_FOUND = "Not found";
}
