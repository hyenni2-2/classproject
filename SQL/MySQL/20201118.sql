SELECT * FROM project.member;SELECT `member`.`idx`,
    `member`.`userid`,
    `member`.`password`,
    `member`.`username`,
    `member`.`regdate`
FROM `project`.`member`;

SELECT * FROM project.member;
SELECT `member`.`idx`,
    `member`.`userid`,
    `member`.`password`,
    `member`.`username`,
    `member`.`regdate`
FROM `project`.`member`;


INSERT INTO `project`.`member`
(`userid`,`password`,`username`)
VALUES
('king',1111,'king');


UPDATE `project`.`member`
SET
`userid` = 'hyosoen'
WHERE `idx` = 1;

DELETE FROM `project`.`member` WHERE `idx`=1;

rollback;
commit;

CREATE TABLE `member` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(12) NOT NULL,
  `password` varchar(16) NOT NULL,
  `username` varchar(45) NOT NULL,
  `regdate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='서비스의 이용자 : 회원의 정보를 저장합니다.';






