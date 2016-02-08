--======================================================================
--                         Table User
------------------------------------------------------------------------
-- Previous update: 20160208
-- Last update :    20160208
--======================================================================

------------------------------------------------------------------------
--                     INSERT User
------------------------------------------------------------------------

INSERT INTO at_user(
            user_id,                re_active,          re_delete,                  created_date,           modified_date,
            be_code,                be_description,     birth_date,                 birth_place,            email,
            first_name,             last_name,          middle_name,                nick_name,              phone1,
            phone2,                 default_pwd,        df_expired,                 dt_last_log_in,         dt_last_log_out,
            dt_last_pwd_modified,   usr_locked,         max_attempt_log_in_allow,   max_time_pwd_change,    nb_failed_log_in_attempt, 
            need_pwd_change,        user_name,          created_by,                 modified_by,            usr_pwd)

    VALUES
------------------------------------------------------------------------
--                     Create Super admin user
------------------------------------------------------------------------

            (-1,                    true,               false,                      now(),                  now(),
            'superAdmin',           'Super user',       now(),                      'nowhere',              'nobody@noplace.com',
            'Super',                'Admin',            '',                         '',                     null,
            null,                   false,              null,                       now(),                  now(),
            now(),                  false,              5,                          null,                   0, 
            false,                  'super',            -1,                         -1,                     '$2a$08$rvlpDbDp56Hp2mRwmIoFN.hev4AQrdoTrzzTDXto0tXomNUu9ONm.'),


------------------------------------------------------------------------
--                     Create admin user
------------------------------------------------------------------------

            (1,                     true,               false,                      now(),                  now(),
            'Admin',                'admin user',       now(),                      'nowhere',              'nobody@noplace.com',
            'Admin',                'User',             '',                         '',                     null,
            null,                   false,              null,                       now(),                  now(),
            now(),                  false,              5,                          null,                   0, 
            false,                  'admin',            -1,                         -1,                     '$2a$08$w3hoFTXs7ABzJ5.d0F8k..eGoG30K9kUA6matv1gxxZbPL5qvyzYm'),


------------------------------------------------------------------------
--                     Create user
------------------------------------------------------------------------

            (2,                     true,               false,                      now(),                  now(),
            'user',                 'user',             now(),                      'nowhere',              'nouser@noplace.com',
            'User',                 'User',             '',                         '',                     null,
            null,                   false,              null,                       now(),                  now(),
            now(),                  false,              5,                          null,                   0, 
            false,                  'user',             1,                          1,                      '$2a$08$w3hoFTXs7ABzJ5.d0F8k..eGoG30K9kUA6matv1gxxZbPL5qvyzYm');


------------------------------------------------------------------------
--                     Update Sequence
------------------------------------------------------------------------

ALTER SEQUENCE at_user_user_id_seq RESTART WITH 3;
