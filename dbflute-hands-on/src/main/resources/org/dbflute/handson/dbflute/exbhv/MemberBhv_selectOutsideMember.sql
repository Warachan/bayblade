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
-- !!AutoDetect!!

select
      member.MEMBER_ID
     ,member.MEMBER_NAME
     ,member.BIRTHDATE
     ,member.MEMBER_STATUS_CODE
     ,service.AKIRAKANI_OKASHII_KARAMU_MEI
  from member member
  inner join member_service service
  on service.member_id = member.member_id
  /*BEGIN*/
  where
   /*IF pmb.memberId != null*/
   member.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*IF pmb.memberName != null*/
   and member.MEMBER_NAME like /*pmb.memberName*/'M%'
   /*END*/
   /*IF pmb.memberStatusCode != null*/
   and member.MEMBER_STATUS_CODE = /*pmb.memberStatusCode*/'FML'
   /*END*/
  /*END*/
