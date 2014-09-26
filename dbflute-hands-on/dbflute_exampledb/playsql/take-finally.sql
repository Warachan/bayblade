-- #df:assertListZero#
-- /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
-- Member addresses should be only one at any time.
-- - - - - - - - - - -/
　select adr.MEMBER_ADDRESS_ID
	, adr.MEMBER_ID
	, adr.VALID_BEGIN_DATE
	, adr.VALID_END_DATE
	, adr.ADDRESS
  from MEMBER_ADDRESS adr
 where exists (select subadr.MEMBER_ADDRESS_ID
                 from MEMBER_ADDRESS subadr
                where subadr.MEMBER_ID = adr.MEMBER_ID
                  and subadr.VALID_BEGIN_DATE > adr.VALID_BEGIN_DATE
                  and subadr.VALID_BEGIN_DATE <= adr.VALID_END_DATE
       )
;

-- #df:assertListZero#
-- /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
-- Provisinal members should not have formalized date time.
-- - - - - - - - - - -/
　select member.MEMBER_ID
	, member.MEMBER_NAME
	, member.MEMBER_ACCOUNT
	, member.MEMBER_STATUS_CODE
	, member.FORMALIZED_DATETIME
  from MEMBER member
 where member.MEMBER_STATUS_CODE = 'PRV'
   and member.FORMALIZED_DATETIME is not null
;

-- #df:assertListZero#
-- /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
-- All member's should not be after the current date.
-- - - - - - - - - - -/
　select member.MEMBER_ID
	, member.MEMBER_NAME
	, member.MEMBER_ACCOUNT
	, member.MEMBER_STATUS_CODE
	, member.BIRTHDATE
  from MEMBER member
 where member.BIRTHDATE > now()
;

-- #df:assertListZero#
-- /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
-- Withdrawal members must have withdrawal data.
-- - - - - - - - - - -/
　select member.MEMBER_ID
	,member.MEMBER_NAME
  from MEMBER member
 where member.MEMBER_STATUS_CODE = 'WDL'
   and not exists (select withdrawal.MEMBER_ID
                     from MEMBER_WITHDRAWAL withdrawal
                    where withdrawal.MEMBER_ID = member.MEMBER_ID
       )
;