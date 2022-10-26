package testsOrangehrmlive.base;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import webOrangehrmlive.utils.services.AddPersonsService;
import webOrangehrmlive.utils.services.NavigationService;
import webOrangehrmlive.utils.services.AuthorisationService;


public class BaseTest extends AbstractTest {

    protected AddPersonsService addPersonsService = new AddPersonsService();
    protected AuthorisationService authorisationService  = new AuthorisationService();
    protected NavigationService navigationService =new NavigationService();
}
