/*
 [df:title]
  PurchaseMonthCursor

 [df:description]
  "さらに外だし" と同じ仕様(ページングは不要)
    カーソル検索として作成すること
    明らかにおかしいカラム名のカラムは取得してはいけない

*/

-- #df:entity#
-- +cursor+

-- !df:pmb!
-- !!Boolean paymentCompleteOnly:cls(Flg)!!
-- !!AutoDetect!!

select mb.MEMBER_ID
     , mb.MEMBER_NAME
     , MONTH(pur.PURCHASE_DATETIME) as PURCHASE_MONTH
     , avg(pur.PURCHASE_PRICE) as PURCHASE_PRICE_AVERAGE_MONTH
     , sum(pur.PURCHASE_COUNT) as PURCHASE_COUNT_SUM_MONTH
  from PURCHASE pur
    left outer join MEMBER mb
      on mb.MEMBER_ID = pur.MEMBER_ID
    left outer join PURCHASE_PAYMENT pay
      on pay.PURCHASE_ID = pur.PURCHASE_ID
    left outer join MEMBER_SERVICE serv
      on serv.MEMBER_ID = pur.MEMBER_ID
  /*BEGIN*/
  where
    /*IF pmb.paymentCompleteOnly*/
     pur.PAYMENT_COMPLETE_FLG = /*pmb.paymentCompleteTrue:cls(Flg.True)*/1
    /*END*/
    /*IF pmb.memberName != null*/
    and mb.MEMBER_NAME like /*pmb.memberName*/'%s%'
    /*END*/
    /*IF pmb.purchasePaymentId != null*/
    and pay.PURCHASE_PAYMENT_ID = /*pmb.purchasPaymentId*/7
    /*END*/
	/*IF pmb.servicePointCount != null*/
	and serv.SERVICE_POINT_COUNT > /*pmb.greaterThanPoint*/100
	/*END*/
  /*END*/
  group by PURCHASE_MONTH
         , mb.MEMBER_ID
         , mb.MEMBER_NAME
  order by mb.MEMBER_ID asc
         , PURCHASE_MONTH desc