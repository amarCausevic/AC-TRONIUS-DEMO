package org.tronius;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("org.tronius")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "html:cucumber-reports/Cucumber.html"
)
public class RunCucumberTest {

}
