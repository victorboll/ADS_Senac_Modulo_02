--Quantos filmes existem
SELECT COUNT(DISTINCT movie_title) FROM [IMDB].[dbo].[facts_movie]


--Quantos filmes existem com o ator "Tom Cruise"
SELECT COUNT(DISTINCT a.id_title) as filmes
FROM dim_atuam a Inner Join dim_names n ON a.id_names=n.id_names
Where n.actor = 'Tom Cruise'

--Quais sçao os filmes com o ator "Tom Cruise" com o ano?
SELECT m.movie_title as titulo, m.title_year as Ano
FROM dim_atuam a Inner JOIN dim_names n ON a.id_names=n.id_names INNER JOIN facts_movie m ON m.id_title=a.id_title
Where n.actor = 'Tom Cruise'
order By Ano

--Qual o filme mais popular
SELECT m.title_year as ANO, MAX(s.num_voted_users) AS Popularidade
FROM facts_movie m INNER JOIN facts_score s ON m.id_title=s.id_title
WHERE m.title_year is not NULL
group by m.title_year
Order by Ano

SELECT s.id_title, m.movie_title as Nome, s.num_voted_users as votos
FROM facts_movie m INNER JOIN facts_score s ON m.id_title=s.id_title

--Qual o filme mais popular por ano
SELECT m.movie_title, s.imdb_score, m.title_year
FROM facts_movie m JOIN facts_score s ON m.id_title=s.id_title
WHERE s.imdb_score = (select max(s.imdb_score) FROM facts_movie m1 JOIN facts_score s on m1.id_title = s.id_title where m1.title_year = m.title_year)
ORDER BY m.title_year