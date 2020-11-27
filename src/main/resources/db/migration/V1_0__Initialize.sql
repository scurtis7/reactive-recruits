
CREATE TABLE recruits_two47
(
    id serial CONSTRAINT recruits_two47_id_pk PRIMARY KEY,
    site_id INTEGER,
    name VARCHAR,
    position VARCHAR,
    height VARCHAR,
    weight VARCHAR,
    home_town VARCHAR,
    high_school VARCHAR,
    year INTEGER,
    composite_rank VARCHAR,
    rank_national INTEGER,
    rank_position INTEGER,
    welcome_page_playlist VARCHAR,
    rank_state INTEGER,
    stars INTEGER,
    link VARCHAR
);
