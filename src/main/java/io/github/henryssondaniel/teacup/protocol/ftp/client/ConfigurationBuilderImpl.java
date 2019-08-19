package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.core.DefaultBuilder;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConfigurationBuilderImpl extends DefaultBuilder<Configuration, ConfigurationSetter>
    implements ConfigurationBuilder {
  private static final Logger LOGGER = Factory.getLogger(ConfigurationBuilderImpl.class);
  private final String systemKey;

  ConfigurationBuilderImpl(String systemKey) {
    super(new ConfigurationImpl(systemKey));
    this.systemKey = systemKey;
  }

  @Override
  public ConfigurationBuilder setDefaultDateFormatString(String defaultDateFormatString) {
    LOGGER.log(Level.INFO, "Set default date format string");
    getImplementation().setDefaultDateFormatString(defaultDateFormatString);
    return this;
  }

  @Override
  public ConfigurationBuilder setLenientFutureDates(boolean lenientFutureDates) {
    LOGGER.log(Level.INFO, "Set lenient future dates");
    getImplementation().setLenientFutureDates(lenientFutureDates);
    return this;
  }

  @Override
  public ConfigurationBuilder setRecentDateFormatString(String recentDateFormatString) {
    LOGGER.log(Level.INFO, "Set recent date format string");
    getImplementation().setRecentDateFormatString(recentDateFormatString);
    return this;
  }

  @Override
  public ConfigurationBuilder setSaveUnparseableEntries(boolean saveUnparseableEntries) {
    LOGGER.log(Level.INFO, "Set save unparseable entries");
    getImplementation().setSaveUnparseableEntries(saveUnparseableEntries);
    return this;
  }

  @Override
  public ConfigurationBuilder setServerLanguageCode(String serverLanguageCode) {
    LOGGER.log(Level.INFO, "Set server language code");
    getImplementation().setServerLanguageCode(serverLanguageCode);
    return this;
  }

  @Override
  public ConfigurationBuilder setServerTimeZoneId(String serverTimeZoneId) {
    LOGGER.log(Level.INFO, "Set server time zone ID");
    getImplementation().setServerTimeZoneId(serverTimeZoneId);
    return this;
  }

  @Override
  public ConfigurationBuilder setShortMonthNames(String shortMonthNames) {
    LOGGER.log(Level.INFO, "Set short month names");
    getImplementation().setShortMonthNames(shortMonthNames);
    return this;
  }

  @Override
  protected ConfigurationSetter createImplementation() {
    return new ConfigurationImpl(systemKey);
  }
}
