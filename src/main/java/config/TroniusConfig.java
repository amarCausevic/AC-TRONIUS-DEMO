package config;

import static org.aeonbits.owner.Config.LoadPolicy;
import static org.aeonbits.owner.Config.LoadType;
import static org.aeonbits.owner.Config.Sources;

import org.aeonbits.owner.Config;

@LoadPolicy(LoadType.MERGE)
@Sources({
    "system:properties",
    "system:env",
    "file:${user.dir}/src/test/resources/tronius-config.properties",
})
public interface TroniusConfig extends Config {

  @DefaultValue("PROD")
  String environment();

  @Key("${environment}.sauce.baseUri")
  String sauceBaseUri();

  @Key("${environment}.sauce.username")
  String sauceUsername();

  @Key("${environment}.sauce.password")
  String saucePassword();
}