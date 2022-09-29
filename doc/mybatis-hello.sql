-- blog table
CREATE TABLE t_blog (
	blog_id INT(11) NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	author VARCHAR(50) NOT NULL,
	views INT(11) NOT NULL,
	PRIMARY KEY (blog_id)
)ENGINE=Innodb CHARSET=utf8mb4;

INSERT INTO t_blog(title, author, views) VALUES('mybatis测试1', 'admin', 100);
INSERT INTO t_blog(title, author, views) VALUES('mybatis测试2', 'admin', 200);