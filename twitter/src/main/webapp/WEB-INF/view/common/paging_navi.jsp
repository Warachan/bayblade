<%@page pageEncoding="UTF-8"%>
<%-- 
pagingNavi という名前で Action から PagingNavigation が取得できることが前提。
とりあえず href に関しては、f:u()ファンクションを利用しない (URLの見た目重視) 
--%> 
検索結果${f:h(pagingNavi.allRecordCount)}件
<c:if test="${pagingNavi.displayPagingNavi}">
<div class="pagingnavi">
	<c:if test="${pagingNavi.existPrePage}">
		<s:link href="${f:h(pagingNavi.prePageLinkHref)}">前へ</s:link>
	</c:if>
	<c:forEach var="links" items="${pagingNavi.pageNumberLinkList}">
		<c:if test="${!links.current}">
			<span id="pageNumberElement"><s:link href="${f:h(links.pageNumberLinkHref)}">${f:h(links.pageNumberElement)}</s:link></span>
		</c:if>
		<c:if test="${links.current}">
			<span id="pageNumberElement">${f:h(links.pageNumberElement)}</span>
		</c:if>
	</c:forEach>
	[${f:h(pagingNavi.currentPageNumber)}/${f:h(pagingNavi.allPageCount)}]
	<c:if test="${pagingNavi.existNextPage}">
		<s:link href="${f:h(pagingNavi.nextPageLinkHref)}">次へ</s:link>
	</c:if>
</div>
</c:if>
