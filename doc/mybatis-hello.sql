-- blog table
CREATE TABLE t_blog (
	blog_id INT(11) NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL COMMENT '博客标题',
	author_id VARCHAR(50) NOT NULL COMMENT '作者id',
	PRIMARY KEY (blog_id)
)ENGINE=Innodb CHARSET=utf8mb4;

INSERT INTO t_blog(blog_id, title, author_id) VALUES(100, 'mybatis入门系列（一）', 1234);
INSERT INTO t_blog(blog_id, title, author_id) VALUES(200, 'mybatis入门系列（二）', 1534);

-- author table
CREATE TABLE t_author (
    author_id INT(11) NOT NULL AUTO_INCREMENT,
    username varchar(20) NOT NULL COMMENT '名称',
    password varchar(20) NOT NULL COMMENT '密码',
    email VARCHAR(20) NOT NULL DEFAULT '' COMMENT '邮箱',
    PRIMARY KEY (author_id)
)ENGINE=Innodb CHARSET=utf8mb4;
INSERT INTO t_author(author_id, username, password, email) VALUES(1234, 'Tom', '123456', '235436346@163.com');
INSERT INTO t_author(author_id, username, password, email) VALUES(1534, 'Eric', '54354f', '46523473@163.com');

-- post table
CREATE TABLE t_post (
    post_id INT(11) NOT NULL AUTO_INCREMENT,
    blog_id INT(11) NOT NULL COMMENT '博客id',
    content varchar(1000) NOT NULL DEFAULT '' COMMENT '博客内容',
    draft TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否是草稿',
    PRIMARY KEY (post_id)
)ENGINE=Innodb CHARSET=utf8mb4;
INSERT INTO t_post(post_id, blog_id, content, draft) VALUES(45, 100, 'mybatis入门系列（一）的内容  阿嘎嘎', 1);
INSERT INTO t_post(post_id, blog_id, content, draft) VALUES(46, 200, 'mybatis入门系列（二）的内容嘎嘎嘎哈哈', 0);

-- comment table
CREATE TABLE t_comment (
    comment_id INT(11) NOT NULL AUTO_INCREMENT,
    post_id INT(11) NOT NULL COMMENT '文章id',
    content varchar(1000) NOT NULL DEFAULT '' COMMENT '评论内容',
    PRIMARY KEY (comment_id)
)ENGINE=Innodb CHARSET=utf8mb4;
INSERT INTO t_comment(comment_id, post_id, content) VALUES(12, 45, '写的真好。。');
INSERT INTO t_comment(comment_id, post_id, content) VALUES(13, 45, '大佬牛逼！！');
INSERT INTO t_comment(comment_id, post_id, content) VALUES(14, 46, '这个系列真不错~');
INSERT INTO t_comment(comment_id, post_id, content) VALUES(15, 46, '学习了~');

