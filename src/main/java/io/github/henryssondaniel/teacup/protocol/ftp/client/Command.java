package io.github.henryssondaniel.teacup.protocol.ftp.client;

/**
 * Commands.
 *
 * @since 1.0
 */
public enum Command {
  ABOR,
  ACCT,
  ALLO,
  APPE,
  CDUP,
  CWD,
  DELE,
  EPRT,
  EPSV,
  FEAT,
  HELP,
  LIST,
  MDTM,
  MFMT,
  MKD,
  MLSD,
  MLST,
  MODE,
  NLST,
  NOOP,
  PASS,
  PASV,
  PORT,
  PWD,
  QUIT,
  REIN,
  REST,
  RETR,
  RMD,
  RNFR,
  RNTO,
  SITE,
  SMNT,
  STAT,
  STOR,
  STOU,
  STRU,
  SYST,
  TYPE,
  USER,
  ;

  public static final Command ABORT = ABOR;
  public static final Command ACCOUNT = ACCT;
  public static final Command ALLOCATE = ALLO;
  public static final Command APPEND = APPE;
  public static final Command CHANGE_TO_PARENT_DIRECTORY = CDUP;
  public static final Command CHANGE_WORKING_DIRECTORY = CWD;
  public static final Command DATA_PORT = PORT;
  public static final Command DELETE = DELE;
  public static final Command FEATURES = FEAT;
  public static final Command FILE_STRUCTURE = STRU;
  public static final Command GET_MOD_TIME = MDTM;
  public static final Command LOGOUT = QUIT;
  public static final Command MAKE_DIRECTORY = MKD;
  public static final Command MOD_TIME = MDTM;
  public static final Command NAME_LIST = NLST;
  public static final Command PASSIVE = PASV;
  public static final Command PASSWORD = PASS;
  public static final Command PRINT_WORKING_DIRECTORY = PWD;
  public static final Command REINITIALIZE = REIN;
  public static final Command REMOVE_DIRECTORY = RMD;
  public static final Command RENAME_FROM = RNFR;
  public static final Command RENAME_TO = RNTO;
  public static final Command REPRESENTATION_TYPE = TYPE;
  public static final Command RESTART = REST;
  public static final Command RETRIEVE = RETR;
  public static final Command SET_MOD_TIME = MFMT;
  public static final Command SITE_PARAMETERS = SITE;
  public static final Command STATUS = STAT;
  public static final Command STORE = STOR;
  public static final Command STORE_UNIQUE = STOU;
  public static final Command STRUCTURE_MOUNT = SMNT;
  public static final Command SYSTEM = SYST;
  public static final Command TRANSFER_MODE = MODE;
  public static final Command USERNAME = USER;
}
