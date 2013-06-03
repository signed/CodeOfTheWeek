package com.github.signed.codeoftheweek.validator;

public class LongRangeValidator {

    private Long minimum;
    private Long maximum;

    public void setMaximum(Long maximum) {
        this.maximum = maximum;
    }

    public void setMinimum(Long minimum) {
        this.minimum = minimum;
    }

    public void validate(Object object) throws ValidatorException {
        if (object == null) {
            return;
        }
        long value = Long.parseLong(object.toString());
        if (minimum != null && maximum != null && (minimum > value || value > maximum)) {
            throw new ValidatorException(new Message(Message.SEVERITY_ERROR.toString(), "Zahl zwischen " + minimum + " und " + maximum + " erwartet."));
        }
        if ((minimum != null) && (minimum > value)) {
            throw new ValidatorException(new Message(Message.SEVERITY_ERROR.toString(), "Zahl ab " + minimum + " erwartet."));
        }
        if ((maximum != null) && (maximum < value)) {
            throw new ValidatorException(new Message(Message.SEVERITY_ERROR.toString(), "Zahl bis " + maximum + " erwartet."));
        }
    }
}