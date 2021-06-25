CREATE TABLE IF NOT EXISTS t_wine (
    wi_id SERIAL PRIMARY KEY,
    wi_guid VARCHAR(64) NOT NULL,
    wi_name VARCHAR(64) NOT NULL,
    wi_type VARCHAR(64) NOT NULL,
    wi_vintage VARCHAR(64) NOT NULL,
    wi_producer VARCHAR(64) NOT NULL,
    wi_varietal VARCHAR(64) NOT NULL,
    wi_vineyard VARCHAR(64),
    wi_designation VARCHAR(64),
    wi_country VARCHAR(64) NOT NULL,
    wi_region VARCHAR(64) NOT NULL,
    wi_subregion VARCHAR(64) NOT NULL,
    wi_appellation VARCHAR(64) NOT NULL
);
