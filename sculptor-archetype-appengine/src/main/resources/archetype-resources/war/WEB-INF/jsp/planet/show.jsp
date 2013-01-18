#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
    <c:if test="${symbol_dollar}{not empty planet}">
        <div id="planet_name">
            <label for="_name">Name:</label>
            <div class="box" id="_name">${symbol_dollar}{planet.name}</div>
        </div>
        <br/>
        <div id="planet_message">
            <label for="_message">Message:</label>
            <div class="box" id="_message">${symbol_dollar}{planet.message}</div>
        </div>
        <br/>
    </c:if>
    <c:if test="${symbol_dollar}{empty planet}">No Request found with this id.</c:if>
    
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
