<%@ page import="qmw.Item" %>


    <div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'tipo', 'error')} ">
        <label for="tipo">
            <g:message code="item.tipo.label" default="Tipo" />
            <span class="required-indicator">*</span>
        </label>
        <g:select name="tipo" required=""  from="${itemInstance.constraints.tipo.inList}" value="${itemInstance?.tipo}" valueMessagePrefix="item.tipo" noSelection="['': '']"/>
        <g:helpBalloon code="item.tipo.label"/>
    </div>

    <div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'descricao', 'error')} ">
        <label for="descricao">
            <g:message code="item.descricao.label" default="Descricao" />
            <span class="required-indicator">*</span>

        </label>
        <g:textField name="descricao" required=""  maxlength="22" size="20" value="${itemInstance?.descricao}"/>
        <g:helpBalloon code="item.descricao.label"/>
    </div>
    <g:if test="${session.estab && session.estab.documento.equals('101010')}">
    <div class="fieldcontain ${hasErrors(bean: itemInstance, field: 'aprovado', 'error')} ">
        <label for="aprovado">
            <g:message code="item.aprovado.label" default="aprovado" />

        </label>
        <g:checkBox name="aprovado" value="${itemInstance?.aprovado}" />
        <g:helpBalloon code="item.aprovado.label"/>
    </div>
    </g:if>
</div>


