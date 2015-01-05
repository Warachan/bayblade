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
-- #df:entity#

-- !df:pmb!
-- !!AutoDetect!!
-- !!String paymentCompleteFlg:cls(Flg)!!

select mb.MEMBER_ID
     , mb.MEMBER_NAME
     , MONTH(pur.PURCHASE_DATETIME) as PURCHASE_MONTH
     , (avg(pur.PURCHASE_PRICE)) as PURCHASE_PRICE_AVERAGE_MONTH
     , (sum(pur.PURCHASE_COUNT)) as PURCHASE_COUNT_SUM_MONTH
  from PURCHASE pur
    left outer join MEMBER mb
      on mb.MEMBER_ID = pur.MEMBER_ID
    left outer join PURCHASE_PAYMENT pay
      on pay.PURCHASE_ID = pur.PURCHASE_ID
    left outer join MEMBER_SERVICE serv
      on serv.MEMBER_ID = pur.MEMBER_ID
  /*BEGIN*/
  where
    /*IF pmb.paymentCompleteFlg != null*/
     pur.PAYMENT_COMPLETE_FLG = 1
    /*END*/
    /*IF pmb.memberId != null*/
    and mb.MEMBER_ID = /*pmb.memberId*/7
    /*END*/
    /*IF pmb.memberName != null*/
    and mb.MEMBER_NAME like /*pmb.memberName*/'%s%'
    /*END*/
    /*IF pmb.purchasePaymentId != null*/
    and pay.PURCHASE_PAYMENT_ID = /*pmb.purchasPaymentId*/7
    /*END*/
	/*IF pmb.servicePointCount != null*/
	and serv.SERVICE_POINT_COUNT> /*pmb.greaterThanPoint*/100
	/*END*/
  /*END*/
  group by PURCHASE_MONTH
         , mb.MEMBER_ID
         , mb.MEMBER_NAME
    having AVG(pur.PURCHASE_PRICE) > 1000
       and SUM(pur.PURCHASE_COUNT) > 1000
  order by mb.MEMBER_ID asc
         , PURCHASE_MONTH desc