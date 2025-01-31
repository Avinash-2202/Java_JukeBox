create database blissmusic;
use blissmusic;
create table songs(songsid int not null AUTO_INCREMENT primary key,songtitle varchar(50),artistname varchar(90),genre varchar(77),duration varchar(100),filepath varchar(100));
create table playlist(playlistid int,playlistname varchar(200),songsid int);
insert into songs(songtitle,artistname,genre,duration,filepath) values ('Arabic Kuthu','Aniruth','Rock','4.41','src/main/Resource/Arabic Kuthu.wav');
insert into songs(songtitle,artistname,genre,duration,filepath) values ('Kadhal Valarthen', 'Yuvan', 'Sad', '7.34', 'src/main/Resource/Kadhal Valarthen.wav');
insert into songs(songtitle,artistname,genre,duration,filepath) values (' Oru Malai', 'Harris', 'Melody', '5.37', 'src/main/Resource/Oru Malai.wav');
insert into songs(songtitle,artistname,genre,duration,filepath) values ('Oru Nalail', 'Yuvan', 'Motivation', '6.32', 'src/main/Resource/Oru Naalil.wav');
insert into songs(songtitle,artistname,genre,duration,filepath) values ('Siragugal', 'Yuvan', 'Melody', '4.07', 'src/main/Resource/Siragugal.wav');
insert into songs(songtitle,artistname,genre,duration,filepath) values ('Unnakul', 'Harris', 'Love', '2.08', 'src/main/Resource/Unnakul.wav' );