select * from actor;

select distinct * from city;

select * from city;

select distinct * from city where country_id = '87';

insert into actor (first_name, last_name)
values ('Alice', 'Dumas');

select * from actor where first_name = 'Alice';

create user natalie with password '4321';

grant all privileges on all tables in schema public to natalie;

revoke all privileges on all tables in schema public from natalie;

grant insert on table city to natalie;

select first_name, last_name, email from customer 
order by first_name asc, last_name desc, email asc;

select first_name, last_name, email from customer where first_name = 'Ben' 
order by first_name asc, last_name desc, email asc;

create view ohseven_language as
	select release_year, language_id
	from film 
	where release_year = '2007';
	
drop view ohseven_language;

create view ohsix_language as
	select release_year, language_id
	from film
	where release_year ='2006';
	
create view ben_films as
	select first_name, title
	from actor, film
	where first_name ='Ben';
	

	
