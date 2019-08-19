package io.github.henryssondaniel.teacup.protocol.ftp.client;

/**
 * Configuration.
 *
 * @since 1.0
 */
public interface Configuration {
  /**
   * Returns the default date format string.
   *
   * @return the default date format string
   * @since 1.0
   */
  String getDefaultDateFormatString();

  /**
   * Returns the recent date format string.
   *
   * @return the recent date format string
   * @since 1.0
   */
  String getRecentDateFormatString();

  /**
   * Returns the server language code.
   *
   * @return the server language code
   * @since 1.0
   */
  String getServerLanguageCode();

  /**
   * Returns the server time zone ID.
   *
   * @return the server time zone ID
   * @since 1.0
   */
  String getServerTimeZoneId();

  /**
   * Returns the short month names.
   *
   * @return the short month names
   * @since 1.0
   */
  String getShortMonthNames();

  /**
   * Returns the system key.
   *
   * @return the system key
   * @since 1.0
   */
  String getSystemKey();

  /**
   * Returns whether or not it has lenient future dates.
   *
   * @return whether or not it has lenient future dates
   * @since 1.0
   */
  boolean hasLenientFutureDates();

  /**
   * Returns whether or not it should save unparseable entries.
   *
   * @return whether or not it should save unparseable entries
   * @since 1.0
   */
  boolean shouldSaveUnparseableEntries();
}
