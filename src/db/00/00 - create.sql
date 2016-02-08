--======================================================================
--                         Create Database
--======================================================================

------------------------------------------------------------------------
--                     Database: "travel-agent"
------------------------------------------------------------------------

-- DROP DATABASE "travel-agent";

CREATE DATABASE "travel-agent"
  WITH OWNER = seashell
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.UTF-8'
       LC_CTYPE = 'en_US.UTF-8'
       CONNECTION LIMIT = -1;

------------------------------------------------------------------------
--                      Table: at_user
------------------------------------------------------------------------

-- DROP TABLE at_user;

CREATE TABLE at_user
(
  user_id bigserial NOT NULL,
  re_active boolean NOT NULL,
  re_delete boolean NOT NULL,
  created_date timestamp without time zone NOT NULL,
  modified_date timestamp without time zone NOT NULL,
  be_code character varying(255),
  be_description character varying(255),
  birth_date timestamp without time zone,
  birth_place character varying(150),
  email character varying(100),
  first_name character varying(100),
  last_name character varying(100),
  middle_name character varying(50),
  nick_name character varying(100),
  phone1 character varying(20),
  phone2 character varying(20),
  default_pwd boolean,
  df_expired timestamp without time zone,
  dt_last_log_in timestamp without time zone,
  dt_last_log_out timestamp without time zone,
  dt_last_pwd_modified timestamp without time zone,
  usr_locked boolean,
  max_attempt_log_in_allow integer,
  max_time_pwd_change bigint,
  nb_failed_log_in_attempt integer,
  need_pwd_change boolean,
  usr_pwd character varying(100) NOT NULL,
  user_name character varying(100) NOT NULL,
  created_by bigint NOT NULL,
  modified_by bigint NOT NULL,
  CONSTRAINT at_user_pkey PRIMARY KEY (user_id),
  CONSTRAINT fk_cayv64365os7ip1364c5sm5uj FOREIGN KEY (modified_by)
      REFERENCES at_user (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_jwqjyx8xkka2sodsg71kt5a81 FOREIGN KEY (created_by)
      REFERENCES at_user (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_17uruq868utsy20ktdlckr9uo UNIQUE (user_name),
  CONSTRAINT uk_p6505xcgx38c0a2pa1p4qxpfc UNIQUE (be_code)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE at_user
  OWNER TO seashell;
