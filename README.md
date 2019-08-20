# [User Guide](https://henryssondaniel.github.io/teacup.github.io/)
[![Build Status](https://travis-ci.com/HenryssonDaniel/teacup-java-protocol-ftp.svg?branch=master)](https://travis-ci.com/HenryssonDaniel/teacup-java-protocol-ftp)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=HenryssonDaniel_teacup-java-protocol-ftp&metric=coverage)](https://sonarcloud.io/dashboard?id=HenryssonDaniel_teacup-java-protocol-ftp)
[![latest release](https://img.shields.io/badge/release%20notes-1.0.0-yellow.svg)](https://github.com/HenryssonDaniel/teacup-java-protocol-ftp/blob/master/doc/release-notes/official.md)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.henryssondaniel.teacup.protocol/ftp.svg)](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22io.github.henryssondaniel.teacup.protocol%22%20AND%20a%3A%22ftp%22)
[![Javadocs](https://www.javadoc.io/badge/io.github.henryssondaniel.teacup.protocol/ftp.svg)](https://www.javadoc.io/doc/io.github.henryssondaniel.teacup.protocol/ftp)
## What ##
FTP/FTPS support.  

There is also support for an FTP server.
## Why ##
This makes it possible to test FTP with the framework, both the client and the server.
## How ##
Add this repository as a dependency.  

The Client interface holds all the functionality that the FTP client can do.  
The SecureClient interface holds all the functionality that the secure FTP client can do.  
New clients can be created with the Factory class in the client package.

The SimpleServer interface holds all the functionality that the FTP server can do.  
New servers can be created with the Factory class in the server package.