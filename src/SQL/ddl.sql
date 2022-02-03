CREATE TABLE `team` (
                        `team_id` mediumint(9) NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        PRIMARY KEY (`team_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

create table if not exists player(
        player_id mediumint primary key auto_increment,
        name varchar(255) not null,
        team_id mediumint not null,
        foreign key (team_id) references team(team_id)
);