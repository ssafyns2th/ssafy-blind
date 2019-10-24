DROP TABLE IF EXISTS `account`;
DROP TABLE IF EXISTS `freeboard`;
DROP TABLE IF EXISTS `nicktable`;
DROP TABLE IF EXISTS `freeboard_comment`;


CREATE TABLE `nicktable` (
  `nick_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(45) NOT NULL,
  PRIMARY KEY (`nick_id`)
);

CREATE TABLE `account` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_username` varchar(45) NOT NULL,
  `account_email` varchar(45) NOT NULL,
  `account_pw` varchar(100) NOT NULL,
  `edu_city` varchar(45) NOT NULL,
  `th` int(11) NOT NULL,
  `isleave` tinyint(4) NOT NULL,
  `account_nick_id` bigint(20) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_username`),
  UNIQUE KEY `account_username_UNIQUE` (`account_id`),
  CONSTRAINT `fk_account_nicktable` FOREIGN KEY (`account_nick_id`) REFERENCES `nicktable` (`nick_id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

CREATE TABLE `freeboard` (
  `freeboard_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `freeboard_title` varchar(45) NOT NULL,
  `freeboard_content` text NOT NULL,
  `freeboard_date` datetime NOT NULL,
  `freeboard_hits` int(11) NOT NULL,
  `freeboard_likes` int(11) NOT NULL,
  `freeboard_account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`freeboard_no`),
  CONSTRAINT `fk_freeboard_account1` FOREIGN KEY (`freeboard_account_id`) REFERENCES `account` (`account_id`)
);


CREATE TABLE `freeboard_comment` (
  `fbcomment_no` bigint(20) NOT NULL AUTO_INCREMENT,
  `fbcomment_content` text NOT NULL,
  `fbcomment_date` datetime NOT NULL,
  `fbcomment_likes` int(11) NOT NULL,
  `fbcomment_freeboard_no` bigint(20) NOT NULL,
  `fbcomment_account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`fbcomment_no`),
  CONSTRAINT `fk_freeboard_comment_account1` FOREIGN KEY (`fbcomment_account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `fk_freeboard_comment_freeboard1` FOREIGN KEY (`fbcomment_freeboard_no`) REFERENCES `freeboard` (`freeboard_no`)
);
