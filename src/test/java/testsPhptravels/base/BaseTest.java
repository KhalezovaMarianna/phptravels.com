package testsPhptravels.base;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import webPhptravel.utils.services.AuthenticationService;

public class BaseTest extends AbstractTest {

    protected AuthenticationService authenticationService = new AuthenticationService();

}
