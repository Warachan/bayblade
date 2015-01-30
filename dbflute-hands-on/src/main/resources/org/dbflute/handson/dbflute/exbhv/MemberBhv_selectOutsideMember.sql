/*
 [df:title]
  OutsideSql for MemberBhv

 [df:description]
    会員ID、会員名称、生年月日、会員ステータス名称、サービスポイント数を取得
    会員IDの等値、会員名称の前方一致、会員ステータスの等値を and で連結
    それぞれ条件値がない場合は条件自体が無効になるように
    全ての条件値がない場合は全件検索になるように
*/

-- #df:entity#

-- !df:pmb!
-- !!AutoDetect!! // 自動判別！

select mb.MEMBER_ID
     , mb.MEMBER_NAME
     , mb.BIRTHDATE
     , mb.MEMBER_STATUS_CODE
     , serv.SERVICE_POINT_COUNT
 from MEMBER mb
   inner join MEMBER_SERVICE serv
     on serv.MEMBER_ID = mb.MEMBER_ID
 /*BEGIN*/
 where
   /*IF pmb.memberId != null*/
   mb.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*IF pmb.memberName != null*/
   and mb.MEMBER_NAME like /*pmb.memberName*/'M%'
   /*END*/
   /*IF pmb.memberStatusCode != null*/
   and mb.MEMBER_STATUS_CODE = /*pmb.memberStatusCode:ref(MEMBER)| // 非必須、等値 */'FML'
   /*END*/
 /*END*/
