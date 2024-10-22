package config.factory;

import config.TroniusConfig;
import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

  private ConfigFactory() {
  }

  public static TroniusConfig troniusConfig() {
    return ConfigCache.getOrCreate(TroniusConfig.class);
  }
}
