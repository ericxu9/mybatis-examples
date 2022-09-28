-- blog table
CREATE TABLE t_blog (
	blog_id INT(11) NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	author VARCHAR(50) NOT NULL,
	views INT(11) NOT NULL,
	PRIMARY KEY (blog_id)
)ENGINE=Innodb CHARSET=utf8mb4;