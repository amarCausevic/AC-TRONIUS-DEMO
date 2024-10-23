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

  @Key("${environment}.jsonPlaceholder.baseUri")
  String jsonPlaceholderBaseUri();

  @Key("${environment}.sauce.username")
  String sauceUsername();

  @Key("${environment}.sauce.password")
  String saucePassword();

  @Key("${environment}.sauce.customer.name")
  String sauceCustomerName();

  @Key("${environment}.sauce.customer.lastName")
  String sauceCustomerLastName();

  @Key("${environment}.sauce.customer.postalCode")
  String sauceCustomerPostalCode();

  @Key("schema.posts")
  String schemaPosts();

  @Key("schema.add.post")
  String addPostSchema();

  @Key("schema.update.post")
  String updatePostSchema();
}