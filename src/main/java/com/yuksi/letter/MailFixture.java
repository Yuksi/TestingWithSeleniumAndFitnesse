package com.yuksi.letter;

public class MailFixture {
    private WorkWithMail workWithMail;

    public MailFixture() {
        workWithMail = new WorkWithMail();
        workWithMail.setDriverChrome();
    }

    public void setLogin(String login) {
        this.workWithMail.setLogin(login);
    }

    public void setPsw(String psw) {
        this.workWithMail.setPsw(psw);
    }

    public String login() {
        return workWithMail.loginUkrNet();
    }
}
