package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.wahlzeit.services.mailing.MailingTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MailingTestSuite.class,
        LogBuilderTest.class,
        EmailAddressTest.class
})
public class ServiceTestSuite {
}
