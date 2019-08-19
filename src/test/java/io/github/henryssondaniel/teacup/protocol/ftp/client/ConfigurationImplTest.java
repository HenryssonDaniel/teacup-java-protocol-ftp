package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConfigurationImplTest {
  private static final String SYSTEM_KEY = "systemKey";
  private final ConfigurationSetter configurationSetter = new ConfigurationImpl(SYSTEM_KEY);

  @Test
  void getDefaultDateFormatString() {
    assertThat(configurationSetter.getDefaultDateFormatString()).isNull();
  }

  @Test
  void getRecentDateFormatString() {
    assertThat(configurationSetter.getRecentDateFormatString()).isNull();
  }

  @Test
  void getServerLanguageCode() {
    assertThat(configurationSetter.getServerLanguageCode()).isNull();
  }

  @Test
  void getServerTimeZoneId() {
    assertThat(configurationSetter.getServerTimeZoneId()).isNull();
  }

  @Test
  void getShortMonthNames() {
    assertThat(configurationSetter.getShortMonthNames()).isNull();
  }

  @Test
  void getSystemKey() {
    assertThat(configurationSetter.getSystemKey()).isEqualTo(SYSTEM_KEY);
  }

  @Test
  void hasLenientFutureDates() {
    assertThat(configurationSetter.hasLenientFutureDates()).isFalse();
  }

  @Test
  void setAndGetDefaultDateFormatString() {
    var defaultDateFormatString = "defaultDateFormatString";
    configurationSetter.setDefaultDateFormatString(defaultDateFormatString);
    assertThat(configurationSetter.getDefaultDateFormatString()).isEqualTo(defaultDateFormatString);
  }

  @Test
  void setAndGetRecentDateFormatString() {
    var recentDateFormatString = "recentDateFormatString";
    configurationSetter.setRecentDateFormatString(recentDateFormatString);
    assertThat(configurationSetter.getRecentDateFormatString()).isEqualTo(recentDateFormatString);
  }

  @Test
  void setAndGetServerLanguageCode() {
    var serverLanguageCode = "serverLanguageCode";
    configurationSetter.setServerLanguageCode(serverLanguageCode);
    assertThat(configurationSetter.getServerLanguageCode()).isEqualTo(serverLanguageCode);
  }

  @Test
  void setAndGetServerTimeZoneId() {
    var serverTimeZoneId = "serverTimeZoneId";
    configurationSetter.setServerTimeZoneId(serverTimeZoneId);
    assertThat(configurationSetter.getServerTimeZoneId()).isEqualTo(serverTimeZoneId);
  }

  @Test
  void setAndGetShortMonthNames() {
    var shortMonthNames = "shortMonthNames";
    configurationSetter.setShortMonthNames(shortMonthNames);
    assertThat(configurationSetter.getShortMonthNames()).isEqualTo(shortMonthNames);
  }

  @Test
  void setAndGetSystemKey() {
    var shortMonthNames = "shortMonthNames";
    configurationSetter.setShortMonthNames(shortMonthNames);
    assertThat(configurationSetter.getShortMonthNames()).isEqualTo(shortMonthNames);
  }

  @Test
  void setAndHasLenientFutureDates() {
    configurationSetter.setLenientFutureDates(true);
    assertThat(configurationSetter.hasLenientFutureDates()).isTrue();
  }

  @Test
  void setAndShouldSaveUnparseableEntries() {
    configurationSetter.setSaveUnparseableEntries(true);
    assertThat(configurationSetter.shouldSaveUnparseableEntries()).isTrue();
  }

  @Test
  void shouldSaveUnparseableEntries() {
    assertThat(configurationSetter.shouldSaveUnparseableEntries()).isFalse();
  }
}
