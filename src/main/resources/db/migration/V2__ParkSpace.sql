CREATE TABLE parkspace(
    id UUID NOT NULL PRIMARY KEY,
    status boolean NOT NULL,
    LocationLat DECIMAL(9,6) NOT NULL,
    LocationLng DECIMAL(9,6) NOT NULL
)
