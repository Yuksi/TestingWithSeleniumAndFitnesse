package letter;

public class MailFixture {
    private String login;
    private String psw;
    private WorkWithMail workWithMail;

    public MailFixture() {
        workWithMail = new WorkWithMail();
        workWithMail.setDriverChrome();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String login() {
        return workWithMail.loginUkrNet();
    }
}
