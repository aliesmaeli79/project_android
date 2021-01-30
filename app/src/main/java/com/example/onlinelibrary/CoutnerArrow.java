package com.example.onlinelibrary;

class CounterArrow {

    private boolean counter_pass_arrow;
    private boolean counter_name_arrow ;
    private boolean counter_email_arrow ;

    public CounterArrow() {
        this.counter_pass_arrow = false;
        this.counter_name_arrow = false;
        this.counter_email_arrow = false;
    }

    public boolean isCounter_pass_arrow() {
        return counter_pass_arrow;
    }

    public void setCounter_pass_arrow(boolean counter_pass_arrow) {
        this.counter_pass_arrow = counter_pass_arrow;
    }

    public boolean isCounter_name_arrow() {
        return counter_name_arrow;
    }

    public void setCounter_name_arrow(boolean counter_name_arrow) {
        this.counter_name_arrow = counter_name_arrow;
    }

    public boolean isCounter_email_arrow() {
        return counter_email_arrow;
    }

    public void setCounter_email_arrow(boolean counter_email_arrow) {
        this.counter_email_arrow = counter_email_arrow;
    }
}
