package com.github.signed.codeoftheweek.validator;

import org.junit.Test;

public class LongRangeValidator_Test {

    @Test
    public void isValid() throws Exception {
        LongRangeValidator validator = new LongRangeValidator();
        validator.validate(7);
    }

    @Test
    public void boundsValid() throws Exception {
        LongRangeValidator validator = new LongRangeValidator();
        validator.setMaximum(8l);
        validator.setMinimum(7l);

        validator.validate(7);
    }

    @Test(expected = ValidatorException.class)
    public void maximumTooLow() throws Exception {
        LongRangeValidator validator = new LongRangeValidator();
        validator.setMinimum(15l);

        validator.validate(7);
    }

    @Test
    public void maximumValid() throws Exception {
        LongRangeValidator validator = new LongRangeValidator();
        validator.setMaximum(8l);

        validator.validate(7);
    }

    @Test
    public void minimum() throws Exception {
        LongRangeValidator validator = new LongRangeValidator();
        validator.setMinimum(7l);

        validator.validate(7);
    }

    @Test(expected = ValidatorException.class)
    public void invalidMinimum() throws Exception {
        LongRangeValidator validator = new LongRangeValidator();
        validator.setMinimum(8l);

        validator.validate(7);
    }
}
