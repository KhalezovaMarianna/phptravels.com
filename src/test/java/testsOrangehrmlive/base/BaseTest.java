package testsOrangehrmlive.base;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import webOrangehrmlive.utils.services.AuthorisationService;


public class BaseTest extends AbstractTest {
    protected AuthorisationService authorisationService  = new AuthorisationService();
}
