
create database if not exists blog_post;
create user if not exists 'bloguser'@'localhost' identified by 'Blog123';

grant all privileges on blog_post.* to 'bloguser'@'localhost';

flush privileges ;