/*
 [df:title]
  ページング検索

 [df:description]
  (Manual)ページング検索すること
      基本は "初めての外だしSQL" のSQLと同じで...
      会員ステータスの等値条件は要らない
      会員サービスのサービスポイント数の大なり条件を追加
      結合に関して、カウント検索のパフォーマンスを最大限考慮すること
   IFコメントに記述する条件が複雑にならないように (代理判定メソッドを使う)
*/
-- #df:entity#

-- !df:pmb extends Paging!
-- !!AutoDetect!!

/*IF pmb.isPaging()*/
select mb.MEMBER_ID
     , mb.MEMBER_NAME
     , mb.BIRTHDATE
     , mb.MEMBER_STATUS_CODE
     , serv.SERVICE_POINT_COUNT -- // サービスポイントかうんと
-- ELSE select count(*)
/*END*/
  from MEMBER mb
    left outer join MEMBER_SERVICE serv
      on mb.MEMBER_ID = serv.MEMBER_ID
 /*BEGIN*/
 where
   /*IF pmb.memberId != null*/
   mb.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*IF pmb.memberName != null*/
   and mb.MEMBER_NAME like /*pmb.memberName*/'%M%'
   /*END*/
   /*IF pmb.servicePointCount != null*/
   and serv.SERVICE_POINT_COUNT >= /*pmb.servicePointCount*/80
   /*END*/
 /*END*/
 /*IF pmb.isPaging()*/
 limit /*$pmb.pageStartIndex*/80, /*$pmb.fetchSize*/20
 /*END*/
