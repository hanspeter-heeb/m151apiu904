-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Erstellungszeit: 06. November 2010 um 06:51
-- Server Version: 5.1.41
-- PHP-Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Datenbank: `klassenliste`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `jos_categories`
--

CREATE TABLE IF NOT EXISTS `jos_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '',
  `section` varchar(50) NOT NULL DEFAULT '',
  `published` tinyint(1) NOT NULL DEFAULT '0',
  `checked_out` int(11) unsigned NOT NULL DEFAULT '0',
  `ordering` int(11) NOT NULL DEFAULT '0',
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `cat_idx` (`section`,`published`),
  KEY `idx_checkout` (`checked_out`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Daten für Tabelle `jos_categories`
--

INSERT INTO `jos_categories` (`id`, `title`, `section`, `published`, `checked_out`, `ordering`, `count`) VALUES
(1, 'Organe', '5', 1, 0, 1, 0),
(2, 'Dokumente', '5', 1, 0, 2, 0),
(3, 'Neue Projekte', '1', 1, 0, 3, 0),
(4, 'Behinderung', '2', 1, 0, 1, 0),
(5, 'Alter', '2', 1, 0, 2, 0),
(6, 'Jugend + Sport', '2', 1, 0, 3, 0),
(7, 'Jugendschutz', '2', 1, 0, 4, 0),
(8, 'Kultur', '2', 1, 0, 5, 0),
(9, 'Vorstand', '6', 1, 0, 1, 0),
(10, 'Geschäftsleitung', '6', 1, 0, 2, 0),
(11, 'Beratung', '6', 1, 0, 3, 0),
(12, 'Kontaktpersonen', '6', 1, 0, 4, 0),
(13, 'Dienstleistung', '4', 1, 0, 3, 0),
(14, 'Sponsorenliste', '3', 1, 0, 3, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `jos_sections`
--

CREATE TABLE IF NOT EXISTS `jos_sections` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '',
  `published` tinyint(1) NOT NULL DEFAULT '0',
  `checked_out` int(11) unsigned NOT NULL DEFAULT '0',
  `ordering` int(11) NOT NULL DEFAULT '0',
  `access` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Daten für Tabelle `jos_sections`
--

INSERT INTO `jos_sections` (`id`, `title`, `published`, `checked_out`, `ordering`, `access`, `count`) VALUES
(1, 'Projekte', 1, 0, 2, 0, 1),
(2, 'Begünstigte', 1, 0, 3, 0, 5),
(3, 'Sponsoren', 1, 0, 4, 0, 2),
(4, 'Spender', 1, 0, 5, 0, 1),
(5, 'Über uns', 1, 0, 1, 0, 5),
(6, 'Allgemein', 1, 0, 6, 0, 0);
