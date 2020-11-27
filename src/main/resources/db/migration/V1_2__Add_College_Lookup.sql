
CREATE TABLE colleges
(
    id serial CONSTRAINT colleges_id_pk PRIMARY KEY,
    site_name VARCHAR,
    display_name VARCHAR,
    conference VARCHAR,
    division VARCHAR
);

INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('boston-college', 'Boston College', 'ACC', 'Atlantic');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('clemson', 'Clemson University', 'ACC', 'Atlantic');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('florida-state', 'Florida State University', 'ACC', 'Atlantic');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('louisville', 'University of Louisville', 'ACC', 'Atlantic');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('nc-state', 'North Carolina State University', 'ACC', 'Atlantic');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('notre-dame', 'University of Notre Dame', 'ACC', 'Atlantic');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('syracuse', 'Syracuse University', 'ACC', 'Atlantic');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('wake-forest', 'Wake Forest University', 'ACC', 'Atlantic');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('duke', 'Duke University', 'ACC', 'Coastal');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('georgia-tech', 'Georgia Institute of Technology', 'ACC', 'Coastal');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('miami', 'University of Miami', 'ACC', 'Coastal');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('north-carolina', 'University of North Carolina', 'ACC', 'Coastal');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('pittsburgh', 'University of Pittsburgh', 'ACC', 'Coastal');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('virginia', 'University of Virginia', 'ACC', 'Coastal');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('virginia-tech', 'Virginia Polytechnic Institute', 'ACC', 'Coastal');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('florida', 'University of Florida', 'SEC', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('georgia', 'University of Georgia', 'SEC', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('kentucky', 'University of Kentucky', 'SEC', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('missouri', 'University of Missouri', 'SEC', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('south-carolina', 'University of South Carolina', 'SEC', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('tennessee', 'University of Tennessee', 'SEC', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('vanderbilt', 'Vanderbilt University', 'SEC', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('alabama', 'University of Alabama', 'SEC', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('arkansas', 'University of Arkansas', 'SEC', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('auburn', 'Auburn University', 'SEC', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('lsu', 'Louisiana State University', 'SEC', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('mississippi', 'University of Mississippi', 'SEC', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('mississippi-state', 'Mississippi State University', 'SEC', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('texas-am', 'Texas A&M University', 'SEC', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('indiana', 'Indiana University', 'Big 10', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('maryland', 'University of Maryland', 'Big 10', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('michigan', 'University of Michigan', 'Big 10', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('michigan-state', 'Michigan State University', 'Big 10', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('ohio-state', 'Ohio State University', 'Big 10', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('pennsylvania', 'Pennsylvania State University', 'Big 10', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('rutgers', 'Rutgers University', 'Big 10', 'East');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('illinois', 'University of Illinois', 'Big 10', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('iowa', 'University of Iowa', 'Big 10', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('minnesota', 'University of Minnesota', 'Big 10', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('nebraska', 'University of Nebraska', 'Big 10', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('northwestern', 'Northwestern University', 'Big 10', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('purdue', 'Purdue University', 'Big 10', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('wisconsin', 'University of Wisconsin', 'Big 10', 'West');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('arizona', 'University of Arizona', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('arizona-state', 'Arizona State University', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('california', 'University of California, Berkeley', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('ucla', 'University of California, Los Angeles', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('colorado', 'University of Colorado', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('oregon', 'University of Oregon', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('oregon-state', 'Oregon State University', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('usc', 'University of Southern California', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('stanford', 'Stanford University', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('utah', 'University of Utah', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('washington', 'University of Washington', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('washington-state', 'Washington State University', 'Pac 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('baylor', 'Baylor University', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('iowa-state', 'Iowa State University', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('kansas', 'University of Kansas', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('kansas-state', 'Kansas State University', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('oklahoma', 'University of Oklahoma', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('oklahoma-state', 'Oklahoma State University', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('tcu', 'Texas Christian University', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('texas', 'University of Texas', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('texas-tech', 'Texas Tech University', 'Big 12', 'NA');
INSERT INTO colleges (site_name, display_name, conference, division) VALUES ('west-virginia', 'West Virginia University', 'Big 12', 'NA');
















