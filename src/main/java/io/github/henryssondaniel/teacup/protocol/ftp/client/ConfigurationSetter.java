package io.github.henryssondaniel.teacup.protocol.ftp.client;

interface ConfigurationSetter extends Configuration {
  void setDefaultDateFormatString(String defaultDateFormatString);

  void setLenientFutureDates(boolean lenientFutureDates);

  void setRecentDateFormatString(String recentDateFormatString);

  void setSaveUnparseableEntries(boolean saveUnparseableEntries);

  void setServerLanguageCode(String serverLanguageCode);

  void setServerTimeZoneId(String serverTimeZoneId);

  void setShortMonthNames(String shortMonthNames);
}
