-- 코드를 입력하세요
-- ai.name as NAME, ai.datetime as DATETIME 
Select ai.name as NAME, ai.datetime as DATETIME  
from animal_ins as ai left join animal_outs ao on ao.animal_id = ai.animal_id 
where ao.animal_id IS NULL
order by ai.datetime
limit 3
