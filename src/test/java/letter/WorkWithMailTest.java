package letter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class WorkWithMailTest {

    private WorkWithMail mail;

    @Before
    public void setUp() throws Exception {
        mail = new WorkWithMail();
        mail.setDriverChrome();
    }

    @Test
    public void loginUkrNet() {
        mail.setLogin("yuksi_test");
        mail.setPsw("test_yuksi");
        Assert.assertEquals("yuksi_test@ukr.net", mail.loginUkrNet());
    }
    @Test
    public void notLoginUkrNetRightPsw() {
        mail.setLogin("yuksi_ddfev");
        mail.setPsw("s");
        Assert.assertNotEquals("yuksi_ddfev", mail.loginUkrNet());
    }
    @Test
    public void notLoginUkrNetNoSuchLogin() {
        mail.setLogin("abracadabraabracadabra");
        mail.setPsw("s");
        Assert.assertNotEquals("abracadabraabracadabra", mail.loginUkrNet());
    }
    @Test
    public void notLoginUkrNetNoLogin() {
        mail.setLogin("");
        mail.setPsw("s");
        Assert.assertNotEquals("", mail.loginUkrNet());
    }

    @After
    public void tearDown() throws Exception {
        mail.endWork();
    }
}