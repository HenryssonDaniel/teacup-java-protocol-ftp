package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ConfigurationBuilderImplTest {
  private static final String SYSTEM_KEY = "systemKey";

  @InjectMocks
  private final ConfigurationBuilder configurationBuilder =
      new ConfigurationBuilderImpl(SYSTEM_KEY);

  @Mock private ConfigurationSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ConfigurationBuilderImpl(SYSTEM_KEY).createImplementation())
        .isExactlyInstanceOf(ConfigurationImpl.class);
  }

  @Test
  void setDefaultDateFormatString() {
    var defaultDateFormatString = "defaultDateFormatString";
    assertThat(configurationBuilder.setDefaultDateFormatString(defaultDateFormatString))
        .isSameAs(configurationBuilder);
    verify(implementation).setDefaultDateFormatString(defaultDateFormatString);
  }

  @Test
  void setLenientFutureDates() {
    var lenientFutureDates = true;
    assertThat(configurationBuilder.setLenientFutureDates(lenientFutureDates))
        .isSameAs(configurationBuilder);
    verify(implementation).setLenientFutureDates(lenientFutureDates);
  }

  @Test
  void setRecentDateFormatString() {
    var recentDateFormatString = "recentDateFormatString";
    assertThat(configurationBuilder.setRecentDateFormatString(recentDateFormatString))
        .isSameAs(configurationBuilder);
    verify(implementation).setRecentDateFormatString(recentDateFormatString);
  }

  @Test
  void setSaveUnparseableEntries() {
    var saveUnparseableEntries = true;
    assertThat(configurationBuilder.setSaveUnparseableEntries(saveUnparseableEntries))
        .isSameAs(configurationBuilder);
    verify(implementation).setSaveUnparseableEntries(saveUnparseableEntries);
  }

  @Test
  void setServerLanguageCode() {
    var serverLanguageCode = "serverLanguageCode";
    assertThat(configurationBuilder.setServerLanguageCode(serverLanguageCode))
        .isSameAs(configurationBuilder);
    verify(implementation).setServerLanguageCode(serverLanguageCode);
  }

  @Test
  void setServerTimeZoneId() {
    var serverTimeZoneId = "serverTimeZoneId";
    assertThat(configurationBuilder.setServerTimeZoneId(serverTimeZoneId))
        .isSameAs(configurationBuilder);
    verify(implementation).setServerTimeZoneId(serverTimeZoneId);
  }

  @Test
  void setShortMonthNames() {
    var shortMonthNames = "shortMonthNames";
    assertThat(configurationBuilder.setShortMonthNames(shortMonthNames))
        .isSameAs(configurationBuilder);
    verify(implementation).setShortMonthNames(shortMonthNames);
  }
}
