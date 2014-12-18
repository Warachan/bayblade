/*
 [df:title]
  PurchaseMonthSummary

 [df:description]
  "会員と購入月" ごとの購入の平均購入価格、合計購入数量を検索する
     会員ID、会員名称、購入月、平均購入価格、合計購入数量という形で検索
     支払済みの購入だけでも検索できるようにする
     会員名称の曖昧検索(部分一致)ができるようにする
     会員のサービスポイント数の大なり条件が指定できるようにする
     会員IDの昇順、購入月の降順で並べる
*/

-- !df:pmb extends Paging!
-- !!String sample!!

/*IF pmb.isPaging()*/
select 'dummy'
-- ELSE select count(*)
/*END*/
