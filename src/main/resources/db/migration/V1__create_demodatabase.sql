use demo;
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'sequence',
  `name` VARCHAR(255) NOT NULL COMMENT 'name',
  `version` BIGINT NOT NULL COMMENT 'version',
  `created_by` VARCHAR(100) NOT NULL COMMENT 'user',
  `created_at` DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) NOT NULL COMMENT 'created time',
  `modified_by` VARCHAR(100) NOT NULL COMMENT 'user',
  `modified_at` DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  PRIMARY KEY (`id`),
  KEY `demo_idx01` (`name`)
) ENGINE = INNODB CHARSET = utf8 COMMENT = 'demo';

INSERT INTO `demo` (`id`,`name`,`version`, `created_by`, `created_at`, `modified_by`, `modified_at`) VALUES (1,'demo test','115','akaroice','2018-01-16 13:40:30.000000','akaroice','2018-01-16 13:40:30.000000');
