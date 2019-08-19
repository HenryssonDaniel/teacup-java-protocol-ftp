package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.core.Builder;

/**
 * Configuration builder interface.
 *
 * @since 1.0
 */
public interface ConfigurationBuilder extends Builder<Configuration> {
  /**
   * Sets the default date format string.
   *
   * @param defaultDateFormatString the default date format string
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setDefaultDateFormatString(String defaultDateFormatString);

  /**
   * Sets whether or not it has lenient future dates.
   *
   * @param lenientFutureDates whether or not it has lenient future dates
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setLenientFutureDates(boolean lenientFutureDates);

  /**
   * Sets the recent date format string.
   *
   * @param recentDateFormatString the recent date format string
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setRecentDateFormatString(String recentDateFormatString);

  /**
   * Sets whether or not it should save unparseable entries.
   *
   * @param saveUnparseableEntries whether or not it should save unparseable entries
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setSaveUnparseableEntries(boolean saveUnparseableEntries);

  /**
   * Sets the server language code.
   *
   * @param serverLanguageCode the server language code
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setServerLanguageCode(String serverLanguageCode);

  /**
   * Sets the server time zone ID.
   *
   * @param serverTimeZoneId the server time zone ID
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setServerTimeZoneId(String serverTimeZoneId);

  /**
   * Sets the short month names.
   *
   * @param shortMonthNames the short month names
   * @return the configuration builder
   * @since 1.0
   */
  ConfigurationBuilder setShortMonthNames(String shortMonthNames);
}
