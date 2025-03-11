select pm1_0.id,pm1_0.author_id,pm1_0.title
from posts pm1_0 where pm1_0.id=?

select t1_0.post_id,t1_1.id,t1_1.name
from post_tags t1_0
    join tags t1_1 on t1_1.id=t1_0.tag_id
where t1_0.post_id=?



-- select pm1_0.id,pm1_0.author_id,pm1_0.title,t1_0.post_id,t1_1.id,t1_1.name
-- from posts pm1_0
--     left join post_tags t1_0 on pm1_0.id=t1_0.post_id
--     left join tags t1_1 on t1_1.id=t1_0.tag_id where pm1_0.id=?
--
--
-- select um1_0.id,um1_0.email,um1_0.name,um1_0.password,up1_0.id,up1_0.address,up1_0.phone_number,up1_0.user_id,p1_0.author_id,p1_0.id,p1_0.title
-- from users um1_0
--     left join user_profiles up1_0 on um1_0.id=up1_0.user_id
--     left join posts p1_0 on um1_0.id=p1_0.author_id where um1_0.id=?




-- select
--     um1_0.id,um1_0.email,um1_0.name,um1_0.password,
--     p1_0.author_id,p1_0.id,p1_0.title
-- from users um1_0
--     left join posts p1_0 on um1_0.id=p1_0.author_id
-- where um1_0.id=?

-- select um1_0.id,um1_0.email,um1_0.name,um1_0.password
-- from users um1_0 where um1_0.id=?
--
-- select upm1_0.id,upm1_0.address,upm1_0.phone_number,upm1_0.user_id
-- from user_profiles upm1_0 where upm1_0.user_id=?
--
-- select p1_0.author_id,p1_0.id,p1_0.title
-- from posts p1_0 where p1_0.author_id=?
--
--
--
-- select
--     um1_0.id,um1_0.email,um1_0.name,um1_0.password,
--     up1_0.id,up1_0.address,up1_0.phone_number,up1_0.user_id
-- from users um1_0
--     left join user_profiles up1_0 on um1_0.id=up1_0.user_id
-- where um1_0.id=?
--
--
--
-- select
--     um1_0.id,um1_0.email,um1_0.name,um1_0.password
-- from users um1_0
-- where um1_0.id=?
--
-- select
--     upm1_0.id,upm1_0.address,upm1_0.phone_number,upm1_0.user_id
-- from user_profiles upm1_0
-- where upm1_0.user_id=?
--
