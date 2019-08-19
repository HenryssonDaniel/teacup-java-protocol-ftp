package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConfigurationImpl implements ConfigurationSetter {
  private static final Logger LOGGER = Factory.getLogger(ConfigurationImpl.class);

  private final String systemKey;

  private String defaultDateFormatString;
  private boolean lenientFutureDates;
  private String recentDateFormatString;
  private boolean saveUnparseableEntries;
  private String serverLanguageCode;
  private String serverTimeZoneId;
  private String shortMonthNames;

  ConfigurationImpl(String systemKey) {
    this.systemKey = systemKey;
  }

  @Override
  public String getDefaultDateFormatString() {
    return defaultDateFormatString;
  }

  @Override
  public String getRecentDateFormatString() {
    return recentDateFormatString;
  }

  @Override
  public String getServerLanguageCode() {
    return serverLanguageCode;
  }

  @Override
  public String getServerTimeZoneId() {
    return serverTimeZoneId;
  }

  @Override
  public String getShortMonthNames() {
    return shortMonthNames;
  }

  @Override
  public String getSystemKey() {
    return systemKey;
  }

  @Override
  public boolean hasLenientFutureDates() {
    LOGGER.log(Level.INFO, "Has lenient future dates");
    return lenientFutureDates;
  }

  @Override
  public void setDefaultDateFormatString(String defaultDateFormatString) {
    this.defaultDateFormatString = defaultDateFormatString;
  }

  @Override
  public void setLenientFutureDates(boolean lenientFutureDates) {
    this.lenientFutureDates = lenientFutureDates;
  }

  @Override
  public void setRecentDateFormatString(String recentDateFormatString) {
    this.recentDateFormatString = recentDateFormatString;
  }

  @Override
  public void setSaveUnparseableEntries(boolean saveUnparseableEntries) {
    this.saveUnparseableEntries = saveUnparseableEntries;
  }

  @Override
  public void setServerLanguageCode(String serverLanguageCode) {
    this.serverLanguageCode = serverLanguageCode;
  }

  @Override
  public void setServerTimeZoneId(String serverTimeZoneId) {
    this.serverTimeZoneId = serverTimeZoneId;
  }

  @Override
  public void setShortMonthNames(String shortMonthNames) {
    this.shortMonthNames = shortMonthNames;
  }

  @Override
  public boolean shouldSaveUnparseableEntries() {
    LOGGER.log(Level.INFO, "Should save unparseable entries");
    return saveUnparseableEntries;
  }
}
