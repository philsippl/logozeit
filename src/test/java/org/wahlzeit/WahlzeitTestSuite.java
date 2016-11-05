package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.handlers.HandlerTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.ServiceTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HandlerTestSuite.class,
        ModelTestSuite.class,
        ServiceTestSuite.class,
        UtilsTestSuite.class
})
public class WahlzeitTestSuite {
}
