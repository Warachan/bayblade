/*
 [df:title]
  ページング検索

 [df:description]
  SQL Description here.

*/

-- #df:entity#

-- !df:pmb extends Paging!
-- !!String sample!!

/*IF pmb.isPaging()*/
select ...
-- ELSE select count(*)
/*END*/
  from ...
 where ...
/*IF pmb.isPaging()*/
 order by ...
/*END*/
