select
    um1_0.id,um1_0.email,um1_0.name,um1_0.password,
    up1_0.id,up1_0.address,up1_0.phone_number,up1_0.user_id
from users um1_0
    left join user_profiles up1_0 on um1_0.id=up1_0.user_id
where um1_0.id=?



select
    um1_0.id,um1_0.email,um1_0.name,um1_0.password
from users um1_0
where um1_0.id=?

select
    upm1_0.id,upm1_0.address,upm1_0.phone_number,upm1_0.user_id
from user_profiles upm1_0
where upm1_0.user_id=?

