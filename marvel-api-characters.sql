SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


DROP TABLE IF EXISTS `character`;
CREATE TABLE IF NOT EXISTS `character` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `modified` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  `id_comic_list` int(11) DEFAULT NULL,
  `id_events_list` int(11) DEFAULT NULL,
  `id_series_list` int(11) DEFAULT NULL,
  `id_story_list` int(11) DEFAULT NULL,
  `id_image` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhjfsjg4xyt6l70eiwpp66tde4` (`id_comic_list`),
  KEY `FKj54bws9tiqma0b56ca4lnajtr` (`id_events_list`),
  KEY `FK1jmrmbfmqk3fm4cfuo5kvdo43` (`id_series_list`),
  KEY `FKp1v4txxn9i75ctd8kf6pnnsmh` (`id_story_list`),
  KEY `FKnade0kpp42sqn2ka44gqw982v` (`id_image`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `character` (`id`, `description`, `modified`, `name`, `resourceuri`, `id_comic_list`, `id_events_list`, `id_series_list`, `id_story_list`, `id_image`) VALUES
(1, 'A HERO A', '2020-03-20', 'A HERO A', '<mocked_uri_A>', 1, 1, 1, 1, 1),
(2, 'B HERO B', '2020-03-15', 'B HERO B', '<mocked_uri_B>', 2, 2, 2, 2, 2),
(3, 'C HERO C', '2020-03-10', 'C HERO C', '<mocked_uri_C>', 3, 3, 3, 3, 3);

DROP TABLE IF EXISTS `character_list`;
CREATE TABLE IF NOT EXISTS `character_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(11) DEFAULT NULL,
  `collectionuri` varchar(255) DEFAULT NULL,
  `returned` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `character_list` (`id`, `available`, `collectionuri`, `returned`) VALUES
(1, 3, '<mocked_comic_uri_A>', NULL),
(2, 3, '<mocked_comic_uri_B>', NULL),
(3, 3, '<mocked_comic_uri_C>', NULL);

DROP TABLE IF EXISTS `character_summary`;
CREATE TABLE IF NOT EXISTS `character_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `character_summary` (`id`, `name`, `resourceuri`, `role`) VALUES
(1, 'A HERO A', '<mocked_character_summary_A>', '<mocked_role_A>'),
(2, 'B HERO B', '<mocked_character_summary_B>', '<mocked_role_B>'),
(3, 'C HERO C', '<mocked_character_summary_C>', '<mocked_role_C>');

DROP TABLE IF EXISTS `comic`;
CREATE TABLE IF NOT EXISTS `comic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `diamond_code` varchar(255) DEFAULT NULL,
  `digital_id` int(11) DEFAULT NULL,
  `ean` varchar(255) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `issn` varchar(255) DEFAULT NULL,
  `issue_number` double DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `page_count` int(11) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `variant_description` varchar(255) DEFAULT NULL,
  `id_character_list` int(11) DEFAULT NULL,
  `id_creator_list` int(11) DEFAULT NULL,
  `id_series_summary` int(11) DEFAULT NULL,
  `id_story_list` int(11) DEFAULT NULL,
  `id_image` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5ufonbfpsld4jnvh8c3mjy7lj` (`id_character_list`),
  KEY `FKawfo3yndkami9icq7ra3x4ja3` (`id_creator_list`),
  KEY `FK2c84konkauctslurl2q9493p3` (`id_series_summary`),
  KEY `FK8hu17frdxqs6p9x00ccyf8h67` (`id_story_list`),
  KEY `FK76fq89jjyaw4ggwaxnhcfxnx1` (`id_image`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `comic` (`id`, `description`, `diamond_code`, `digital_id`, `ean`, `format`, `isbn`, `issn`, `issue_number`, `modified`, `page_count`, `resourceuri`, `title`, `upc`, `variant_description`, `id_character_list`, `id_creator_list`, `id_series_summary`, `id_story_list`, `id_image`) VALUES
(1, 'A COMIC A', '<mocked_diamond_code_A>', 1, '<mocked_ean_A>', 'hardcover', '<mocked_isbn_A>', '<mocked_issn_A>', 1, '2020-03-20 00:00:00', 100, '<mocked_comic_uri_A>', 'A TITLE A', '<mocked_upc_A>', NULL, 1, 1, 1, 1, 1),
(2, 'B COMIC B', '<mocked_diamond_code_B>', 2, '<mocked_ean_B>', 'hardcover', '<mocked_isbn_B>', '<mocked_issn_B>', 2, '2020-03-15 00:00:00', 150, '<mocked_comic_uri_B>', 'B TITLE B', '<mocked_upc_B>', NULL, 2, 2, 2, 2, 2),
(3, 'C COMIC C', '<mocked_diamond_code_C>', 3, '<mocked_ean_C>', 'hardcover', '<mocked_isbn_C>', '<mocked_issn_C>', 3, '2020-03-10 00:00:00', 200, '<mocked_comic_uri_C>', 'C TITLE C', '<mocked_upc_C>', NULL, 3, 3, 3, 3, 3);

DROP TABLE IF EXISTS `comic_date`;
CREATE TABLE IF NOT EXISTS `comic_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `comic_date` (`id`, `date`, `type`) VALUES
(1, '2020-03-20 00:00:00', '<mocked_comic_date_type_A>'),
(2, '2020-03-15 00:00:00', '<mocked_comic_date_type_B>'),
(3, '2020-03-10 00:00:00', '<mocked_comic_date_type_C>');

DROP TABLE IF EXISTS `comic_list`;
CREATE TABLE IF NOT EXISTS `comic_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(11) DEFAULT NULL,
  `collectionuri` varchar(255) DEFAULT NULL,
  `returned` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `comic_list` (`id`, `available`, `collectionuri`, `returned`) VALUES
(1, 3, '<mocked_comic_list_uri_A>', NULL),
(2, 3, '<mocked_comic_list_uri_A>', NULL),
(3, 3, '<mocked_comic_list_uri_A>', NULL);

DROP TABLE IF EXISTS `comic_price`;
CREATE TABLE IF NOT EXISTS `comic_price` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `comic_price` (`id`, `price`, `type`) VALUES
(1, 10, '<mocked_comic_price_type_A>'),
(2, 15, '<mocked_comic_price_type_B>'),
(3, 20, '<mocked_comic_price_type_C>');

DROP TABLE IF EXISTS `comic_summary`;
CREATE TABLE IF NOT EXISTS `comic_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `comic_summary` (`id`, `name`, `resourceuri`) VALUES
(1, 'A COMIC A', '<mocked_comic_summary_uri_A>'),
(2, 'B COMIC B', '<mocked_comic_summary_uri_B>'),
(3, 'B COMIC B', '<mocked_comic_summary_uri_C>');

DROP TABLE IF EXISTS `creator_list`;
CREATE TABLE IF NOT EXISTS `creator_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(11) DEFAULT NULL,
  `collectionuri` varchar(255) DEFAULT NULL,
  `returned` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `creator_list` (`id`, `available`, `collectionuri`, `returned`) VALUES
(1, 3, '<mocked_creator_list_uri_A>', NULL),
(2, 3, '<mocked_creator_list_uri_B>', NULL),
(3, 3, '<mocked_creator_list_uri_B>', NULL);

DROP TABLE IF EXISTS `creator_summary`;
CREATE TABLE IF NOT EXISTS `creator_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `creator_summary` (`id`, `name`, `resourceuri`, `role`) VALUES
(1, 'A CREATOR A', '<mocked_creator_uri_A>', '<mocked_role_A>'),
(2, 'B CREATOR B', '<mocked_creator_uri_B>', '<mocked_role_B>'),
(3, 'C CREATOR C', '<mocked_creator_uri_C>', '<mocked_role_C>');

DROP TABLE IF EXISTS `event`;
CREATE TABLE IF NOT EXISTS `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `id_character_list` int(11) DEFAULT NULL,
  `id_comic_list` int(11) DEFAULT NULL,
  `id_creator_list` int(11) DEFAULT NULL,
  `id_event_summary` int(11) DEFAULT NULL,
  `id_series_list` int(11) DEFAULT NULL,
  `id_story_list` int(11) DEFAULT NULL,
  `id_image` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKetgv1ce1o9jjjopdf79le4tts` (`id_character_list`),
  KEY `FK493f4c6qvr40r6y7x630ejyd4` (`id_comic_list`),
  KEY `FKl01gxxhelqiby7qeh986dgpuk` (`id_creator_list`),
  KEY `FK9mr58g7q3b7q0ftgir1q9r0qe` (`id_event_summary`),
  KEY `FKnw2h1et5o6n9wo5vwj4usfqy7` (`id_series_list`),
  KEY `FK2l70idwvu4ps2h3ew1ftjl4rm` (`id_story_list`),
  KEY `FKp3pnfdc9l6xb9ote5lxkb2k8m` (`id_image`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `event` (`id`, `description`, `end`, `modified`, `resourceuri`, `start`, `title`, `id_character_list`, `id_comic_list`, `id_creator_list`, `id_event_summary`, `id_series_list`, `id_story_list`, `id_image`) VALUES
(1, 'A EVENT A', '2020-03-31 00:00:00', '2020-03-20 00:00:00', '<mocked_event_uri_A>', '2020-03-25 00:00:00', 'A TITLE A', 1, 1, 1, 1, 1, 1, 1),
(2, 'B EVENT B', '2020-03-21 00:00:00', '2020-03-10 00:00:00', '<mocked_event_uri_B>', '2020-03-10 00:00:00', 'B TITLE B', 2, 2, 2, 2, 2, 2, 2),
(3, 'C EVENT C', '2020-03-31 00:00:00', '2020-03-20 00:00:00', '<mocked_event_uri_C>', '2020-03-25 00:00:00', 'C TITLE C', 3, 3, 3, 3, 3, 3, 3);

DROP TABLE IF EXISTS `event_list`;
CREATE TABLE IF NOT EXISTS `event_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(11) DEFAULT NULL,
  `collectionuri` varchar(255) DEFAULT NULL,
  `returned` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `event_list` (`id`, `available`, `collectionuri`, `returned`) VALUES
(1, 3, '<mocked_event_list_uri_A>', NULL),
(2, 3, '<mocked_event_list_uri_B>', NULL),
(3, 3, '<mocked_event_list_uri_C>', NULL);

DROP TABLE IF EXISTS `event_summary`;
CREATE TABLE IF NOT EXISTS `event_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `event_summary` (`id`, `name`, `resourceuri`) VALUES
(1, 'A EVENT A', '<mocked_event_summary_uri_A>'),
(2, 'B EVENT B', '<mocked_event_summary_uri_B>'),
(3, 'C EVENT C', '<mocked_event_summary_uri_C>');

DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `extension` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `image` (`id`, `extension`, `path`) VALUES
(1, 'jpg', '<mocked_image_path_A>'),
(2, 'png', '<mocked_image_path_B>'),
(3, 'bmp', '<mocked_image_path_C>');

DROP TABLE IF EXISTS `series`;
CREATE TABLE IF NOT EXISTS `series` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `end_year` int(11) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `rating` varchar(255) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  `start_year` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `id_character_list` int(11) DEFAULT NULL,
  `id_comic_list` int(11) DEFAULT NULL,
  `id_creator_list` int(11) DEFAULT NULL,
  `id_event_list` int(11) DEFAULT NULL,
  `id_series_summary` int(11) DEFAULT NULL,
  `id_story_list` int(11) DEFAULT NULL,
  `id_image` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm3hfaesahl28vdev77xksse9q` (`id_character_list`),
  KEY `FKnd1vj7jofbstf2duogj17aha8` (`id_comic_list`),
  KEY `FK54sgda1dwoojjpeykilbp7cro` (`id_creator_list`),
  KEY `FKd8iwc29js5ctr3iy9e0bugurm` (`id_event_list`),
  KEY `FKqys0lnkgh5dn3r8h17hi3omlg` (`id_series_summary`),
  KEY `FKn28eihe2j2rhc8d7jd3e1h3vc` (`id_story_list`),
  KEY `FK378jvt8hnk6lnddr8iqx00rc4` (`id_image`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `series` (`id`, `description`, `end_year`, `modified`, `rating`, `resourceuri`, `start_year`, `title`, `id_character_list`, `id_comic_list`, `id_creator_list`, `id_event_list`, `id_series_summary`, `id_story_list`, `id_image`) VALUES
(1, 'A SERIE A', 2020, '2020-03-20 00:00:00', '<mocked_series_rating_A>', '<mocked_series_uri_A>', 2010, 'A TITLE A', 1, 1, 1, 1, 1, 1, 1),
(2, 'B SERIE B', 2020, '2020-03-20 00:00:00', '<mocked_series_rating_B>', '<mocked_series_uri_B>', 2010, 'B TITLE B', 2, 2, 2, 2, 2, 2, 2),
(3, 'C SERIE C', 2020, '2020-03-20 00:00:00', '<mocked_series_rating_C>', '<mocked_series_uri_C>', 2010, 'C TITLE C', 3, 3, 3, 3, 3, 3, 3);

DROP TABLE IF EXISTS `series_list`;
CREATE TABLE IF NOT EXISTS `series_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(11) DEFAULT NULL,
  `collectionuri` varchar(255) DEFAULT NULL,
  `returned` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `series_list` (`id`, `available`, `collectionuri`, `returned`) VALUES
(1, 3, '<mocked_series_list_uri_A>', NULL),
(2, 3, '<mocked_series_list_uri_B>', NULL),
(3, 3, '<mocked_series_list_uri_C>', NULL);

DROP TABLE IF EXISTS `series_summary`;
CREATE TABLE IF NOT EXISTS `series_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `series_summary` (`id`, `name`, `resourceuri`) VALUES
(1, 'A SERIES A', '<mocked_series_summary_uri_A>'),
(2, 'A SERIES A', '<mocked_series_summary_uri_B>'),
(3, 'A SERIES A', '<mocked_series_summary_uri_C>');

DROP TABLE IF EXISTS `story`;
CREATE TABLE IF NOT EXISTS `story` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id_character_list` int(11) DEFAULT NULL,
  `id_comic_list` int(11) DEFAULT NULL,
  `id_creator_list` int(11) DEFAULT NULL,
  `id_event_list` int(11) DEFAULT NULL,
  `id_comic_summary` int(11) DEFAULT NULL,
  `id_series_list` int(11) DEFAULT NULL,
  `id_image` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa5rab1dw5hwh759abgy6q389d` (`id_character_list`),
  KEY `FKhm3bgsuivshw0p9p3ws8bp5o7` (`id_comic_list`),
  KEY `FKik3pje7lxv0534jpnlvvhkcw7` (`id_creator_list`),
  KEY `FKluq8mayu2mn9fmv3wb2ygsr9h` (`id_event_list`),
  KEY `FKektnn3mgp0d6hyvfgpahl2dmp` (`id_comic_summary`),
  KEY `FKghfmax8xkycq5la0hirdg8i0n` (`id_series_list`),
  KEY `FKlvop6ca7kd2hsf8ub1c8l66mg` (`id_image`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `story` (`id`, `description`, `modified`, `resourceuri`, `title`, `type`, `id_character_list`, `id_comic_list`, `id_creator_list`, `id_event_list`, `id_comic_summary`, `id_series_list`, `id_image`) VALUES
(1, 'A STORY A', '2020-03-18 00:00:00', '<mocked_story_uri_A>', 'A TITLE A', 'story', 1, 1, 1, 1, 1, 1, 1),
(2, 'B STORY B', '2020-03-18 00:00:00', '<mocked_story_uri_B>', 'B TITLE B', 'story', 2, 2, 2, 2, 2, 2, 2),
(3, 'C STORY C', '2020-03-18 00:00:00', '<mocked_story_uri_C>', 'C TITLE C', 'story', 3, 3, 3, 3, 3, 3, 3);

DROP TABLE IF EXISTS `story_list`;
CREATE TABLE IF NOT EXISTS `story_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(11) DEFAULT NULL,
  `collectionuri` varchar(255) DEFAULT NULL,
  `returned` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `story_list` (`id`, `available`, `collectionuri`, `returned`) VALUES
(1, 3, '<mocked_story_list_uri_A>', NULL),
(2, 3, '<mocked_story_list_uri_B>', NULL),
(3, 3, '<mocked_story_list_uri_C>', NULL);

DROP TABLE IF EXISTS `story_summary`;
CREATE TABLE IF NOT EXISTS `story_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `resourceuri` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `story_summary` (`id`, `name`, `resourceuri`, `type`) VALUES
(1, 'A STORY A', '<mocked_story_summary_uri_A>', 'cover'),
(2, 'B STORY B', '<mocked_story_summary_uri_B>', 'interior'),
(3, 'C STORY C', '<mocked_story_summary_uri_C>', 'cover');

DROP TABLE IF EXISTS `text_object`;
CREATE TABLE IF NOT EXISTS `text_object` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `language` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `text_object` (`id`, `language`, `text`, `type`) VALUES
(1, 'az-Latn', 'A TEXT A', 'preview text'),
(2, 'az-Cyrl', 'B TEXT B', 'preview text'),
(3, 'az-Latn-AZ', 'C TEXT C', 'preview text');

DROP TABLE IF EXISTS `url`;
CREATE TABLE IF NOT EXISTS `url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `url` (`id`, `type`, `url`) VALUES
(1, '<mocked_url_type_A>', '<mocked_url_A>'),
(2, '<mocked_url_type_B>', '<mocked_url_B>'),
(3, '<mocked_url_type_C>', '<mocked_url_C>');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
