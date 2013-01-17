#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
    <c:if test="${symbol_dollar}{not empty planetList}">
    <table>
    	<thead>
    		<th>ID</th>
    		<th>Name</th>
    		<th>Message</th>
    		<th/>
    		<th/>
    		<th/>
    	</thead>
    	<c:forEach items="${symbol_dollar}{planetList}" var="planet">
    		<tr>
    			<td>
    				<a href="<c:url value="/rest/planet/${symbol_dollar}{planet.id.id}" />">${symbol_dollar}{planet.id.id}</a>
    			</td>
    			<td>
    				${symbol_dollar}{planet.name}
    			</td>
    			<td>
    				${symbol_dollar}{planet.message}
    			</td>
    			<td>
                    <form:form action="/rest/planet/${symbol_dollar}{planet.id.id}" method="GET">
                        <input alt="Show Planet" src="/images/show.png" title="Show Planet" type="image" value="Show Planet"/>
                    </form:form>
                </td>
    			<td>
    				<form:form action="/rest/planet/${symbol_dollar}{planet.id.id}/form" method="GET">
                            <input alt="Update Planet" src="/images/update.png" title="Update Planet" type="image" value="Update Planet"/>
                    </form:form>
    			</td>
    			<td>
                    <form:form action="/rest/planet/${symbol_dollar}{planet.id.id}" method="DELETE">
                        <input alt="Delete Planet" src="/images/delete.png" title="Delete Planet" type="image" value="Delete Planet"/>
                    </form:form>
                </td>
    		</tr>
    	</c:forEach>
    </table>
    </c:if>
    <c:if test="${symbol_dollar}{empty planetList}">There are no planets yet.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
