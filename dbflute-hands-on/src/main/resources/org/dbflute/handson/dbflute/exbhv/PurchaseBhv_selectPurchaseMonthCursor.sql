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
    and pay.PURCHASE_PAYMENT_ID = /*pmb.purchasePaymentId*/7
    /*END*/
  /*END*/
   group by PURCHASE_MONTH
         , mb.MEMBER_ID
         , mb.MEMBER_NAME
    having AVG(pur.PURCHASE_PRICE) > 1000
       and SUM(pur.PURCHASE_COUNT) > 1000
  order by mb.MEMBER_ID asc
         , PURCHASE_MONTH desc
