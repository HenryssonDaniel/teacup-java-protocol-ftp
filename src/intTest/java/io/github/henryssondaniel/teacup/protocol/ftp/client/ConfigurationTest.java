package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConfigurationTest {
  private static final String DEFAULT_DATE_FORMAT_STRING = "defaultDateFormatString";
  private static final String RECENT_DATE_FORMAT_STRING = "recentDateFormatString";
  private static final String SERVER_LANGUAGE_CODE = "serverLanguageCode";
  private static final String SERVER_TIME_ZONE_ID = "serverTimeZoneId";
  private static final String SHORT_MONTH_NAMES = "shortMonthNames";
  private static final String SYSTEM_KEY = "systemKey";

  @Test
  void createConfigurationBuilder() {
    var configuration =
        Factory.createConfigurationBuilder(SYSTEM_KEY)
            .setDefaultDateFormatString(DEFAULT_DATE_FORMAT_STRING)
            .setLenientFutureDates(true)
            .setRecentDateFormatString(RECENT_DATE_FORMAT_STRING)
            .setSaveUnparseableEntries(true)
            .setServerLanguageCode(SERVER_LANGUAGE_CODE)
            .setServerTimeZoneId(SERVER_TIME_ZONE_ID)
            .setShortMonthNames(SHORT_MONTH_NAMES)
            .build();

    assertThat(configuration.getDefaultDateFormatString()).isEqualTo(DEFAULT_DATE_FORMAT_STRING);
    assertThat(configuration.getRecentDateFormatString()).isEqualTo(RECENT_DATE_FORMAT_STRING);
    assertThat(configuration.getServerLanguageCode()).isEqualTo(SERVER_LANGUAGE_CODE);
    assertThat(configuration.getServerTimeZoneId()).isEqualTo(SERVER_TIME_ZONE_ID);
    assertThat(configuration.getShortMonthNames()).isEqualTo(SHORT_MONTH_NAMES);
    assertThat(configuration.getSystemKey()).isEqualTo(SYSTEM_KEY);
    assertThat(configuration.hasLenientFutureDates()).isTrue();
    assertThat(configuration.shouldSaveUnparseableEntries()).isTrue();
  }
}
