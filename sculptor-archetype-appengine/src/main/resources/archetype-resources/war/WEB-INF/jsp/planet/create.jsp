#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Planet</h2>
    <form:form action="/rest/planet" method="POST" modelAttribute="planet">
        <div id="planet_name">
            <label for="_name">Name:</label>
            <form:input cssStyle="width:300px" id="_name" path="name"/>
            <br/>
            <form:errors cssClass="errors" id="_name" path="name"/>
        </div>
        <div id="planet_message">
            <label for="_message">Message:</label>
            <form:textarea cssStyle="width:300px" id="_message" rows="3" cols="60" path="message"/>
            <br/>
            <form:errors cssClass="errors" id="_message" path="message"/>
        </div>
        <br/>
        <div class="submit" id="planet_submit">
            <input id="proceed" type="submit" value="Save"/>
        </div>
    </form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
